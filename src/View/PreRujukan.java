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

import Controller.*;
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

public class PreRujukan implements ActionListener{
    
    JFrame frame = new JFrame("Absensi Dokter");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    JLabel labNid = new JLabel("NIK");
    JTextField textNid = new JTextField();
    JLabel namars = new JLabel("Rumah Sakit");
    
    
    
    JButton menu_pasien = new JButton("PASIEN");
    JButton menu_dokter = new JButton("DOKTER");
    JButton menu_admin = new JButton("ADMINISTRASI");
    JButton submit = new JButton("SUBMIT");
    String[] listrs = {"Boromeus", "Santosa Pasir Kaliki", "Santosa Kopo", "Immanuel"};
    JComboBox rs = new JComboBox(listrs);
    
    private ControllerPasien control = new ControllerPasien();
    
    
    
    public PreRujukan(){
        
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
        textNid.setBounds(400, 230, 200, 20);
        
        namars.setBounds(290, 260, 100, 20);
        rs.setBounds(400, 260, 200, 20);
        
        submit.addActionListener(this);
        submit.setBounds(350, 350, 150, 50);
        
        isi.add(namars);
        isi.add(rs);
        isi.add(labNid);
        isi.add(textNid);
        isi.add(submit);
        
        
        
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
            case "SUBMIT":
                String strnid = textNid.getText();
                Pasien pasien = control.getPasien(strnid);
                String strrs = String.valueOf(rs.getSelectedItem());;
                frame.setVisible(false);
                new Rujukan(pasien, strrs);
            default: 
                break;
        }
    }
    
}