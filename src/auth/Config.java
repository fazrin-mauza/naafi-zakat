package auth;

import java.util.List;
import javax.swing.JFrame;
import services.AuthService;
import javax.swing.JOptionPane;


public class Config extends javax.swing.JFrame {
 private String masjid;

    public Config(String masjidText) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.masjid = masjidText;
         String namaLembaga = AuthService.getSession(); // Ambil session
         lembagaBox.removeAllItems(); // Hapus semua item lama
         lembagaBox.addItem(masjid); // Tambahkan hanya satu item
         lembagaBox.setSelectedItem(masjidText); // Pilih secara default
               peovinsiBox.setVisible(false);
               provinsi.setVisible(false);
               kabupatenBox.setVisible(false);
               kabupaten.setVisible(false);
               kecamatanBox.setVisible(false);
               kecamatan.setVisible(false);
               desaBox.setVisible(false);
               desa.setVisible(false);
  
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        wilayahBox = new javax.swing.JComboBox<>();
        desaBox = new javax.swing.JComboBox<>();
        peovinsiBox = new javax.swing.JComboBox<>();
        kabupatenBox = new javax.swing.JComboBox<>();
        lembaga = new javax.swing.JLabel();
        wilayah = new javax.swing.JLabel();
        kabupaten = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        provinsi = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kecamatan = new javax.swing.JLabel();
        desa = new javax.swing.JLabel();
        createsign = new javax.swing.JButton();
        kecamatanBox = new javax.swing.JComboBox<>();
        lembagaBox = new javax.swing.JComboBox<>();
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

        wilayahBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "Provinsi", "Kabupaten / Kota", "Kecamatan", "Desa / Kelurahan" }));
        wilayahBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wilayahBoxActionPerformed(evt);
            }
        });
        jPanel2.add(wilayahBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 210, 30));

        desaBox.setEditable(true);
        desaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desaBoxActionPerformed(evt);
            }
        });
        jPanel2.add(desaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 210, 30));

        peovinsiBox.setEditable(true);
        peovinsiBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peovinsiBoxActionPerformed(evt);
            }
        });
        jPanel2.add(peovinsiBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 210, 30));

        kabupatenBox.setEditable(true);
        kabupatenBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kabupatenBoxActionPerformed(evt);
            }
        });
        jPanel2.add(kabupatenBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 210, 30));

        lembaga.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        lembaga.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lembaga.setText("Nama Lembaga");
        jPanel2.add(lembaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 40));

        wilayah.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        wilayah.setText("Cakupan Wilayah");
        jPanel2.add(wilayah, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 60));

        kabupaten.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        kabupaten.setText("Kabupaten / Kota");
        jPanel2.add(kabupaten, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 224, -1, 20));

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
        jPanel2.add(provinsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 168, 150, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Pengaturan");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 190, 40));

        kecamatan.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        kecamatan.setText("Kecamatan");
        jPanel2.add(kecamatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 268, 120, 30));

        desa.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        desa.setText("Desa / Kelurahan");
        jPanel2.add(desa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 140, 20));

        createsign.setBackground(new java.awt.Color(0, 255, 0));
        createsign.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        createsign.setText("Create");
        createsign.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createsign.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createsignMouseClicked(evt);
            }
        });
        createsign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createsignActionPerformed(evt);
            }
        });
        jPanel2.add(createsign, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 80, 30));

        kecamatanBox.setEditable(true);
        kecamatanBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kecamatanBoxActionPerformed(evt);
            }
        });
        jPanel2.add(kecamatanBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 210, 30));

        lembagaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lembagaBoxActionPerformed(evt);
            }
        });
        jPanel2.add(lembagaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 210, 30));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(460, 30, 290, 450);

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

    private void createsignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createsignActionPerformed
String lembagaText = lembagaBox.getEditor().getItem().toString();
String provinsi = lembagaBox.getEditor().getItem().toString();

/** String result = userService.signUp(usernameText, namaText, handphoneText, masjidText, passwordText, ulangiPasswordText);

    if (result.equals("success")) {
        JOptionPane.showMessageDialog(this, "Akun berhasil dibuat!");
        this.dispose(); 
        Login lgf = new Login();
        lgf.setVisible(true);
        
    } else {
        JOptionPane.showMessageDialog(this, result);
    }*/
    }//GEN-LAST:event_createsignActionPerformed

    private void createsignMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createsignMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_createsignMouseClicked

    private void wilayahBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wilayahBoxActionPerformed
    String selectedWilayah = wilayahBox.getSelectedItem().toString();

    if (selectedWilayah.equalsIgnoreCase("Provinsi")) {
               peovinsiBox.setVisible(true);
               provinsi.setVisible(true);
               kabupatenBox.setVisible(false);
               kabupaten.setVisible(false);
               kecamatanBox.setVisible(false);
               kecamatan.setVisible(false);
               desaBox.setVisible(false);
               desa.setVisible(false);
    } else if (selectedWilayah.equalsIgnoreCase("Kabupaten / Kota")) {
               peovinsiBox.setVisible(true);
               provinsi.setVisible(true);
               kabupatenBox.setVisible(true);
               kabupaten.setVisible(true);
               kecamatanBox.setVisible(false);
               kecamatan.setVisible(false);
               desaBox.setVisible(false);
               desa.setVisible(false);
     } else if (selectedWilayah.equalsIgnoreCase("Kecamatan")) {
               peovinsiBox.setVisible(true);
               provinsi.setVisible(true);
               kabupatenBox.setVisible(true);
               kabupaten.setVisible(true);
               kecamatanBox.setVisible(true);
               kecamatan.setVisible(true);
               desaBox.setVisible(false);
               desa.setVisible(false);
     } else if (selectedWilayah.equalsIgnoreCase("Desa / Kelurahan")) {
               peovinsiBox.setVisible(true);
               provinsi.setVisible(true);
               kabupatenBox.setVisible(true);
               kabupaten.setVisible(true);
               kecamatanBox.setVisible(true);
               kecamatan.setVisible(true);
               desaBox.setVisible(true);
               desa.setVisible(true);
     } else {
               peovinsiBox.setVisible(false);
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

    private void peovinsiBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peovinsiBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_peovinsiBoxActionPerformed

    private void kabupatenBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kabupatenBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kabupatenBoxActionPerformed

    private void kecamatanBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kecamatanBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kecamatanBoxActionPerformed

    private void lembagaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lembagaBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lembagaBoxActionPerformed

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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createsign;
    private javax.swing.JLabel desa;
    private javax.swing.JComboBox<String> desaBox;
    private javax.swing.JLabel gamber;
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
    private javax.swing.JComboBox<String> peovinsiBox;
    private javax.swing.JLabel provinsi;
    private javax.swing.JLabel wilayah;
    private javax.swing.JComboBox<String> wilayahBox;
    // End of variables declaration//GEN-END:variables
}
