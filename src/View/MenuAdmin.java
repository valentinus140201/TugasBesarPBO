/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

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
public class MenuAdmin implements ActionListener{
    
    JFrame frame = new JFrame("MenuAdmin");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menu_pasien = new JButton("PASIEN");
    JButton menu_dokter = new JButton("DOKTER");
    JButton menu_admin = new JButton("ADMINISTRASI");
    JButton input_obat = new JButton("INPUT OBAT");
    JButton restock_obat = new JButton("RESTOCK OBAT");
    JButton rujukan = new JButton("RUJUKAN");
    JButton transaksi = new JButton("TRANSAKSI");
    
    
    public MenuAdmin(){
        
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
        
        input_obat.setBounds(350,100,200,50);
        isi.add(input_obat);
        input_obat.addActionListener(this);
        
        restock_obat.setBounds(350,170,200,50);
        isi.add(restock_obat);
        restock_obat.addActionListener(this);
        
        rujukan.setBounds(350,240,200,50);
        isi.add(rujukan);
        rujukan.addActionListener(this);
        
        transaksi.setBounds(350,310,200,50);
        isi.add(transaksi);
        transaksi.addActionListener(this);
        
        frame.add(isi);
        frame.add(menu);
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
            case "INPUT OBAT":
                new InputObat();
                frame.setVisible(false);
                break;
            case "RESTOCK OBAT":
                new ReStockObat();
                frame.setVisible(false);
                break;
            case "RUJUKAN":
                new PreRujukan();
                frame.setVisible(false);
                break;
            case "TRANSAKSI":
                new MenuTransaksi();
                frame.setVisible(false);
                break;
            default: 
                break;
        }
    }
}
