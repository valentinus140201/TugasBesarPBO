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
import javax.swing.JRootPane;

/**
 *
 * @author hp
 */
public class MenuPasien implements ActionListener{
    
    JFrame frame = new JFrame("MENU PASIEN");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menu_pasien = new JButton("PASIEN");
    JButton menu_dokter = new JButton("DOKTER");
    JButton menu_admin = new JButton("ADMINISTRASI");
    JButton insertPasienBaru, searchPasien, beliObat, tambahRiwayatPasien, buatJanjiTemu, lihatRiwayatPasien;
    
    public MenuPasien(){

        insertPasienBaru = new JButton("INSERT PASIEN BARU");
        searchPasien = new JButton("CARI PASIEN");
        beliObat = new JButton("BELI OBAT");
        tambahRiwayatPasien = new JButton("UPDATE RIWAYAT PASIEN");
        buatJanjiTemu = new JButton("JANJI TEMU");
        lihatRiwayatPasien = new JButton("LIHAT RIWAYAT PASIEN");
        
        frame.setSize(1200, 700);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
        menu.setLayout(null);
        isi.setLayout(null);
        
        menu.setBounds(10,10,200,640);
        isi.setBounds(230,10,930,640);
        
        isi.setBackground(Color.ORANGE);
        menu.setBackground(Color.ORANGE);
        
        menu_pasien.setBounds(35,200,120,50);
        menu_dokter.setBounds(35,260,120,50);
        menu_admin.setBounds(35,320,120,50);
        
        insertPasienBaru.setBounds(350, 100, 200, 50);
        searchPasien.setBounds(350, 200, 200, 50);
        tambahRiwayatPasien.setBounds(350, 300, 200, 50);
        buatJanjiTemu.setBounds(350, 400, 200, 50);
        lihatRiwayatPasien.setBounds(350, 500, 200, 50);
        
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
        
        insertPasienBaru.addActionListener(this);
        searchPasien.addActionListener(this);
        tambahRiwayatPasien.addActionListener(this);
        buatJanjiTemu.addActionListener(this);
        lihatRiwayatPasien.addActionListener(this);
        
        frame.add(isi);
        frame.add(menu);
           
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
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
            case "INSERT PASIEN BARU":
                new ViewInsertPasienBaru();
                break;
            case "CARI PASIEN":
                new ViewSearchPasien();
                frame.setVisible(false);
                break;
            case "UPDATE RIWAYAT PASIEN":
                new viewTambahRiwayatPasien();
                frame.setVisible(false);
                break;
            case "JANJIT TEMU":
                new ViewJanjiTemu();
                frame.setVisible(false);
                break;
            case "LIHAT RIWAYAT PASIEN":
                new viewLihatRiwayat1Pasien();
                frame.setVisible(false);
                break;
            default: 
                break;
        }
    }
}
