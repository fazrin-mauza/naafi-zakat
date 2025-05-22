/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reports;

import net.sf.jasperreports.engine.JasperCompileManager;

public class JrxmlCompiler {

    public static void main(String[] args) {
        try {
            // Path ke file .jrxml
            String jrxmlPath = "src/reports/LaporanPembayaran.jrxml";
           //  String jrxmlPath = "src/reports/LaporanPenyaluran.jrxml";
                              // Path output file .jasper
           String jasperPath = "src/reports/LaporanPembayaran.jasper";
        //      String jasperPath = "src/reports/LaporanPenyaluran.jasper";
            // Compile JRXML ke JASPER
            JasperCompileManager.compileReportToFile(jrxmlPath, jasperPath);

            System.out.println("✔ Kompilasi selesai: " + jasperPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
