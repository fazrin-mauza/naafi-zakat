package services;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MuzakkiCreateService {

    public String keluargaCreate(String namaKeluarga, String statusKeluarga, String alamat, String handphone, int jumlah) {
        if (namaKeluarga.isEmpty() || statusKeluarga.isEmpty() || alamat.isEmpty() || handphone.isEmpty()) {
            return "Semua field wajib diisi!";
        }

        // UPPERCASE semua inputan sebelum diproses
        namaKeluarga = namaKeluarga.toUpperCase();
        statusKeluarga = statusKeluarga.toUpperCase();
        alamat = alamat.toUpperCase();
        handphone = handphone.toUpperCase();

        if (isKeluargaExist(namaKeluarga)) {
            return "Nama keluarga "+namaKeluarga+" sudah terdaftar.";
        }

        boolean success = createKeluarga(namaKeluarga, statusKeluarga, alamat, handphone, jumlah);
        return success ? "success" : "Gagal membuat keluarga. Silakan coba lagi.";
    }

    public boolean createKeluarga(String namaKeluarga, String statusKeluarga, String alamat, String handphone, int jumlah) {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO keluarga (nama, status, alamat, handphone, jumlah) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, namaKeluarga);
            stmt.setString(2, statusKeluarga);
            stmt.setString(3, alamat);
            stmt.setString(4, handphone);
            stmt.setInt(5, jumlah);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error insert keluarga: " + e.getMessage());
            return false;
        }
    }

    public String anggotaCreate(String namaKeluarga, String namaAnggota, String status, String jenisKelamin) {
        if (namaKeluarga.isEmpty() || namaAnggota.isEmpty() || status.isEmpty() || jenisKelamin.isEmpty()) {
            return "Semua field wajib diisi!";
        }

        // UPPERCASE semua inputan sebelum diproses
        namaKeluarga = namaKeluarga.toUpperCase();
        namaAnggota = namaAnggota.toUpperCase();
        status = status.toUpperCase();
        jenisKelamin = jenisKelamin.toUpperCase();

        if (isAnggotaExist(namaKeluarga, namaAnggota)) {
            return "Nama anggota sudah ada dalam keluarga ini.";
        }

        boolean success = createAnggota(namaKeluarga, namaAnggota, status, jenisKelamin);
        return success ? "success" : "Gagal membuat anggota keluarga. Silakan coba lagi.";
    }

private boolean createAnggota(String namaKeluarga, String namaAnggota, String status, String jenisKelamin) {
    Connection conn = DBConnection.getConnection();
    String sqlAnggota = "INSERT INTO anggota_keluarga (keluarga, nama, status, jenis_kelamin) VALUES (?, ?, ?, ?)";

    try (PreparedStatement stmt = conn.prepareStatement(sqlAnggota)) {
        stmt.setString(1, namaKeluarga);
        stmt.setString(2, namaAnggota);
        stmt.setString(3, status);
        stmt.setString(4, jenisKelamin);

        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            updateJumlahAnggota(namaKeluarga);
            return true;
        } else {
            return false;
        }
    } catch (SQLException e) {
        System.err.println("Error insert anggota: " + e.getMessage());
        return false;
    }
}

private void updateJumlahAnggota(String namaKeluarga) {
    Connection conn = DBConnection.getConnection();
    String sqlCount = "SELECT COUNT(*) FROM anggota_keluarga WHERE UPPER(keluarga) = ?";
    String sqlUpdate = "UPDATE keluarga SET jumlah = ? WHERE UPPER(nama) = ?";

    try (PreparedStatement countStmt = conn.prepareStatement(sqlCount);
         PreparedStatement updateStmt = conn.prepareStatement(sqlUpdate)) {

        countStmt.setString(1, namaKeluarga);
        ResultSet rs = countStmt.executeQuery();

        if (rs.next()) {
            int jumlah = rs.getInt(1);

            updateStmt.setInt(1, jumlah);
            updateStmt.setString(2, namaKeluarga);

            int updatedRows = updateStmt.executeUpdate();
            if (updatedRows > 0) {
                System.out.println("Jumlah anggota keluarga berhasil diupdate: " + jumlah);
            } else {
                System.out.println("Update jumlah keluarga gagal: keluarga tidak ditemukan.");
            }
        }
    } catch (SQLException e) {
        System.err.println("Error update jumlah anggota: " + e.getMessage());
    }
}


    private boolean isKeluargaExist(String namaKeluarga) {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT COUNT(*) FROM keluarga WHERE UPPER(nama) = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, namaKeluarga);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error checking keluarga: " + e.getMessage());
        }
        return false;
    }

    private boolean isAnggotaExist(String namaKeluarga, String namaAnggota) {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT COUNT(*) FROM anggota_keluarga WHERE UPPER(keluarga) = ? AND UPPER(nama) = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, namaKeluarga);
            stmt.setString(2, namaAnggota);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error checking anggota: " + e.getMessage());
        }
        return false;
    }
}
