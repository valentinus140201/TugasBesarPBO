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

public class Rujukan implements ActionListener{
    
    JFrame frame = new JFrame("MainMenu");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menu_pasien = new JButton("PASIEN");
    JButton menu_dokter = new JButton("DOKTER");
    JButton menu_admin = new JButton("ADMINISTRASI");
    JTextArea rujuks;
    String text;
    
    
    public Rujukan(Pasien pasien, String rs){
        
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
        text = "\n\n\n\n\t\t\t\tSurat Rujukan Pasien\n\tKami dari staff dan dokter dari puskesmas ingin mengirim pasien kami.";
        text += "Karena\nalasan kekurangn sumber daya manusia dan alat medis di puskesmas kami. Dengan ini data pasien:\n";
        text += "\tNIK\t: " + pasien.getNama() + "\n";
        text += "\tNama\t: " + pasien.getNama() + "\n";
        text += "\tTelepon\t: " + pasien.getTelepon() + "\n";
        text += "\t Dengan ini kami menyatakan bahwa tanggung jawab pasien ini ada di tangan Rumah Sakit " + rs;
        text += ".\nAtas Kerjasamanya Terimakasih\n\n\n\n\n\n\n";
        text += "\t\t\t\t\t\tStaff Puskesmas\n\n\n";
        text += "\t\t\t\t\t\t" + Singleton.getInstance().getStaff().getUsername();
        rujuks = new JTextArea(text);
        rujuks.setBounds(10, 10, 1000, 600);
        rujuks.setFont(rujuks.getFont().deriveFont(15f));
        System.out.println(text);
        isi.add(rujuks);
        String bpjs = String.valueOf(pasien.getBPJS());
        
        
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