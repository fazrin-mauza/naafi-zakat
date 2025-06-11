package forms;
import auth.Login;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import services.PengaturanService;
import services.WilayahService;
import views.BerandaView;
import views.LaporanView;
import views.MustahiqView;
import views.MuzakkiView;



public class PengaturanForm extends javax.swing.JFrame {
  Map<String, String> makanan = WilayahService.getMakananPokok();
 
    public PengaturanForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        makananPokokLabel.setText("Harga 1 Kg "+makanan.get("makanan_pokok")+" Rp  ");
        harga_Field.setText(makanan.get("harga_kg"));
        hargaSha_Field.setText(makanan.get("harga"));
        emas_Field.setText((String)services.BerandaService.getHargaEmas());
        loadPembagianKeForm();
        
        addHoverEffect(jPanel3); // Mustahiq
        addHoverEffect(jPanel4); // Muzakki
        addHoverEffect(jPanel5); // Pembayaran
        addHoverEffect(jPanel6); // Penyaluran
        addHoverEffect(jPanel7); // Laporan
        addHoverEffect(jPanel8); // Beranda
    }
    private void addHoverEffect(JPanel panel) {
        java.awt.Color warnaAsli = panel.getBackground();
        java.awt.Color warnaHover = new java.awt.Color(0, 153, 255); // Biru muda

        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel.setBackground(warnaHover);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel.setBackground(warnaAsli);
            }
        });
    }

