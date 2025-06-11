package services;

import db.DBConnection;
import db.FlexibleDBConnection;
import helper.Function;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PenyaluranService {

       public List<String> getNamaMustahiq() {
    List<String> mustahiqList = new ArrayList<>();
    try {
        Connection con = DBConnection.getConnection();
        String sql = """
            SELECT nama 
            FROM mustahiq 
            WHERE nama NOT IN (
                SELECT nama_mustahiq FROM penyaluran
            )
        """;
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            mustahiqList.add(rs.getString("nama"));
        }

        rs.close();
        ps.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return mustahiqList;
}

        
    public MustahiqData getDetailMustahiqByNama(String nama) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT umur, alamat,rt,rw, golongan, jenis_kelamin FROM mustahiq WHERE nama = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nama);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int umur = rs.getInt("umur");
                String alamat = rs.getString("alamat");
                String rt = rs.getString("rt");
                String rw = rs.getString("rw");
                String alamatLengkap = "RT "+rt+"/RW "+rw+", "+alamat;
                String golongan = rs.getString("golongan");
                String gender = rs.getString("jenis_kelamin");
                return new MustahiqData(umur, alamatLengkap, golongan, gender);
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Inner class untuk menyimpan data Mustahiq
    public static class MustahiqData {
        private int umur;
        private String alamat;
        private String golongan;
        private String gender;

        public MustahiqData(int umur, String alamat, String golongan, String gender) {
            this.umur = umur;
            this.alamat = alamat;
            this.golongan = golongan;
            this.gender = gender;
        }

        public int getUmur() {
            return umur;
        }

        public String getAlamat() {
            return alamat;
        }

        public String getGolongan() {
            return golongan;
        }
        
         public String getGender() {
            return gender;
        }
    }
    
    public String buatPenyaluran(String nama_mustahiq, String golongan, int umur, String jenis_kelamin, String alamat, String jumlah_disalurkan, String amil, String toString, String toString1) {
    jumlah_disalurkan = jumlah_disalurkan.replaceAll("[^0-9.]", "");
    if (nama_mustahiq.isEmpty() || golongan.isEmpty() || jenis_kelamin.isEmpty()|| alamat.isEmpty()|| jumlah_disalurkan.isEmpty()|| amil.isEmpty()) {
       return "Semua field wajib diisi!";
    }
    double double_jumlahDisalurkan = Double.parseDouble((String) jumlah_disalurkan);
    if (umur < 1 || double_jumlahDisalurkan < 1) {
       return "Umur atau jumlah total disalurkan tidak boleh kurang dari 1!";
    }
   
    String date = Function.getCurrentDate();
    String time = Function.getCurrentTime();
    
     boolean success = createPenyaluran(nama_mustahiq, golongan, umur, jenis_kelamin, alamat,
                                        double_jumlahDisalurkan, amil, date, time);
     return success ? "success" : "Gagal menyimpan data penyaluran. Silakan coba lagi.";
}

