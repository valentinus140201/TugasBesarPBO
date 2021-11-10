/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author hp
 */

import Model.Singleton;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;

public class MenuTransaksi implements ActionListener{
    
    JFrame frame = new JFrame("MENU TRANSAKSI");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menu_pasien = new JButton("PASIEN");
    JButton menu_dokter = new JButton("DOKTER");
    JButton menu_admin = new JButton("ADMINISTRASI");
    JButton obatPasien = new JButton("PERNCAIRAN RESEP DOKTER");
    JButton lihatTransaksi = new JButton("LIHAT SEMUA TRANSAKSI");
    JButton bayarTransaksi = new JButton("BAYAR TAGIHAN");
    JButton lihatKeuntungan = new JButton("LIHAT KEUNTUNGAN");
    
    
    public MenuTransaksi(){
        
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
       
        menu.add(menu_dokter);
        menu.add(menu_pasien);
        menu.add(menu_admin);
       
        menu_dokter.addActionListener(this);
        menu_pasien.addActionListener(this);
        menu_admin.addActionListener(this);
        
        obatPasien.setBounds(350,100,200,50);
        isi.add(obatPasien);
        obatPasien.addActionListener(this);
        
        lihatTransaksi.setBounds(350,170,200,50);
        isi.add(lihatTransaksi);
        lihatTransaksi.addActionListener(this);
        
        bayarTransaksi.setBounds(350,240,200,50);
        isi.add(bayarTransaksi);
        bayarTransaksi.addActionListener(this);
        
        lihatKeuntungan.setBounds(350,310,200,50);
        isi.add(lihatKeuntungan);
        lihatKeuntungan.addActionListener(this);
        
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
            case "PERNCAIRAN RESEP DOKTER":
                new PrePencairanResepDokter();
                frame.setVisible(false);
                break;
            case "LIHAT SEMUA TRANSAKSI":
                new LihatSemuaTransaksi();
                frame.setVisible(false);
                break;
            case "BAYAR TAGIHAN":
                new PreBayarTagihanNik();
                frame.setVisible(false);
                break;
            case "LIHAT KEUNTUNGAN":
                new LihatKeuntungan();
                frame.setVisible(false);
                break;    
            default: 
                break;
        }
    }
    
}