/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerTransaksi;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Model.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class BayarTagihan implements ActionListener{
    
    JFrame frame = new JFrame("MenuAdmin");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menu_pasien = new JButton("PASIEN");
    JButton menu_dokter = new JButton("DOKTER");
    JButton menu_admin = new JButton("ADMINISTRASI");
    JButton bayarTagihan = new JButton("BAYAR TAGIHAN");
    Transaksi tempTransaksi;

    public BayarTagihan(Transaksi transaksi){
        
        frame.setSize(1200, 700);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        menu.setLayout(null);
        isi.setLayout(null);
        menu.setBounds(10,10,200,640);
        isi.setBounds(230,10,930,640);
        isi.setBackground(Color.cyan);
        menu.setBackground(Color.cyan);
        menu_pasien.setBounds(35,200,120,50);
        menu_dokter.setBounds(35,260,120,50);
        menu_admin.setBounds(35,320,120,50);
        menu.add(menu_dokter);
        menu.add(menu_pasien);
        menu.add(menu_admin);
        menu_dokter.addActionListener(this);
        menu_pasien.addActionListener(this);
        menu_admin.addActionListener(this);
        bayarTagihan.setBounds(350,300,120,50);
        bayarTagihan.addActionListener(this);

        
        JLabel labIdTransaksi = new JLabel("Id Transaksi : ");
        JLabel labNamaPasien = new JLabel("Nama : ");
        JLabel labTotalTagihan = new JLabel("Total Tagihan : ");
        
        JLabel isilabIdTransaksi = new JLabel(transaksi.getIdTransaksi());
        JLabel isilabNamaPasien = new JLabel(transaksi.getPasien().getNama());
        JLabel isilabTotalTagihan = new JLabel("" + transaksi.getTotal());
        
        labIdTransaksi.setBounds(50, 80, 80, 20);
        isi.add(labIdTransaksi);
        isilabIdTransaksi.setBounds(200, 80, 300, 20);
        isi.add(isilabIdTransaksi);
        labNamaPasien.setBounds(50, 110, 80, 20);
        isi.add(labNamaPasien);
        isilabNamaPasien.setBounds(200, 110, 300, 20);
        isi.add(isilabNamaPasien);
        labTotalTagihan.setBounds(50, 140, 80, 20);
        isi.add(labTotalTagihan);
        isilabTotalTagihan.setBounds(200, 140, 300, 20);
        isi.add(isilabTotalTagihan);
        
        bayarTagihan.addActionListener(this);
        bayarTagihan.setBounds(350, 200, 150, 50);
        isi.add(bayarTagihan);
        
        frame.add(isi);
        frame.add(menu);
        frame.setVisible(true);
        tempTransaksi = transaksi;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "PASIEN": 
                new MenuPasien();
                frame.setVisible(false);
                break;
            case "DOKTER":
                new MenuDokter();
                frame.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                frame.setVisible(false);
                break;
            case "BAYAR TAGIHAN":
                ControllerTransaksi.insertTransaksibyBayarTagihan(tempTransaksi);
                frame.setVisible(false);
                new MenuAdmin();
                JOptionPane.showMessageDialog(null, "Pembayaran Telah Berhasil, Trimaksih");
                break;
            default: 
                break;
        }
    }
}
