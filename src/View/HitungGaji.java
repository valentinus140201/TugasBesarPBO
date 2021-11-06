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

public class HitungGaji implements ActionListener{
    
    JFrame frame = new JFrame("Absensi Dokter");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    JLabel labNid = new JLabel ("NID    :");
    JLabel labNama = new JLabel("Nama   :");
    JLabel labGaji = new JLabel("Gaji   :");
    
    
    
    JButton menu_pasien = new JButton("PASIEN");
    JButton menu_dokter = new JButton("DOKTER");
    JButton menu_admin = new JButton("ADMINISTRASI");
    
    private ControllerDokter control = new ControllerDokter();
    
    
    
    public HitungGaji(Dokter dokter){
        
        System.out.println(dokter.getNama());
        
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
        
        labNid.setBounds(290, 230, 100, 20);
        labNama.setBounds(290, 260, 100, 20);
        labGaji.setBounds(290, 290, 100, 20);
        //textNid.setBounds(400, 230, 100, 20);
        JLabel nama = new JLabel(dokter.getNama());
        JLabel nid = new JLabel(dokter.getNID());
        JLabel gaji = new JLabel(String.valueOf(dokter.hitungGaji()));
        nama.setBounds(400, 230, 100, 20);
        nid.setBounds(400, 260, 100, 20);
        gaji.setBounds(400, 290, 100, 20);
        
        isi.add(labNid);
        isi.add(labNama);
        isi.add(labGaji);
        isi.add(nama);
        isi.add(nid);
        isi.add(gaji);
        
        
        
        
        
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
            default: 
                break;
        }
    }
    
}