/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Siswa extends javax.swing.JDialog {
    koneksi dbsetting;
    String driver, database, user, pass;
    Object tabel;
    /**
     * Creates new form Siswa
     */
    public Siswa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
        
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");

        table_Siswa.setModel(tableModel);
        settableload();
    }
    
     private javax.swing.table.DefaultTableModel tableModel = getDefaultTableModel();

     private javax.swing.table.DefaultTableModel getDefaultTableModel() {
        //membuat judul header
        return new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Id Pendaftaran", "Nis", "Nama", "Jenis Kelamin", "Alamat", "Kode Kelas"}
        ) //disable perubahan pada grid
        {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
    }

    String data[] = new String[6];

    private void settableload() {
        String atat = "";
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "select * from siswa";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()) {
                data[0] = res.getString(1);
                data[1] = res.getString(2);
                data[2] = res.getString(3);
                data[3] = res.getString(4);
                data[4] = res.getString(5);
                data[5] = res.getString(6);
                tableModel.addRow(data);
            }
            res.close();
            stt.close();
            kon.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
    private void settableload1() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String atat = "";
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "select * from siswa";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()) {
                data[0] = txt_Id.getText();
                data[1] = txt_Nis.getText();
                data[2] = txt_Nama.getText();
                data[3] = (String) ComboBox_JenisKelamin.getSelectedItem();
                data[4] = txt_Alamat.getText();
                data[5] = txt_Kode.getText();
                tableModel.insertRow(0, data);
                }
            res.close();
            stt.close();
            kon.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
     public void bersihkan_teks(){
         txt_Id.setText("");
         txt_Nis.setText("");
         txt_Nama.setText("");
         ComboBox_JenisKelamin.setSelectedIndex(0);
         txt_Alamat.setText("");
         txt_Kode.setText("");
         txt_Cari.setText("");
    }
    
    int row = 0;
     public void tampil_field()
    {
        row = table_Siswa.getSelectedRow();
        txt_Id.setText(tableModel.getValueAt(row, 0).toString());
        txt_Nis.setText(tableModel.getValueAt(row, 1).toString());
        txt_Nama.setText(tableModel.getValueAt(row, 2).toString());
        ComboBox_JenisKelamin.setSelectedItem(tableModel.getValueAt(row, 3).toString());
        txt_Alamat.setText(tableModel.getValueAt(row, 4).toString());
        txt_Kode.setText(tableModel.getValueAt(row, 5).toString());
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_Id = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_Cari = new javax.swing.JTextField();
        btn_Cari = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_Nis = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_Nama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ComboBox_JenisKelamin = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Alamat = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        txt_Kode = new javax.swing.JTextField();
        btn_Simpan = new javax.swing.JButton();
        btn_Ubah = new javax.swing.JButton();
        btn_Hapus = new javax.swing.JButton();
        btn_Tampil = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_Siswa = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Id Pendaftar ");

        txt_Id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Cari");

        btn_Cari.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Cari.setText("Cari");
        btn_Cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CariActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nis");

        txt_Nis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nama Pendaftar");

        txt_Nama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Jenis Kelamin");

        ComboBox_JenisKelamin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ComboBox_JenisKelamin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "(L/P)", "Laki-Laki", "Perempuan" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Alamat");

        txt_Alamat.setColumns(20);
        txt_Alamat.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txt_Alamat.setRows(5);
        jScrollPane1.setViewportView(txt_Alamat);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Kode Kelas");

        txt_Kode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btn_Simpan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Simpan.setText("Simpan");
        btn_Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SimpanActionPerformed(evt);
            }
        });

        btn_Ubah.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Ubah.setText("Ubah");
        btn_Ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UbahActionPerformed(evt);
            }
        });

        btn_Hapus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Hapus.setText("Hapus");
        btn_Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HapusActionPerformed(evt);
            }
        });

        btn_Tampil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Tampil.setText("Tampikan datata Kembali");
        btn_Tampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TampilActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Pendaftaran");

        table_Siswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Pendaftaran", "Nis", "Nama", "Jenis Kelamin", "Alamat", "Kode Kelas"
            }
        ));
        table_Siswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_SiswaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_Siswa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 1130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7))
                                        .addGap(22, 22, 22))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btn_Simpan)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_Ubah)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_Hapus))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_Nis)
                                        .addComponent(txt_Nama)
                                        .addComponent(txt_Id)
                                        .addComponent(jScrollPane1)
                                        .addComponent(txt_Kode)
                                        .addComponent(ComboBox_JenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txt_Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Cari)
                                .addGap(366, 366, 366)
                                .addComponent(btn_Tampil))
                            .addComponent(jScrollPane3))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txt_Cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Cari)
                    .addComponent(btn_Tampil))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_Nis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_Nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(ComboBox_JenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_Kode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Simpan)
                            .addComponent(btn_Ubah)
                            .addComponent(btn_Hapus)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_SiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_SiswaMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1)
        {
            tampil_field();
        }
    }//GEN-LAST:event_table_SiswaMouseClicked

    private void btn_SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SimpanActionPerformed
        // TODO add your handling code here:
         String data[]=new String[6];
          if ((txt_Id.getText().isEmpty()) || (txt_Kode.getText().isEmpty()))
        {
            JOptionPane.showMessageDialog(null,
                "data tidak boleh kosong, silahkan lengkapi");
            txt_Id.requestFocus();
        }
        else
        {
            try
            {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String SQL = "INSERT INTO siswa(Id_Pendaftaran,"+ "Nis,"+ "Nama,"+ "Jenis_Kelamin,"+ " Alamat,"+"Kode_Kelas)"
                + "VALUES"
                +"( '"+txt_Id.getText()+"',"
                +"'"+txt_Nis.getText()+"',"
                +"'"+txt_Nama.getText()+"',"
                + "'" + ComboBox_JenisKelamin.getSelectedItem() + "',"
                +"'"+txt_Alamat.getText()+"',"
                + "'" +txt_Kode.getText()+ "')";
                /*String SQL = "";*/
                stt.executeUpdate(SQL);
                String SQL1 = "INSERT INTO pendaftaran(Id_Pendaftaran,"+ "Nis,"+ "Nama_Pendaftar,"+ "Jenis_Kelamin,"+ " Alamat,"+"Kode_Kelas)"
                + "VALUES"
                +"( '"+txt_Id.getText()+"',"
                +"'"+txt_Nis.getText()+"',"
                +"'"+txt_Nama.getText()+"',"
                + "'" + ComboBox_JenisKelamin.getSelectedItem() + "',"
                +"'"+txt_Alamat.getText()+"',"
                + "'" +txt_Kode.getText()+ "')";
                /*String SQL = "";*/
                stt.executeUpdate(SQL1);
                settableload1();
                stt.close();
                kon.close();
                bersihkan_teks();
                JOptionPane.showMessageDialog(null, "Data Telah Disimpan..!","<< BERHASIL >>",JOptionPane.PLAIN_MESSAGE);
            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_SimpanActionPerformed

    private void btn_UbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UbahActionPerformed
        // TODO add your handling code here:
        String Id_Pendaftar  =txt_Id.getText();
        String Nis =txt_Nis.getText();
        String Nama_Pendaftar =txt_Nama.getText();
        String Jenis_Kelamin =(String) ComboBox_JenisKelamin.getSelectedItem();
        String Alamat =txt_Alamat.getText();
        String Kode_Kelas =txt_Kode.getText();
        
        if((Id_Pendaftar.isEmpty()) | (Kode_Kelas.isEmpty()))
        {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong, Silahkan Dilengkapi");
            txt_Id.requestFocus();
        }

        else
        {
            try
            {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String SQL = "UPDATE `siswa`"
                +"SET `Id_Pendaftaran`='"+Id_Pendaftar+"',"
                +"`Nis`='"+Nis+"',"
                +"`Nama`='"+Nama_Pendaftar+"',"
                +"`Jenis_Kelamin`='"+Jenis_Kelamin+"',"
                +"`Alamat`='"+Alamat+"',"
                +"`Kode_Kelas`='"+Kode_Kelas+"'"    
                +"WHERE"
                +"`siswa`='"+tableModel.getValueAt(row, 0).toString()+"';";
                data[0] = Id_Pendaftar;
                data[1] = Nis;
                data[2] = Nama_Pendaftar;
                data[3] = Jenis_Kelamin;
                data[4] = Alamat;
                data[5] = Kode_Kelas;
                tableModel.removeRow(row);
                tableModel.insertRow(row, data);
                stt.close();
                kon.close();
                bersihkan_teks();
                JOptionPane.showMessageDialog(null, "Data Telah DiUbah..!", "<< BERHASIL >>", JOptionPane.PLAIN_MESSAGE);
            }
            catch (Exception ex)
            {
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btn_UbahActionPerformed

    private void btn_HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HapusActionPerformed
        // TODO add your handling code here:
        int pilih = JOptionPane.showConfirmDialog(null, "Anda Yakin Ingin Menghapus Data Ini ..?","Pertanyaan",JOptionPane.YES_NO_OPTION);
        if(pilih == JOptionPane.YES_OPTION)
        try
        {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "Delete from `db_siswa`.`siswa`"
            +"where"
            +"`Id_Pendaftaran`='"+tableModel.getValueAt(row, 0).toString()+"';";
            stt.executeUpdate(SQL);
            String SQL1 = "Delete from `db_siswa`.`pendaftaran`"
            +"where"
            +"`Id_Pendaftaran`='"+tableModel.getValueAt(row, 0).toString()+"';";
            stt.executeUpdate(SQL1);
            tableModel.removeRow(row);
            stt.close();
            kon.close();
            bersihkan_teks();
            JOptionPane.showMessageDialog(null, "Data Telah DiHapus..!","<< BERHASIL >>",JOptionPane.PLAIN_MESSAGE);
        }
        catch(Exception ex)
        {
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_btn_HapusActionPerformed

    private void btn_CariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CariActionPerformed
        // TODO add your handling code here:
        tableModel.setRowCount(0);
        //gunakan query untuk mencari
        try
        {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "select * from `db_siswa`.`siswa` WHERE `Id_Pendaftaran`like '%"+txt_Cari.getText()+"%'OR `Nis` like '%"+txt_Cari.getText()+"%'OR `Kode_Kelas` like '%"+txt_Cari.getText()+"'";
            ResultSet res = stt.executeQuery(SQL);
            while(res.next())
            {
                data[0] = res.getString(1);
                data[1] = res.getString(2);
                data[2] = res.getString(3);
                data[3] = res.getString(4);
                data[4] = res.getString(5);
                data[5] = res.getString(6);
                tableModel.addRow(data);
            }
            res.close();
            stt.close();
            kon.close();
            bersihkan_teks();
            JOptionPane.showMessageDialog(null, "Data Yang Anda Cari Di Temukan..!", "<< BERHASIL >>", JOptionPane.PLAIN_MESSAGE);
        }
        catch(Exception ex)
        {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);

        }
    }//GEN-LAST:event_btn_CariActionPerformed

    private void btn_TampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TampilActionPerformed
        // TODO add your handling code here:
        tableModel.setRowCount(0);
        settableload();
    }//GEN-LAST:event_btn_TampilActionPerformed

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
            java.util.logging.Logger.getLogger(Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Siswa dialog = new Siswa(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBox_JenisKelamin;
    private javax.swing.JButton btn_Cari;
    private javax.swing.JButton btn_Hapus;
    private javax.swing.JButton btn_Simpan;
    private javax.swing.JButton btn_Tampil;
    private javax.swing.JButton btn_Ubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable table_Siswa;
    private javax.swing.JTextArea txt_Alamat;
    private javax.swing.JTextField txt_Cari;
    private javax.swing.JTextField txt_Id;
    private javax.swing.JTextField txt_Kode;
    private javax.swing.JTextField txt_Nama;
    private javax.swing.JTextField txt_Nis;
    // End of variables declaration//GEN-END:variables
}
