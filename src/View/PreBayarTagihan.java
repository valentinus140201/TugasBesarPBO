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

import Model.*;
import Controller.*;
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

public class PreBayarTagihan implements ActionListener{
    ControllerDokter control = new ControllerDokter();
    
    JFrame frame = new JFrame("Pre Update Dokter");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menu_pasien = new JButton("PASIEN");
    JButton menu_dokter = new JButton("DOKTER");
    JButton menu_admin = new JButton("ADMINISTRASI");
    
    JLabel idTransaksi = new JLabel("Id Transaksi");
    JButton hitung = new JButton("LIHAT TRANSAKSI");
    String[] listIdTransaksi;
    JComboBox boxIdTransaksi;
    
    
    public PreBayarTagihan(ArrayList<Transaksi> listTransaksi){
        
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
        hitung.addActionListener(this);
        
        idTransaksi.setBounds(290, 260, 100, 20);
        hitung.setBounds(350,300,120,50);
        
        listIdTransaksi = new String[listTransaksi.size()];
        
        for(int i = 0; i < listTransaksi.size(); i++){
            Transaksi transaksi = listTransaksi.get(i);
            listIdTransaksi[i] = transaksi.getIdTransaksi();
        }
        
        boxIdTransaksi = new JComboBox(listIdTransaksi);
        boxIdTransaksi.setBounds(400, 260, 100, 20);
        
        
        
        isi.add(hitung);
        isi.add(boxIdTransaksi);
        isi.add(idTransaksi);
        
        
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
            case "LIHAT TRANSAKSI":
                ControllerTransaksi control = new ControllerTransaksi();
                String strIdTransaksi = String.valueOf(boxIdTransaksi.getSelectedItem());;
                Transaksi transaksi = control.getTransaksi(strIdTransaksi);
                new BayarTagihan(transaksi);
                frame.setVisible(false);
                break;
             default: 
                break;
        }
    }
}