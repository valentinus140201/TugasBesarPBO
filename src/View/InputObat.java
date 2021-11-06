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
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import Controller.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InputObat implements ActionListener{
    private ControllerObat control = new ControllerObat();
    JFrame frame = new JFrame("Input Dokter");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menu_pasien = new JButton("PASIEN");
    JButton menu_dokter = new JButton("DOKTER");
    JButton menu_admin = new JButton("ADMINISTRASI");
    JButton submit = new JButton("SUBMIT");
    
    JLabel labNama = new JLabel("Nama");
    JLabel labBeli = new JLabel("Harga Beli");
    JLabel labJual = new JLabel("Harga Jual");
    JTextField textNama = new JTextField();
    JTextField textBeli = new JTextField();
    JTextField textJual = new JTextField();
    
    
    
    
    
    
    
    
    
    public InputObat(){
        //template
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
        labNama.setBounds(50, 160, 80, 20);
        isi.add(labNama);
        textNama.setBounds(200, 160, 300, 20);
        isi.add(textNama);
        labBeli.setBounds(50, 200, 80, 20);
        isi.add(labBeli);
        textBeli.setBounds(200, 200, 300, 20);
        isi.add(textBeli);
        labJual.setBounds(50, 240, 80, 20);
        isi.add(labJual);
        textJual.setBounds(200, 240, 300, 20);
        isi.add(textJual);
        
        submit.setBounds(350,400,120,50);
        submit.addActionListener(this);
        isi.add(submit);
        
        frame.add(isi);
        frame.add(menu);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
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
                int beli = Integer.parseInt(textBeli.getText());
                int jual = Integer.parseInt(textJual.getText());
                String strnama = textNama.getText();
                Obat obat = new Obat();
                obat.setIDObat(control.getLastIDObat());
                obat.setNama(strnama);
                obat.setHargaBeli(beli);
                obat.setHargaJual(jual);
                boolean input = control.addObat(obat);
                if(input == true){
                    frame.setVisible(false);
                    JOptionPane.showMessageDialog(null,"Data Sudah Di Tambah");
                    new MenuAdmin();
                    frame.setVisible(false);
                }                
            default: 
                break;
        }
    }
    
    
}
