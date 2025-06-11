package auth;

import db.DBConnection;
import java.sql.Connection;
import services.AuthService;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import services.WilayahService;




public class Config extends javax.swing.JFrame {
 private String masjid;
    public Config(String masjidText) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.masjid = masjidText;
         lembagaBox.removeAllItems();
         lembagaBox.addItem(masjid); 
         lembagaBox.setSelectedItem(masjidText); 
         loadProvinsi();
               provinsiBox.setVisible(false);
               provinsi.setVisible(false);
               kabupatenBox.setVisible(false);
               kabupaten.setVisible(false);
               kecamatanBox.setVisible(false);
               kecamatan.setVisible(false);
               desaBox.setVisible(false);
               desa.setVisible(false);
  
    }
    
private void loadProvinsi() {
    try {
        List<String> provinsiList = WilayahService.getAllProvinsi();
        provinsiBox.removeAllItems(); 
        for (String prov : provinsiList) {
            provinsiBox.addItem(prov);
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error load provinsi: " + e.getMessage());
    }
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        wilayahBox = new javax.swing.JComboBox<>();
        desaBox = new javax.swing.JComboBox<>();
        provinsiBox = new javax.swing.JComboBox<>();
        kabupatenBox = new javax.swing.JComboBox<>();
        lembaga = new javax.swing.JLabel();
        wilayah = new javax.swing.JLabel();
        kabupaten = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        provinsi = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kecamatan = new javax.swing.JLabel();
        desa = new javax.swing.JLabel();
        create = new javax.swing.JButton();
        kecamatanBox = new javax.swing.JComboBox<>();
        lembagaBox = new javax.swing.JComboBox<>();
        bahan_pokokBox = new javax.swing.JComboBox<>();
        bahan_pokok = new javax.swing.JLabel();
        ukuranSha = new javax.swing.JLabel();
        shaBox = new javax.swing.JComboBox<>();
        hargaSha = new javax.swing.JLabel();
        hargaShaField = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        gamber = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 102));

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(820, 494));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        wilayahBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "Indonesia", "Provinsi", "Kabupaten / Kota", "Kecamatan", "Desa / Kelurahan" }));
        wilayahBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wilayahBoxActionPerformed(evt);
            }
        });
        jPanel2.add(wilayahBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 210, 30));

        desaBox.setEditable(true);
        desaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desaBoxActionPerformed(evt);
            }
        });
        jPanel2.add(desaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 210, 30));

        provinsiBox.setEditable(true);
        provinsiBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                provinsiBoxActionPerformed(evt);
            }
        });
        jPanel2.add(provinsiBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 210, 30));

        kabupatenBox.setEditable(true);
        kabupatenBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kabupatenBoxActionPerformed(evt);
            }
        });
        jPanel2.add(kabupatenBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 210, 30));

        lembaga.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        lembaga.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lembaga.setText("Nama Lembaga");
        jPanel2.add(lembaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 40));

        wilayah.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        wilayah.setText("Cakupan Wilayah");
        jPanel2.add(wilayah, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 20));

        kabupaten.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        kabupaten.setText("Kabupaten / Kota");
        jPanel2.add(kabupaten, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("X");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        provinsi.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        provinsi.setText("Provinsi");
        jPanel2.add(provinsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 150, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 27)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Pengaturan");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 190, 40));

        kecamatan.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        kecamatan.setText("Kecamatan");
        jPanel2.add(kecamatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 120, 20));

        desa.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        desa.setText("Desa / Kelurahan");
        jPanel2.add(desa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 140, 20));

        create.setBackground(new java.awt.Color(0, 255, 0));
        create.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        create.setText("Create");
        create.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        create.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createMouseClicked(evt);
            }
        });
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });
        jPanel2.add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 80, 30));

        kecamatanBox.setEditable(true);
        kecamatanBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kecamatanBoxActionPerformed(evt);
            }
        });
        jPanel2.add(kecamatanBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 210, 30));

        lembagaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lembagaBoxActionPerformed(evt);
            }
        });
        jPanel2.add(lembagaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 210, 30));

        bahan_pokokBox.setEditable(true);
        bahan_pokokBox.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        bahan_pokokBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Beras", "Gandum", "Jagung", "Keju", "Kentang", "Kismis", "Kurma", "Labu kuning", "Sagu", "Singkong", "Talas", "Ubi jalar" }));
        bahan_pokokBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bahan_pokokBoxActionPerformed(evt);
            }
        });
        jPanel2.add(bahan_pokokBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 210, 30));

        bahan_pokok.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        bahan_pokok.setText(" Bahan Makanan Pokok");
        jPanel2.add(bahan_pokok, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 160, 60));

        ukuranSha.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        ukuranSha.setText("Ukuran sha' (Kg)");
        jPanel2.add(ukuranSha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 100, 20));

        shaBox.setEditable(true);
        shaBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3.0", "2.8", "2.7", "2.6", "2.5" }));
        shaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shaBoxActionPerformed(evt);
            }
        });
        jPanel2.add(shaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 100, -1));

        hargaSha.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        hargaSha.setText("Harga sha' (Rp)");
        jPanel2.add(hargaSha, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 100, 20));

        hargaShaField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        hargaShaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaShaFieldActionPerformed(evt);
            }
        });
        jPanel2.add(hargaShaField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 100, -1));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(460, 10, 290, 490);

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SAATNYA BERBAGI");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(110, 410, 200, 20);

        jLabel3.setFont(new java.awt.Font("Rockwell", 1, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText(" DI MULAI DARI SINI");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(130, 430, 160, 20);

        jLabel4.setFont(new java.awt.Font("Rockwell", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("SAATNYA PEDULI");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(110, 390, 200, 20);

        gamber.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        gamber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Login-amico (1) (1) (1) (2).png"))); // NOI18N
        jPanel1.add(gamber);
        gamber.setBounds(80, 70, 280, 290);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
  // Ambil nilai dari GUI
    String nama = (String) lembagaBox.getSelectedItem();
    String makananPokok = (String) bahan_pokokBox.getSelectedItem();
    String shaStr = (String) shaBox.getSelectedItem();
    String hargaStr = hargaShaField.getText();
    hargaStr = hargaStr.replace(",", "");
    String cakupan = (String) wilayahBox.getSelectedItem();
    String provinsiText = (String) provinsiBox.getSelectedItem();
    String kabupatenText = (String) kabupatenBox.getSelectedItem();
    String kecamatanText = (String) kecamatanBox.getSelectedItem();
    String desaText = (String) desaBox.getSelectedItem();

    // Validasi input wajib
    if (nama == null || nama.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Nama lembaga harus diisi!");
        return;
    }
    if (shaStr == null || shaStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "SHA harus dipilih!");
        return;
    }
    if (hargaStr == null || hargaStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Harga SHA harus diisi!");
        return;
    }

    // Konversi sha dan harga ke double dengan try-catch
        double sha = Double.parseDouble(shaStr);
        double harga = Double.parseDouble(hargaStr);
   

    // Panggil method insertLembaga (pastikan method ini menerima parameter double)
    boolean berhasil = WilayahService.insertLembaga(
        nama,
        makananPokok,
        sha,
        harga,
        cakupan,
        provinsiText,
        kabupatenText,
        kecamatanText,
        desaText
    );

    if (berhasil) {
        this.dispose(); 
        Login lgf = new Login();
        lgf.setVisible(true);
    } else {
        JOptionPane.showMessageDialog(this, "Gagal menyimpan data lembaga.");
    }
    }//GEN-LAST:event_createActionPerformed

    private void createMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_createMouseClicked

    private void wilayahBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wilayahBoxActionPerformed
    String selectedWilayah = wilayahBox.getSelectedItem().toString();

    if (selectedWilayah.equalsIgnoreCase("Provinsi")) {
               provinsiBox.setVisible(true);
               provinsi.setVisible(true);
               kabupatenBox.setVisible(false);
               kabupaten.setVisible(false);
               kecamatanBox.setVisible(false);
               kecamatan.setVisible(false);
               desaBox.setVisible(false);
               desa.setVisible(false);
    } else if (selectedWilayah.equalsIgnoreCase("Kabupaten / Kota")) {
               provinsiBox.setVisible(true);
               provinsi.setVisible(true);
               kabupatenBox.setVisible(true);
               kabupaten.setVisible(true);
               kecamatanBox.setVisible(false);
               kecamatan.setVisible(false);
               desaBox.setVisible(false);
               desa.setVisible(false);
     } else if (selectedWilayah.equalsIgnoreCase("Kecamatan")) {
               provinsiBox.setVisible(true);
               provinsi.setVisible(true);
               kabupatenBox.setVisible(true);
               kabupaten.setVisible(true);
               kecamatanBox.setVisible(true);
               kecamatan.setVisible(true);
               desaBox.setVisible(false);
               desa.setVisible(false);
     } else if (selectedWilayah.equalsIgnoreCase("Desa / Kelurahan")) {
               provinsiBox.setVisible(true);
               provinsi.setVisible(true);
               kabupatenBox.setVisible(true);
               kabupaten.setVisible(true);
               kecamatanBox.setVisible(true);
               kecamatan.setVisible(true);
               desaBox.setVisible(true);
               desa.setVisible(true);
     } else {
               provinsiBox.setVisible(false);
               provinsi.setVisible(false);
               kabupatenBox.setVisible(false);
               kabupaten.setVisible(false);
               kecamatanBox.setVisible(false);
               kecamatan.setVisible(false);
               desaBox.setVisible(false);
               desa.setVisible(false);
    }
    }//GEN-LAST:event_wilayahBoxActionPerformed

    private void desaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desaBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desaBoxActionPerformed

    private void provinsiBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_provinsiBoxActionPerformed
String selectedProvinsi = (String) provinsiBox.getSelectedItem();
List<String> kabupatenList = WilayahService.getAllKabupatenByProvinsiName(selectedProvinsi);
kabupatenBox.removeAllItems();
for (String kab : kabupatenList) {
    kabupatenBox.addItem(kab);
}
    }//GEN-LAST:event_provinsiBoxActionPerformed

    private void kabupatenBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kabupatenBoxActionPerformed
