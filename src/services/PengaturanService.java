package services;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class PengaturanService {
    
    public String getHargaEmas() {
    String sql = "SELECT harga_emas_85gram FROM config WHERE id = 1";
    Connection conn2 = DBConnection.getConnection();

    try {
        PreparedStatement stmt = conn2.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getString("harga_emas_85gram");
        } else {
            return "0";
        }
    } catch (SQLException e) {
        System.err.println("Gagal mengambil harga emas: " + e.getMessage());
        return "0";
    }
    
}


     public String emasUpdate(String emas) {
        if (emas.isEmpty()) {
            return "Harga tidak valid!";
        }

        boolean success = updateEmas(emas);
        return success ? "success" : "Gagal mengupdate data harga Emas. Silakan coba lagi.";
    }

    private boolean updateEmas(String emas) {
        Connection conn = DBConnection.getConnection();
        String updateEmas = "UPDATE config SET harga_emas_85gram=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(updateEmas)) {
                stmt.setString(1, emas);
                stmt.setInt(2, 1);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error update harga emas: " + e.getMessage());
            return false;
        }
    }
      public static boolean updateHargakMakananPokok(String harga) {
        Connection conn = DBConnection.getConnection();
        double harga_kg = Double.parseDouble(harga);
        String updateHarga = "UPDATE lembaga SET harga_kg=? WHERE nama=?";
        try (PreparedStatement stmt = conn.prepareStatement(updateHarga)) {
           Map<String, String> data = helper.Function.getSessionAndMasjid();
                stmt.setDouble(1, harga_kg);    
                stmt.setString(2, data.get("nama_masjid"));
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error update harga Makanan Pokok: " + e.getMessage());
            return false;
        }
    }
   public static boolean updateHargakSha(String harga) {
        Connection conn = DBConnection.getConnection();
        double harga_kg = Double.parseDouble(harga);
        String updateHarga = "UPDATE lembaga SET harga=? WHERE nama=?";
        try (PreparedStatement stmt = conn.prepareStatement(updateHarga)) {
           Map<String, String> data = helper.Function.getSessionAndMasjid();
                stmt.setDouble(1, harga_kg);    
                stmt.setString(2, data.get("nama_masjid"));
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error update harga Sha: " + e.getMessage());
            return false;
        }
    }
   
   public static boolean updateBungkus(String besaran) {
        Connection conn = DBConnection.getConnection();
        double besaranDouble = Double.parseDouble(besaran);
        String updateHarga = "UPDATE lembaga SET bungkus=? WHERE nama=?";
        try (PreparedStatement stmt = conn.prepareStatement(updateHarga)) {
           Map<String, String> data = helper.Function.getSessionAndMasjid();
                stmt.setDouble(1, besaranDouble);    
                stmt.setString(2, data.get("nama_masjid"));
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error update harga Sha: " + e.getMessage());
            return false;
        }
    }
    
public static int getPembagian(String golongan) {
    int bungkus = 0;
    Connection conn = DBConnection.getConnection();
    String sql = "SELECT bungkus FROM pembagian WHERE golongan = ?";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, golongan);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                bungkus = rs.getInt("bungkus");
            }
        }
    } catch (SQLException e) {
        System.err.println("Gagal mengambil bungkus untuk golongan " + golongan + ": " + e.getMessage());
    }

    return bungkus;
}
public static Map<String, Integer> getPembagianSemua() {
    Map<String, Integer> pembagianData = new HashMap<>();
    Connection conn = DBConnection.getConnection();
    String sql = "SELECT golongan, bungkus FROM pembagian";

    try (PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        
        while (rs.next()) {
            String golongan = rs.getString("golongan");
            int bungkus = rs.getInt("bungkus");
            pembagianData.put(golongan, bungkus);
        }
    } catch (SQLException e) {
        System.err.println("Gagal mengambil seluruh data pembagian: " + e.getMessage());
    }

    return pembagianData;
}

public static boolean updatePembagian(Map<String, Integer> dataPembagian) {
    Connection conn = DBConnection.getConnection();
    String sql = "UPDATE pembagian SET bungkus = ? WHERE golongan = ?";
    boolean success = true;

    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        for (Map.Entry<String, Integer> entry : dataPembagian.entrySet()) {
            ps.setInt(1, entry.getValue());
            ps.setString(2, entry.getKey());
            ps.addBatch();
        }

        int[] results = ps.executeBatch();
        for (int result : results) {
            if (result == 0) {
                success = false; // salah satu update gagal (tidak ada baris terpengaruh)
            }
        }
    } catch (SQLException e) {
        System.err.println("Gagal mengupdate data pembagian: " + e.getMessage());
        success = false;
    }

    return success;
}

public static String estimasiPembagian(Map<String, Double> pembagianPerGolongan, double isiPerBungkus) {
        StringBuilder keteranganBuilder = new StringBuilder();

        try {
            // Ambil stok beras dari service
            BerandaService.BerandaData dataNya = BerandaService.getBerandaData();
            double stokBeras = dataNya.getBeras();
            double totalBerasDisalurkan = 0;
            int totalBungkus = 0;

            // Hitung total beras dan bungkus berdasarkan database mustahiq
            String sql = "SELECT golongan, COUNT(*) as jumlah FROM mustahiq GROUP BY golongan";
            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    String gol = rs.getString("golongan");
                    int jumlahOrang = rs.getInt("jumlah");

                    double bungkusPerOrang = pembagianPerGolongan.getOrDefault(gol, 0.0);
                    double totalGolongan = jumlahOrang * bungkusPerOrang * isiPerBungkus;

                    totalBerasDisalurkan += totalGolongan;
                    totalBungkus += (int)(jumlahOrang * bungkusPerOrang);
                }
            }

            double sisa = stokBeras - totalBerasDisalurkan;

            // Format keterangan hasil
            keteranganBuilder.append("📦 Jumlah Makanan Pokok Terkumpul: ")
                             .append(stokBeras)
                             .append(" Kg\n");

            keteranganBuilder.append("🎯 Kebutuhan Penyaluran: ")
                             .append(totalBungkus)
                             .append(" bungkus (")
                             .append(String.format("%.2f", totalBerasDisalurkan))
                             .append(" Kg)\n");

            if (sisa > 0) {
                keteranganBuilder.append("✅ Masih ada sisa: ")
                                 .append(String.format("%.2f", sisa))
                                 .append(" Kg\n")
                                 .append("💡 Rekomendasi: Anda bisa menambah jumlah bungkus pada golongan tertentu jika diperlukan.");
            } else if (sisa < 0) {
                keteranganBuilder.append("❌ Kekurangan: ")
                                 .append(String.format("%.2f", Math.abs(sisa)))
                                 .append(" Kg\n")
                                 .append("⚠️ Rekomendasi: Kurangi jumlah pembagian per golongan atau tambahkan stok beras.");
            } else {
                keteranganBuilder.append("✔️ Pas! Stok dan kebutuhan seimbang.");
            }

        } catch (Exception e) {
            keteranganBuilder.setLength(0);
            keteranganBuilder.append("❗ Terjadi kesalahan: ").append(e.getMessage());
            e.printStackTrace();
        }

        return keteranganBuilder.toString();
    }

public static int getJumlahMustahiq(String golongan) {
    String sql = "SELECT COUNT(*) FROM mustahiq WHERE golongan = ?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, golongan);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return 0;
}
}
