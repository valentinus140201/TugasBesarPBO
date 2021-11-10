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

import Controller.ControllerDokter;
import Controller.ControllerTransaksi;
import Model.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class PreBayarTagihanNik implements ActionListener{
    
    JFrame frame = new JFrame("Cari Nik Untuk Bayar Tagihan");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    JLabel labNik = new JLabel("NIk");
    JTextField textNik = new JTextField();
    
    
    
    JButton menu_pasien = new JButton("PASIEN");
    JButton menu_dokter = new JButton("DOKTER");
    JButton menu_admin = new JButton("ADMINISTRASI");
    JButton cari = new JButton("CARI");

    private ControllerDokter control = new ControllerDokter();
    
    
    
    public PreBayarTagihanNik(){
        
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
        
        labNik.setBounds(290, 230, 100, 20);
        textNik.setBounds(400, 230, 100, 20);
        

        cari.addActionListener(this);
        cari.setBounds(350, 350, 150, 50);
        
        isi.add(labNik);
        isi.add(textNik);
        isi.add(cari);
        
        
        
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
            case "CARI":
                ControllerTransaksi control = new ControllerTransaksi();
                String strnik = textNik.getText();
                ArrayList<Transaksi> listTransaksi = control.getAllTransaksi(strnik);
                frame.setVisible(false);
                new PreBayarTagihan(listTransaksi);
                break;
            default: 
                break;
        }
    }
    
}