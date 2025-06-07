package helper;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextArea;
import java.util.regex.*;

public class Function {
    
    // Fungsi tambahan untuk mengambil nilai session dan nama masjid dari tabel config
 public static Map<String, String> getSessionAndMasjid() {
    Map<String, String> result = new HashMap<>();
    Connection conn = DBConnection.getConnection();
    String sql = "SELECT session, nama_masjid FROM config WHERE id = 1";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            result.put("session", rs.getString("session"));
            result.put("nama_masjid", rs.getString("nama_masjid"));
        }
    } catch (SQLException e) {
        System.err.println("Error getting session and masjid: " + e.getMessage());
    }

    return result;
}
    // Fungsi format ke Rupiah
    public static String formatRupiah(double amount) {
        Locale localeID = new Locale("in", "ID");
        NumberFormat format = NumberFormat.getCurrencyInstance(localeID);
        return format.format(amount);
    }

    // Fungsi angka ke teks terbilang
    public static String terbilang(long n) {
        String[] angka = {
            "", "satu", "dua", "tiga", "empat", "lima", "enam",
            "tujuh", "delapan", "sembilan", "sepuluh", "sebelas"
        };

        if (n < 12) return angka[(int)n];
        if (n < 20) return terbilang(n - 10) + " belas";
        if (n < 100) return terbilang(n / 10) + " puluh " + terbilang(n % 10);
        if (n < 200) return "seratus " + terbilang(n - 100);
        if (n < 1000) return terbilang(n / 100) + " ratus " + terbilang(n % 100);
        if (n < 2000) return "seribu " + terbilang(n - 1000);
        if (n < 1000000) return terbilang(n / 1000) + " ribu " + terbilang(n % 1000);
        if (n < 1000000000) return terbilang(n / 1000000) + " juta " + terbilang(n % 1000000);
        return "angka terlalu besar";
    }
    
     // Format tanggal & waktu
    public static String getCurrentTime() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
    public static String getCurrentDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    public static String getDateTime() {
        return getCurrentDate() + " " + getCurrentTime();
    }
    
public static String[] parseAlamat(String fullAlamat) {
    String teks = fullAlamat.trim();

    Pattern pattern = Pattern.compile("^(.*)\\s+RT\\s+(\\d+)/RW\\s+(\\d+)$", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(teks);

    if (matcher.matches()) {
        String alamat = matcher.group(1).trim();
        String rt = matcher.group(2);
        String rw = matcher.group(3);
        return new String[] { alamat, rt, rw };
    } else {
        return null; // atau bisa lempar IllegalArgumentException
    }
}

}
