/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerObat;
import Controller.ControllerPasien;
import Controller.ControllerTransaksi;
import Model.GolonganPasien;
import Model.Obat;
import Model.Transaksi;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author V for Vladimir
 */
public class ViewBeliObatPasien implements ActionListener{
    Transaksi t = new Transaksi();
    JFrame formBeliObat = new JFrame();
    JLabel jumlahJenisObatLabel,totalHargaLabel;
    JLabel[] namaObatLabel,jumlahObatLabel;
    JTextField jumlahJenisObatField;
    JTextField[] namaObatFields,jumlahObatFields;
    JButton buttonHitungTotalHarga,buttonLanjut,buttonPrev;
    JPanel panelContent,panelMenu;
    JButton menu_pasien = new JButton("PASIEN");
    JButton menu_dokter = new JButton("DOKTER");
    JButton menu_admin = new JButton("ADMINISTRASI");
    String NIKInput;
    double hargaKonsul;
    public ViewBeliObatPasien(String NIK,double hargaKonsultasi){
        NIKInput = NIK;
        hargaKonsul = hargaKonsultasi;
        totalHargaLabel = new JLabel();
        formBeliObat.setSize(1200, 700);
        jumlahJenisObatLabel = new JLabel("jumlah Jenis obat");
        jumlahJenisObatField = new JTextField();
        buttonLanjut = new JButton("Lanjut");
        buttonHitungTotalHarga = new JButton("hitung total harga");
        buttonPrev = new JButton("Kembali");
        panelContent = new JPanel();
        panelMenu = new JPanel();
        
        buttonPrev.setVisible(false);
        buttonHitungTotalHarga.setVisible(false);
        panelContent.setLayout(null);
        panelMenu.setLayout(null);
        
        panelContent.setBackground(Color.CYAN);
        panelMenu.setBackground(Color.CYAN);
        
        panelMenu.setBounds(10,10,200,640);
        panelContent.setBounds(230,10,930,640);
        jumlahJenisObatLabel.setBounds(10, 40, 140, 25);
        jumlahJenisObatField.setBounds(160, 40, 140, 25);
        buttonLanjut.setBounds(265, 400, 150, 25);
        buttonPrev.setBounds(600, 500, 100, 25);
        buttonHitungTotalHarga.setBounds(740, 500, 150, 25);
        totalHargaLabel.setBounds(700, 10, 200, 25);
        
        menu_pasien.setBounds(35,200,120,50);
        menu_dokter.setBounds(35,260,120,50);
        menu_admin.setBounds(35,320,120,50);
        
        panelContent.add(jumlahJenisObatLabel);
        panelContent.add(jumlahJenisObatField);
        panelContent.add(buttonLanjut);
        panelContent.add(buttonHitungTotalHarga);
        panelContent.add(buttonPrev);
        panelContent.add(totalHargaLabel);
        panelMenu.add(menu_pasien);
        panelMenu.add(menu_dokter);
        panelMenu.add(menu_admin);
        
        formBeliObat.add(panelMenu);
        formBeliObat.add(panelContent);
        formBeliObat.setLayout(null);
        formBeliObat.setLocationRelativeTo(null);
        formBeliObat.setVisible(true);
        formBeliObat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        buttonLanjut.addActionListener(this);
        buttonHitungTotalHarga.addActionListener(this);
        buttonPrev.addActionListener(this);
        
        menu_dokter.addActionListener(this);
        menu_pasien.addActionListener(this);
        menu_admin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command) {
            case "PASIEN": 
                new MenuPasien();
                formBeliObat.setVisible(false);
                break;
            case "DOKTER":
                new MenuDokter();
                formBeliObat.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                formBeliObat.setVisible(false);
                break;
            case "Lanjut":
                jumlahJenisObatLabel.setVisible(false);
                jumlahJenisObatField.setVisible(false);
                buttonHitungTotalHarga.setVisible(true);
                buttonPrev.setVisible(true);
                buttonLanjut.setVisible(false);
                try {
                    String jmlStr = jumlahJenisObatField.getText();
                    int jml = Integer.parseInt(jmlStr);
                    namaObatFields = new JTextField[jml];
                    namaObatLabel = new JLabel[jml];
                    jumlahObatLabel = new JLabel[jml];
                    jumlahObatFields = new JTextField[jml];
                    for(int i = 0; i < jml; i++){
                        namaObatLabel[i] = new JLabel("nama obat " + (i+1));
                        jumlahObatLabel[i] = new JLabel("jumlah obat " + (i+1) + "(dalam mg)");
                        namaObatFields[i] = new JTextField();
                        jumlahObatFields[i] = new JTextField();
                        
                        namaObatLabel[i].setBounds(10, (i*3+1)*10, 100, 25);
                        namaObatFields[i].setBounds(130, (i*3+1)*10, 120, 25);
                        jumlahObatLabel[i].setBounds(270, (i*3+1)*10, 180, 25);
                        jumlahObatFields[i].setBounds(470, (i*3+1)*10, 120, 25);
                        
                        panelContent.add(namaObatLabel[i]);
                        panelContent.add(namaObatFields[i]);
                        panelContent.add(jumlahObatLabel[i]);
                        panelContent.add(jumlahObatFields[i]);
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "input bukan angka!");
                    if(JOptionPane.OK_OPTION == 0){
                        jumlahJenisObatField.setText("");
                    }
                }
                panelContent.validate();
                panelContent.repaint();
                break;
            case "hitung total harga":
                int hargaKonsul = 15000;
                int golonganPasien = 0;
                if(ControllerPasien.getPasien(NIKInput).getBPJS() == GolonganPasien.BPJS){
                    golonganPasien = 1;
                }else{
                    golonganPasien = 2;
                }
                t.setHargaKonsultasi(hargaKonsul);
                ControllerObat CO = new ControllerObat();
                int[] stockObat = new int[namaObatFields.length];
                int totalHarga = 0;
                for(int i = 0; i < namaObatFields.length; i++){
                    stockObat[i] = 0;
                    String IDObat = CO.getObat(namaObatFields[i].getText()).getIDObat();
                    stockObat[i] = CO.getStockObat(IDObat);
                    int jumlahBeli = Integer.parseInt(jumlahObatFields[i].getText());
                    totalHarga += CO.getObat(namaObatFields[i].getText()).getHargaJual() * (jumlahBeli/10);
                    CO.updateStockObat(IDObat, stockObat[i] - jumlahBeli);
                }
                t.setHargaObat(totalHarga);
                t.setJenisPasien(golonganPasien);
                t.setJumlah(namaObatFields.length);
                Date hariIni = new Date();
                t.setTanggakMasuk(hariIni);
                t.setTotal(totalHarga + hargaKonsul);
                 ControllerTransaksi.insertNewTransaksi(t);
                totalHargaLabel.setText("total harga : " + t.getTotal());
                break;
            case "Kembali" :
                jumlahJenisObatLabel.setVisible(true);
                jumlahJenisObatField.setVisible(true);
                buttonLanjut.setVisible(true);
                buttonPrev.setVisible(false);
                buttonHitungTotalHarga.setVisible(false);
                if(namaObatFields.length > 0){
                    for(int i = 0 ;i < namaObatFields.length ;i++){
                        namaObatFields[i].setVisible(false);
                        namaObatLabel[i].setVisible(false);
                        jumlahObatFields[i].setVisible(false);
                        jumlahObatLabel[i].setVisible(false);
                        panelContent.remove(namaObatFields[i]);
                        panelContent.remove(namaObatLabel[i]);
                        panelContent.remove(jumlahObatLabel[i]);
                        panelContent.remove(jumlahObatFields[i]);
                    }
                }
            default: 
                break;
        }
    }
}
