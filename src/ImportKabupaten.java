import db.DBConnection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ImportKabupaten {
    public static void main(String[] args) {
        String csvFile = "provinces.csv"; // sesuaikan path-nya
        String line;
        String splitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            Connection conn = DBConnection.getConnection();
          //  String sql = "INSERT INTO districts (code, regency_code, name) VALUES (?, ?, ?)";
            String sql = "INSERT INTO provinces (code, name) VALUES ( ?, ?)";
        
         //String sql = "INSERT INTO villages (code, district_code, name) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitBy);
                if (data.length == 2) {
                    ps.setString(1, data[0].trim()); // code
                    ps.setString(2, data[1].trim()); // province_code
                    ps.addBatch();
                }
            }

            ps.executeBatch();
            System.out.println("Import selesai.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