private boolean createPenyaluran(String nama_mustahiq, String golongan, int umur,String jenis_kelamin, String alamat,
                                 double jumlah_disalurkan, String amil,
                                 String tanggal, String waktu) {
    Connection conn = DBConnection.getConnection();
    
    try {
        if (conn == null || conn.isClosed()) {
            conn = DBConnection.getConnection(); // Paksa koneksi baru jika tertutup
        }

        String sql = "INSERT INTO penyaluran (nama_mustahiq, golongan, umur, jenis_kelamin, alamat, jumlah_disalurkan, amil, date, time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nama_mustahiq);
            stmt.setString(2, golongan);
            stmt.setInt(3, umur);
            stmt.setString(4, jenis_kelamin);
            stmt.setString(5, alamat);
            stmt.setDouble(6, jumlah_disalurkan);
            stmt.setString(7, amil);
            stmt.setString(8, tanggal);
            stmt.setString(9, waktu);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                String updateSql = "UPDATE total SET beras = beras - ?";
                try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                    updateStmt.setDouble(1, jumlah_disalurkan);
                    updateStmt.executeUpdate();
                }
            }
            return rowsAffected > 0;
        }
    } catch (SQLException e) {
        System.err.println("Error creating penyaluran: " + e.getMessage());
        return false;
    }
}

    
public static double cekPembagian(String golongan) {
    String sql = "SELECT " + golongan + " FROM pembagian WHERE id = 1";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        
        if (rs.next()) {
            return rs.getDouble(golongan);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return 0.0; // Jika error atau data tidak ditemukan
}

////// kode masal
// Tetap sama
public static class PenyaluranMetadata {
    public int totalMustahiq;
    public double totalDisalurkan;
    public double sisaBeras;
    public Map<String, Integer> jumlahPerGolongan = new HashMap<>();
    public Map<String, Double> pembagianPerGolongan = new HashMap<>();
}

public PenyaluranMetadata buatPenyaluranSemuaDetail(String amil) {
    PenyaluranMetadata meta = new PenyaluranMetadata();

    try (Connection conn = FlexibleDBConnection.getNewConnection()) {

        // Ambil daftar mustahiq yang belum disalurkan
        String sqlMustahiq = """
            SELECT nama, golongan FROM mustahiq 
            WHERE nama NOT IN (SELECT nama_mustahiq FROM penyaluran)
        """;

        try (PreparedStatement ps = conn.prepareStatement(sqlMustahiq);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String gol = rs.getString("golongan");
                meta.totalMustahiq++;
                meta.jumlahPerGolongan.put(gol, meta.jumlahPerGolongan.getOrDefault(gol, 0) + 1);
            }
        }

        // Hitung total beras berdasarkan pembagian
        for (String gol : meta.jumlahPerGolongan.keySet()) {
            double perOrang = ambilPembagianLangsung(conn, gol);
            meta.pembagianPerGolongan.put(gol, perOrang);
            meta.totalDisalurkan += perOrang * meta.jumlahPerGolongan.get(gol);
        }

        // Cek sisa beras sekarang
        String sqlSisa = "SELECT beras FROM total LIMIT 1";
        try (PreparedStatement ps = conn.prepareStatement(sqlSisa);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                meta.sisaBeras = rs.getDouble("beras") - meta.totalDisalurkan;
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return meta;
}
public String buatPenyaluranSemua(String amil) {
    try (Connection conn = FlexibleDBConnection.getNewConnection()) {
        conn.setAutoCommit(false); // transactional

        String sqlSelect = """
            SELECT m.nama, m.umur, m.alamat, m.rt, m.rw, m.golongan, m.jenis_kelamin 
            FROM mustahiq m
            WHERE m.nama NOT IN (SELECT nama_mustahiq FROM penyaluran)
        """;

        try (PreparedStatement ps = conn.prepareStatement(sqlSelect);
             ResultSet rs = ps.executeQuery()) {

            double totalDisalurkan = 0;

            while (rs.next()) {
                String nama = rs.getString("nama");
                int umur = rs.getInt("umur");
                String alamat = "RT " + rs.getString("rt") + "/RW " + rs.getString("rw") + ", " + rs.getString("alamat");
                String gol = rs.getString("golongan");
                String gender = rs.getString("jenis_kelamin");

                double jml = ambilPembagianLangsung(conn, gol);
                totalDisalurkan += jml;

                String date = Function.getCurrentDate();
                String time = Function.getCurrentTime();

                String sqlInsert = "INSERT INTO penyaluran (nama_mustahiq, golongan, umur, jenis_kelamin, alamat, jumlah_disalurkan, amil, date, time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement insertStmt = conn.prepareStatement(sqlInsert)) {
                    insertStmt.setString(1, nama);
                    insertStmt.setString(2, gol);
                    insertStmt.setInt(3, umur);
                    insertStmt.setString(4, gender);
                    insertStmt.setString(5, alamat);
                    insertStmt.setDouble(6, jml);
                    insertStmt.setString(7, amil);
                    insertStmt.setString(8, date);
                    insertStmt.setString(9, time);
                    insertStmt.executeUpdate();
                }
            }

            // Update stok beras
            String sqlUpdate = "UPDATE total SET beras = beras - ?";
            try (PreparedStatement updateStmt = conn.prepareStatement(sqlUpdate)) {
                updateStmt.setDouble(1, totalDisalurkan);
                updateStmt.executeUpdate();
            }

            conn.commit();
            return "Penyaluran berhasil dilakukan ke semua mustahiq.";
        } catch (Exception e) {
            conn.rollback();
            return "Penyaluran gagal: " + e.getMessage();
        } finally {
            conn.setAutoCommit(true);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return "Penyaluran gagal karena masalah database.";
    }
}
private double ambilPembagianLangsung(Connection conn, String golongan) {
    double hasil = 0;

    // Validasi nama kolom agar aman dari SQL injection
    List<String> kolomValid = List.of(
        "Fakir", "Miskin", "Amil", "Muallaf", "Riqab",
        "Gharim", "Fii_Sabilillah", "Ibnu_Sabil"
    );

    if (!kolomValid.contains(golongan)) {
        System.err.println("Golongan tidak valid: " + golongan);
        return 0;
    }

    String sql = "SELECT \"" + golongan + "\" FROM pembagian WHERE nama = 'main' LIMIT 1";

    try (PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
            hasil = rs.getDouble(1); // ambil kolom pertama dari hasil query dinamis
        }
    } catch (SQLException e) {
        System.err.println("Gagal ambil jumlah pembagian untuk golongan: " + golongan);
        e.printStackTrace();
    }

    return hasil;
}


}