String selectedKabupaten = (String) kabupatenBox.getSelectedItem();
List<String> kacamatanList = WilayahService.getAllKecamatanByKabupatenName(selectedKabupaten);
kecamatanBox.removeAllItems();
for (String kec : kacamatanList) {
    kecamatanBox.addItem(kec);
}
    }//GEN-LAST:event_kabupatenBoxActionPerformed

    private void kecamatanBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kecamatanBoxActionPerformed
    String selectedKecamatan = (String) kecamatanBox.getSelectedItem();
    List<String> desaList = WilayahService.getAllDesaByKecamatanName(selectedKecamatan);
    desaBox.removeAllItems();
    for (String des : desaList) {
        desaBox.addItem(des);
    }
    }//GEN-LAST:event_kecamatanBoxActionPerformed

    private void lembagaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lembagaBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lembagaBoxActionPerformed

    private void bahan_pokokBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bahan_pokokBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bahan_pokokBoxActionPerformed

    private void shaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shaBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shaBoxActionPerformed

    private void hargaShaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaShaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hargaShaFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
      

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bahan_pokok;
    private javax.swing.JComboBox<String> bahan_pokokBox;
    private javax.swing.JButton create;
    private javax.swing.JLabel desa;
    private javax.swing.JComboBox<String> desaBox;
    private javax.swing.JLabel gamber;
    private javax.swing.JLabel hargaSha;
    private javax.swing.JFormattedTextField hargaShaField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel kabupaten;
    private javax.swing.JComboBox<String> kabupatenBox;
    private javax.swing.JLabel kecamatan;
    private javax.swing.JComboBox<String> kecamatanBox;
    private javax.swing.JLabel lembaga;
    private javax.swing.JComboBox<String> lembagaBox;
    private javax.swing.JLabel provinsi;
    private javax.swing.JComboBox<String> provinsiBox;
    private javax.swing.JComboBox<String> shaBox;
    private javax.swing.JLabel ukuranSha;
    private javax.swing.JLabel wilayah;
    private javax.swing.JComboBox<String> wilayahBox;
    // End of variables declaration//GEN-END:variables
}
