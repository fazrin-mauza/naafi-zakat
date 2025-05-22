package forms1;

import com.sun.jdi.connect.spi.Connection;
import db.DBConnection;
import java.sql.PreparedStatement;
import services.PenyaluranService;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.sql.ResultSet;
import java.util.List;
import services.PembayaranService;
import services.UserService;
import views.BerandaView;
import views.LaporanView;
import auth.Login;
import views.MustahiqView;
import views.MuzakkiView;

 
public class PenyaluranForm extends javax.swing.JFrame {

    public PenyaluranForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        loadDataMustahiq();
        String sessionUser = UserService.getSession(); // Ambil session
         boxAmil.removeAllItems(); // Hapus semua item lama
         boxAmil.addItem(sessionUser); // Tambahkan hanya satu item
         boxAmil.setSelectedItem(sessionUser); // Pilih secara default
    }

    private PenyaluranService penyaluranService = new PenyaluranService();

private void loadDataMustahiq() {
    try {
        namaMustahiq.removeAllItems();
        namaMustahiq.addItem("--Pilih Mustahiq--");

        List<String> mustahiqList = penyaluranService.getNamaMustahiq();
        for (String nama : mustahiqList) {
            namaMustahiq.addItem(nama);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal memuat data mustahiq: " + e.getMessage());
    }
}
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        boxAmil = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        namaMustahiq = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jumlahDisalurkan = new javax.swing.JTextField();
        reset = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        boxGolongan = new javax.swing.JComboBox<>();
        spinerUmur = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAlamat = new javax.swing.JTextArea();
        jLabel25 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 153));
        setMinimumSize(new java.awt.Dimension(750, 500));
        setSize(new java.awt.Dimension(750, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel2.setText("Nama ");
        jPanel9.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 90, 30));

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel3.setText("Amil");
        jPanel9.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 54, 30));

        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel4.setText("Total");
        jPanel9.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 54, 29));
        jPanel9.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, 37, -1));

        boxAmil.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jPanel9.add(boxAmil, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 170, 30));

        jLabel7.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel7.setText("Golongan");
        jPanel9.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 60, 30));

        jLabel8.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel8.setText("Umur");
        jPanel9.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 80, 30));

        namaMustahiq.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        namaMustahiq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        namaMustahiq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaMustahiqActionPerformed(evt);
            }
        });
        jPanel9.add(namaMustahiq, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 170, 30));

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(170, 440));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton6.setBackground(new java.awt.Color(0, 153, 204));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Keluar_FIXX.png"))); // NOI18N
        jButton6.setText("Keluar");
        jButton6.setBorder(null);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 170, 41));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Menubar.png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 50, 40));

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

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Payment_FIXX.png"))); // NOI18N
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 30, 40));

        jLabel15.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel15.setText("Pembayaran");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 90, 20));

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

        jLabel16.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel16.setText("Muzakki");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 70, 20));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Muzakki_FIXX.png"))); // NOI18N
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 30, 30));

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

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Mustahiq_Fix.png"))); // NOI18N
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 30, 40));

        jLabel19.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel19.setText("Mustahiq");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 70, 20));

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

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Beranda_Icon.png"))); // NOI18N
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 30, 40));

        jLabel21.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel21.setText("Beranda");
        jPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 60, 20));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 170, 40));

        jPanel9.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 510));

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel1.setText("Form Penyaluran Zakat");
        jPanel9.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 170, 25));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Menubar.png"))); // NOI18N
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 50, 60));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Sidebar_Laporan_fixx.png"))); // NOI18N
        jPanel9.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, -1));

        jLabel23.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel23.setText("Alamat");
        jPanel9.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 54, 29));

        jumlahDisalurkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahDisalurkanActionPerformed(evt);
            }
        });
        jPanel9.add(jumlahDisalurkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 170, 30));

        reset.setBackground(new java.awt.Color(255, 0, 0));
        reset.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        reset.setText("Reset");
        reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel9.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, 90, 30));

        jButton4.setBackground(new java.awt.Color(0, 255, 0));
        jButton4.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jButton4.setText("Simpan");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, 90, 30));

        boxGolongan.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        boxGolongan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "FAKIR", "MISKIN", "AMIL (PETUGAS ZAKAT)", "MUALLAF (ORANG YANG DILUNAKKAN HATINYA)", "RIQAB (HAMBA SAHAYA/BUDAK)", "GHARIM (ORANG YANG BERHUTANG)", "FI SABILILLAH (PEJUANG DIJALAN ALLAH)", "IBNU SABIL (MUSAFIR YANG KEHABISAN BEKAL)", " " }));
        boxGolongan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxGolonganActionPerformed(evt);
            }
        });
        jPanel9.add(boxGolongan, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 170, 30));
        jPanel9.add(spinerUmur, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 70, 30));

        textAlamat.setColumns(20);
        textAlamat.setRows(5);
        jScrollPane1.setViewportView(textAlamat);

        jPanel9.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 170, 80));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Background.jpg"))); // NOI18N
        jLabel25.setText("jLabel2");
        jPanel9.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 580, 500));

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    int x = 170;
    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
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
    }//GEN-LAST:event_jLabel9MouseClicked

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

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
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
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jumlahDisalurkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahDisalurkanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahDisalurkanActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        namaMustahiq.setSelectedItem("");
        boxGolongan.setSelectedItem("");
        int umur = (int) spinerUmur.getValue();
        textAlamat.setText("");
        jumlahDisalurkan.setText("");
        boxAmil.setSelectedItem("");
    }//GEN-LAST:event_resetActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
  
    String nama_mustahiq = (String) namaMustahiq.getSelectedItem();
    String golongan = (String) boxGolongan.getSelectedItem();
    int umur = (int) spinerUmur.getValue();
    String alamat = (String) textAlamat.getText();
    String jumlah_disalurkan = (String) jumlahDisalurkan.getText();
    String amil = (String) boxAmil.getSelectedItem();

    // Panggil service
    PenyaluranService penyaluranService = new PenyaluranService();
    String result = penyaluranService.buatPenyaluran(
       nama_mustahiq, golongan, umur, jumlah_disalurkan, amil, "", "");
  
    // Tampilkan hasil
    if (result.equals("success")) {
        JOptionPane.showMessageDialog(this, "Data penyaluran berhasil disimpan!");
    } else {
        JOptionPane.showMessageDialog(this, result);
    }
    
    }//GEN-LAST:event_jButton4ActionPerformed

    private void namaMustahiqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaMustahiqActionPerformed
 /** String selectedNama = (String) jComboBox5.getSelectedItem();
    if (selectedNama == null || selectedNama.equals("--Pilih Nama--")) {
       umur.setValue(0);  
        alamat.setText("");
        return;
    }

    try {
        java.sql.Connection con = DBConnection.getConnection();
        String sql2 = "SELECT umur, alamat, golongan FROM mustahiq WHERE nama = ?";
        PreparedStatement ps2 = con.prepareStatement(sql2);
        ps2.setString(1, selectedNama);
        ResultSet rs2 = ps2.executeQuery();

        if (rs2.next()) {
           umur.setValue(rs2.getInt("umur"));
           alamat.setText(rs2.getString("alamat"));
           golongan.setSelectedItem(rs2.getString("golongan"));
        }

        rs2.close();
        ps2.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal mengambil data mustahiq: " + e.getMessage());
    }  
    **/
  String selectedNama = (String) namaMustahiq.getSelectedItem();

    if (selectedNama == null || selectedNama.equals("--Pilih Mustahiq--")) {
        spinerUmur.setValue(0);
        textAlamat.setText("");
        boxGolongan.setSelectedIndex(0); // Sesuaikan default item jika ada
        return;
    }

    PenyaluranService.MustahiqData data = penyaluranService.getDetailMustahiqByNama(selectedNama);
    if (data != null) {
        spinerUmur.setValue(data.getUmur());
        textAlamat.setText(data.getAlamat());
        boxGolongan.setSelectedItem(data.getGolongan());
    }
    }//GEN-LAST:event_namaMustahiqActionPerformed

    private void boxGolonganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxGolonganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxGolonganActionPerformed

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
            java.util.logging.Logger.getLogger(MuzakkiCreateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MuzakkiCreateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MuzakkiCreateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MuzakkiCreateForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PenyaluranForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxAmil;
    private javax.swing.JComboBox<String> boxGolongan;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlahDisalurkan;
    private javax.swing.JComboBox<String> namaMustahiq;
    private javax.swing.JButton reset;
    private javax.swing.JSpinner spinerUmur;
    private javax.swing.JTextArea textAlamat;
    // End of variables declaration//GEN-END:variables
}