private void loadPembagianKeForm() {
    Map<String, Double> pembagian = PengaturanService.getPembagian(); // Ganti DatabaseHelper sesuai kelas tempat method getPembagian()

    // Cek apakah data ada
    if (!pembagian.isEmpty()) {
        FakirField.setText(String.valueOf(pembagian.getOrDefault("Fakir", 0.0)));
        MiskinField.setText(String.valueOf(pembagian.getOrDefault("Miskin", 0.0)));
        AmilField.setText(String.valueOf(pembagian.getOrDefault("Amil", 0.0)));
        MuallafField.setText(String.valueOf(pembagian.getOrDefault("Muallaf", 0.0)));
        RiqabField.setText(String.valueOf(pembagian.getOrDefault("Riqab", 0.0)));
        GharimField.setText(String.valueOf(pembagian.getOrDefault("Gharim", 0.0)));
        FiiField.setText(String.valueOf(pembagian.getOrDefault("Fii_Sabilillah", 0.0)));
        IbnuField.setText(String.valueOf(pembagian.getOrDefault("Ibnu_Sabil", 0.0)));
    } else {
        JOptionPane.showMessageDialog(this, "Data pembagian tidak ditemukan.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
    }
}
private void simpanPembagian() {
    Map<String, Double> dataPembagian = new HashMap<>();
    try {
        dataPembagian.put("Fakir", Double.parseDouble(FakirField.getText()));
        dataPembagian.put("Miskin", Double.parseDouble(MiskinField.getText()));
        dataPembagian.put("Amil", Double.parseDouble(AmilField.getText()));
        dataPembagian.put("Muallaf", Double.parseDouble(MuallafField.getText()));
        dataPembagian.put("Riqab", Double.parseDouble(RiqabField.getText()));
        dataPembagian.put("Gharim", Double.parseDouble(GharimField.getText()));
        dataPembagian.put("Fii_Sabilillah", Double.parseDouble(FiiField.getText()));
        dataPembagian.put("Ibnu_Sabil", Double.parseDouble(IbnuField.getText()));

        boolean success = PengaturanService.updatePembagian(dataPembagian); // Ganti sesuai class kamu

        if (success) {
         //   JOptionPane.showMessageDialog(this, "Data pembagian berhasil disimpan.");
        } else {
            JOptionPane.showMessageDialog(this, "Data gagal disimpan.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Pastikan semua input angka valid.", "Input Error", JOptionPane.WARNING_MESSAGE);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hargaSha = new javax.swing.JLabel();
        hargaSha_Field = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        makananPokokLabel = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        harga_Field = new javax.swing.JTextField();
        emas_Field = new javax.swing.JTextField();
        MiskinField = new javax.swing.JTextField();
        FakirField = new javax.swing.JTextField();
        AmilField = new javax.swing.JTextField();
        MuallafField = new javax.swing.JTextField();
        RiqabField = new javax.swing.JTextField();
        GharimField = new javax.swing.JTextField();
        FiiField = new javax.swing.JTextField();
        IbnuField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hargaSha.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        hargaSha.setText("Harga 1 Sha'  (Rp) ");
        getContentPane().add(hargaSha, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, -1, -1));

        hargaSha_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaSha_FieldActionPerformed(evt);
            }
        });
        getContentPane().add(hargaSha_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 160, 30));

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(170, 440));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton6.setBackground(new java.awt.Color(0, 153, 204));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Exit_25.png"))); // NOI18N
        jButton6.setText("Keluar");
        jButton6.setBorder(null);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 170, 41));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Menubar.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 50, 40));

        jPanel7.setBackground(new java.awt.Color(0, 153, 204));
        jPanel7.setForeground(new java.awt.Color(0, 153, 204));
        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Laporan_FIXX.png"))); // NOI18N
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 30, 40));

        jLabel13.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel13.setText("Laporan");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 90, 20));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 170, 40));

        jPanel6.setBackground(new java.awt.Color(0, 153, 204));
        jPanel6.setForeground(new java.awt.Color(0, 153, 204));
        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Penyaluran_FIXX.png"))); // NOI18N
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 30, 40));

        jLabel11.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel11.setText("Penyaluran");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 90, 20));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 170, 40));

        jPanel5.setBackground(new java.awt.Color(0, 153, 204));
        jPanel5.setForeground(new java.awt.Color(0, 153, 204));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Payment_FIXX.png"))); // NOI18N
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 30, 40));

        jLabel14.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel14.setText("Pembayaran");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 90, 20));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 170, 40));

        jPanel4.setBackground(new java.awt.Color(0, 153, 204));
        jPanel4.setForeground(new java.awt.Color(0, 153, 204));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel15.setText("Muzakki");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 70, 20));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Muzakki_FIXX.png"))); // NOI18N
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 30, 30));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 170, 40));

        jPanel3.setBackground(new java.awt.Color(0, 153, 204));
        jPanel3.setForeground(new java.awt.Color(0, 153, 204));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Mustahiq_Fix.png"))); // NOI18N
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 30, 40));

        jLabel18.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel18.setText("Mustahiq");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 70, 20));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 170, 40));

        jPanel8.setBackground(new java.awt.Color(0, 153, 204));
        jPanel8.setForeground(new java.awt.Color(0, 153, 204));
        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Beranda_Icon.png"))); // NOI18N
        jPanel8.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 30, 40));

        jLabel20.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel20.setText("Beranda");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 60, 20));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 170, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Menubar.png"))); // NOI18N
        jLabel30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 50, 60));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pengaturan.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, -1));

        jLabel3.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel3.setText("Pengaturan");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel5.setText("Harga 85 Gram Emas Saat Ini  (Rp)");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        makananPokokLabel.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        makananPokokLabel.setText("Harga 1 Kg makanan_pokok (Rp) ");
        getContentPane().add(makananPokokLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, -1, -1));

        jLabel21.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel21.setText("Miskin");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, -1, -1));

        jLabel22.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel22.setText("Fakir");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, -1, -1));

        jLabel23.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel23.setText("Pembagian Zakat (Kg)");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 160, -1));

        jLabel24.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel24.setText("Muallaf");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, -1, -1));

        jLabel25.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel25.setText("Amil");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, -1, -1));

        jLabel26.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel26.setText("Riqab");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, -1, -1));

        jLabel27.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel27.setText("Gharim");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, -1, -1));

        jLabel28.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel28.setText("Fii Sabilillah");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, -1, -1));

        jLabel29.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel29.setText("Ibnu Sabil");
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 360, -1, -1));

        harga_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                harga_FieldActionPerformed(evt);
            }
        });
        getContentPane().add(harga_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 160, 30));

        emas_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emas_FieldActionPerformed(evt);
            }
        });
        getContentPane().add(emas_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 72, 160, 30));

        MiskinField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiskinFieldActionPerformed(evt);
            }
        });
        getContentPane().add(MiskinField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 160, 30));

        FakirField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FakirFieldActionPerformed(evt);
            }
        });
        getContentPane().add(FakirField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 160, 30));

        AmilField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmilFieldActionPerformed(evt);
            }
        });
        getContentPane().add(AmilField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 160, 30));

        MuallafField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MuallafFieldActionPerformed(evt);
            }
        });
        getContentPane().add(MuallafField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 160, 30));

        RiqabField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RiqabFieldActionPerformed(evt);
            }
        });
        getContentPane().add(RiqabField, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 160, 30));

        GharimField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GharimFieldActionPerformed(evt);
            }
        });
        getContentPane().add(GharimField, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 160, 30));

        FiiField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiiFieldActionPerformed(evt);
            }
        });
        getContentPane().add(FiiField, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 310, 160, 30));

        IbnuField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IbnuFieldActionPerformed(evt);
            }
        });
        getContentPane().add(IbnuField, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 350, 160, 30));

        jButton1.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 430, -1, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Background.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 580, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    int x = 170;
    private void emas_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emas_FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emas_FieldActionPerformed

    private void MiskinFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiskinFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MiskinFieldActionPerformed

    private void FakirFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FakirFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FakirFieldActionPerformed

    private void AmilFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmilFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmilFieldActionPerformed

    private void MuallafFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MuallafFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MuallafFieldActionPerformed

    private void RiqabFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RiqabFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RiqabFieldActionPerformed

    private void GharimFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GharimFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GharimFieldActionPerformed

    private void FiiFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiiFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FiiFieldActionPerformed

    private void IbnuFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IbnuFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IbnuFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String emas = emas_Field.getText();
       String harga_kg = harga_Field.getText();
       String harga_sha = hargaSha_Field.getText();
       PengaturanService service = new PengaturanService();
       String result = service.emasUpdate(emas);
       boolean hargaUpdate = PengaturanService.updateHargakMakananPokok(harga_kg);
       boolean hargaUpdate2 = PengaturanService.updateHargakSha(harga_sha);
       simpanPembagian();
           if (result.equals("success") && hargaUpdate == true) {
                JOptionPane.showMessageDialog(this, "Data pengaturan berhasil diupdate.");
                loadPembagianKeForm();
           } else {
                    JOptionPane.showMessageDialog(this, result);
                }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void harga_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_harga_FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_harga_FieldActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int pilihan = JOptionPane.showConfirmDialog(
            this,
            "Anda yakin ingin logout?",
            "Konfirmasi Logout",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if (pilihan == JOptionPane.YES_OPTION) {
            this.dispose(); // Tutup form sekarang
            new Login().setVisible(true); // Tampilkan form login
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        if (x == 170) {
            jPanel2.setSize(170, 500);

            Thread th = new Thread() {
                @Override
                public void run() {
                    try {
                        for (int i = 170; i >= 0; i--) {
                            Thread.sleep(1);
                            jPanel2.setSize(i, 500);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            };

            th.start();
            x = 0;
        }
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        LaporanView rgf = new LaporanView();
        rgf.setVisible(true);
        rgf.pack();
        rgf.setLocationRelativeTo(null);
        rgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        PenyaluranForm lrn = new PenyaluranForm();
        lrn.setVisible(true);
        lrn.pack();
        lrn.setLocationRelativeTo(null);
        lrn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        PembayaranForm rgf = new PembayaranForm();
        rgf.setVisible(true);
        rgf.pack();
        rgf.setLocationRelativeTo(null);
        rgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        MuzakkiView rgf = new MuzakkiView();
        rgf.setVisible(true);
        rgf.pack();
        rgf.setLocationRelativeTo(null);
        rgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        MustahiqView rgf = new MustahiqView();
        rgf.setVisible(true);
        rgf.pack();
        rgf.setLocationRelativeTo(null);
        rgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        BerandaView rgf = new BerandaView();
        rgf.setVisible(true);
        rgf.pack();
        rgf.setLocationRelativeTo(null);
        rgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        if (x == 0) {
            jPanel2.show();
            jPanel2.setSize(x, 500);

            Thread th = new Thread() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i <= x; i++) {
                            Thread.sleep(1);
                            jPanel2.setSize(i, 500);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            };

            th.start();
            x = 170;
        }
    }//GEN-LAST:event_jLabel30MouseClicked

    private void hargaSha_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaSha_FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hargaSha_FieldActionPerformed

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
            java.util.logging.Logger.getLogger(PengaturanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PengaturanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PengaturanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PengaturanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PengaturanForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AmilField;
    private javax.swing.JTextField FakirField;
    private javax.swing.JTextField FiiField;
    private javax.swing.JTextField GharimField;
    private javax.swing.JTextField IbnuField;
    private javax.swing.JTextField MiskinField;
    private javax.swing.JTextField MuallafField;
    private javax.swing.JTextField RiqabField;
    private javax.swing.JTextField emas_Field;
    private javax.swing.JLabel hargaSha;
    private javax.swing.JTextField hargaSha_Field;
    private javax.swing.JTextField harga_Field;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel makananPokokLabel;
    // End of variables declaration//GEN-END:variables
}
