package auth;

import java.util.List;
import javax.swing.JFrame;
import services.AuthService;
import javax.swing.JOptionPane;


public class Register extends javax.swing.JFrame {

 
    public Register() {
        initComponents();
        this.setLocationRelativeTo(null);
        
    // Ambil daftar nama masjid dari database
    List<String> masjidList = AuthService.getNamaMasjidList();
    for (String nama : masjidList) {
        masjid.addItem(nama); // ✅ 'masjid' adalah JComboBox, 'nama' adalah String
    }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        masjid = new javax.swing.JComboBox<>();
        Usersign = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        phonesign = new javax.swing.JLabel();
        nama_masjid = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nomor_handphone = new javax.swing.JLabel();
        nomorhandphone = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pwsign3 = new javax.swing.JLabel();
        buatpw = new javax.swing.JPasswordField();
        pwsign2 = new javax.swing.JLabel();
        ulangipw = new javax.swing.JPasswordField();
        createsign = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        gamber = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 102));

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(820, 494));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        masjid.setEditable(true);
        masjid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masjidActionPerformed(evt);
            }
        });
        jPanel2.add(masjid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 210, 30));

        Usersign.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        Usersign.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Usersign.setText("Username");
        jPanel2.add(Usersign, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 56, -1, -1));

        nama.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });
        jPanel2.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 132, 209, 30));

        username.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 78, 209, 30));

        phonesign.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        phonesign.setText("Nama");
        jPanel2.add(phonesign, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 112, -1, -1));

        nama_masjid.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        nama_masjid.setText("Masjid");
        jPanel2.add(nama_masjid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 226, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("X");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        nomor_handphone.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        nomor_handphone.setText("Nomor Handphone");
        jPanel2.add(nomor_handphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 168, 150, -1));

        nomorhandphone.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        nomorhandphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomorhandphoneActionPerformed(evt);
            }
        });
        jPanel2.add(nomorhandphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 209, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SIGN UP");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 10, 160, 40));

        pwsign3.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        pwsign3.setText("Buat Password");
        jPanel2.add(pwsign3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 284, 120, -1));
        jPanel2.add(buatpw, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 306, 209, 30));

        pwsign2.setFont(new java.awt.Font("Rockwell", 0, 13)); // NOI18N
        pwsign2.setText("Ulangi Password");
        jPanel2.add(pwsign2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 342, 140, -1));
        jPanel2.add(ulangipw, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 364, 209, 30));

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

        reset.setBackground(new java.awt.Color(255, 0, 0));
        reset.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        reset.setText("Reset");
        reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetMouseClicked(evt);
            }
        });
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel2.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 80, 30));

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

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 30, 40, 30);

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

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void createsignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createsignActionPerformed
AuthService userService = new AuthService();
String usernameText = username.getText();
String namaText = nama.getText();
String handphoneText = nomorhandphone.getText();
String masjidText = masjid.getEditor().getItem().toString();
String passwordText = new String(buatpw.getPassword());
String ulangiPasswordText = new String(ulangipw.getPassword());


    String result = userService.signUp(usernameText, namaText, handphoneText, masjidText, passwordText, ulangiPasswordText);

    if (result.equals("success")) {
        JOptionPane.showMessageDialog(this, "Akun berhasil dibuat!");
        
        String masjidSet = masjid.getEditor().getItem().toString().trim();

boolean foundInList = false;
for (int i = 0; i < masjid.getItemCount(); i++) {
    if (masjid.getItemAt(i).toString().equalsIgnoreCase(masjidSet)) {
        foundInList = true;
        break;
    }
}
if (foundInList) {
       this.dispose(); 
        Login lgf = new Login();
        lgf.setVisible(true);
} else {
    Config cfg = new Config(masjidSet); 
    cfg.setVisible(true);
    this.dispose();    
}

    } else {
        JOptionPane.showMessageDialog(this, result);
    }
    }//GEN-LAST:event_createsignActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        username.setText("");
        nama.setText("");
        nomorhandphone.setText("");
        masjid.getEditor().setItem("");
        buatpw.setText("");
        ulangipw.setText("");
        
    }//GEN-LAST:event_resetActionPerformed

    private void nomorhandphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomorhandphoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomorhandphoneActionPerformed

    private void resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseClicked
        
        
    }//GEN-LAST:event_resetMouseClicked

    private void createsignMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createsignMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_createsignMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        Login lgf = new Login();
        lgf.setVisible(true);
        lgf.pack();
        lgf.setLocationRelativeTo(null);
        lgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void masjidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masjidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_masjidActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Usersign;
    private javax.swing.JPasswordField buatpw;
    private javax.swing.JButton createsign;
    private javax.swing.JLabel gamber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> masjid;
    private javax.swing.JTextField nama;
    private javax.swing.JLabel nama_masjid;
    private javax.swing.JLabel nomor_handphone;
    private javax.swing.JTextField nomorhandphone;
    private javax.swing.JLabel phonesign;
    private javax.swing.JLabel pwsign2;
    private javax.swing.JLabel pwsign3;
    private javax.swing.JButton reset;
    private javax.swing.JPasswordField ulangipw;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
