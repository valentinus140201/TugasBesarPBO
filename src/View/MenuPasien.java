/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Singleton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author hp
 */
public class MenuPasien implements ActionListener{
    
    JFrame frame = new JFrame("MenuPasien");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menu_pasien = new JButton("PASIEN");
    JButton menu_dokter = new JButton("DOKTER");
    JButton menu_admin = new JButton("ADMINISTRASI");
    JButton insertPasienBaru,searchPasien,beliObat,tambahRiwayatPasien,buatJanjiTemu
            ,lihatRiwayatPasien;
    
    public MenuPasien(){

        insertPasienBaru = new JButton("Insert Pasien Baru");
        searchPasien = new JButton("cari Pasien");
        beliObat = new JButton("beli obat");
        tambahRiwayatPasien = new JButton("update riwayat pasien");
        buatJanjiTemu = new JButton("Janji Temu");
        lihatRiwayatPasien = new JButton("lihat riwayat pasien");
        
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
        insertPasienBaru.setBounds(265, 10, 150, 25);
        searchPasien.setBounds(265, 50, 130, 25);
        tambahRiwayatPasien.setBounds(265, 90, 160, 25);
        buatJanjiTemu.setBounds(265, 130, 120, 25);
        lihatRiwayatPasien.setBounds(265, 170, 130, 25);
        
        isi.add(insertPasienBaru);
        isi.add(searchPasien);
        isi.add(tambahRiwayatPasien);
        isi.add(lihatRiwayatPasien);
        isi.add(buatJanjiTemu);
        menu.add(menu_dokter);
        menu.add(menu_pasien);
        menu.add(menu_admin);
        menu_dokter.addActionListener(this);
        menu_pasien.addActionListener(this);
        menu_admin.addActionListener(this);
        
        
        frame.add(isi);
        frame.add(menu);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        insertPasienBaru.addActionListener(this);
        searchPasien.addActionListener(this);
        tambahRiwayatPasien.addActionListener(this);
        buatJanjiTemu.addActionListener(this);
        lihatRiwayatPasien.addActionListener(this);
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
            case "Insert Pasien Baru":
                new ViewInsertPasienBaru();
                break;
            case "cari Pasien":
                new ViewSearchPasien();
                frame.setVisible(false);
                break;
            case "update riwayat pasien":
                new viewTambahRiwayatPasien();
                frame.setVisible(false);
                break;
            case "Janji Temu":
                new ViewJanjiTemu();
                frame.setVisible(false);
                break;
            case "lihat riwayat pasien":
                new viewLihatRiwayat1Pasien();
                frame.setVisible(false);
                break;
            default: 
                break;
        }
    }
}
