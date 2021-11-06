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


public class UpdateDokter implements ActionListener{
    private ControllerDokter control = new ControllerDokter();
    JFrame frame = new JFrame("Update Dokter");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menu_pasien = new JButton("PASIEN");
    JButton menu_dokter = new JButton("DOKTER");
    JButton menu_admin = new JButton("ADMINISTRASI");
    JButton submit = new JButton("SUBMIT");
    
    JLabel labNik = new JLabel("NIK");
    JLabel labNama = new JLabel("Nama");
    JLabel labTgllahir = new JLabel("Tanggal Lahir");
    JLabel labGoldar = new JLabel("Golongan Darah");
    JLabel labGender = new JLabel("Jenis Kelamin");
    JLabel labNid = new JLabel("NID");
    JLabel labPoli = new JLabel("Poloklinik");
    JLabel labNotelp = new JLabel("No Telepon");
    JLabel labAlamat = new JLabel("Alamat");
    JTextField textNik = new JTextField();
    JTextField textNama = new JTextField();
    UtilDateModel model = new UtilDateModel();
    Properties p = new Properties();
    JRadioButton male = new JRadioButton("Pria");
    JRadioButton female = new JRadioButton("Wanita");
    JTextField textNid = new JTextField();
    JTextField textNotelp = new JTextField();
    JRadioButton golo = new JRadioButton("O");
    JRadioButton gola = new JRadioButton("A");
    JRadioButton golb = new JRadioButton("B");
    JRadioButton golab = new JRadioButton("AB");
    String[] listPoli = {"Belum Dipilih", "Dokter Umum", "Dokter Spesialis Anak", "Dokter THT"};
    JComboBox Poli = new JComboBox(listPoli);
    JTextField textAlamat = new JTextField();
    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
    
    
    
    
    
    
    
    
    
    public UpdateDokter(Dokter dokter){
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
        //akhir template
        
        //isi menu
        textNik.setText(dokter.getNIK());
        textNama.setText(dokter.getNama());
        textNid.setText(dokter.getNID());
        textAlamat.setText(dokter.getAlamat());
        textNotelp.setText(dokter.getTelepon());
        labNik.setBounds(50, 80, 80, 20);
        isi.add(labNik);
        textNik.setBounds(200, 80, 300, 20);
        isi.add(textNik);
        labNama.setBounds(50, 110, 80, 20);
        isi.add(labNama);
        textNama.setBounds(200, 110, 300, 20);
        isi.add(textNama);
        
        
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        
        datePicker.setBounds(130, 130, 250, 30);
        labTgllahir.setBounds(50, 140, 80, 20);
        datePicker.setBounds(200, 140, 300, 30);
        isi.add(labTgllahir);
        isi.add(datePicker);
        
        labGoldar.setBounds(50, 180, 80, 20);
        isi.add(labGoldar);
        golo.setBounds(200, 180, 50, 15);
        gola.setBounds(250, 180, 50, 15);
        golb.setBounds(300, 180, 50, 15);
        golab.setBounds(350, 180, 50, 15);
        ButtonGroup gd = new ButtonGroup();
        gd.add(golo);
        gd.add(gola);
        gd.add(golb);
        gd.add(golab);
        isi.add(golo);
        isi.add(gola);
        isi.add(golb);
        isi.add(golab);
        
        labGender.setBounds(50, 220, 80, 20);
        isi.add(labGender);
        male.setBounds(200, 220, 50, 15);
        female.setBounds(270, 220, 70, 15);
        ButtonGroup jenisK = new ButtonGroup();
        jenisK.add(male);
        jenisK.add(female);
        isi.add(male);
        isi.add(female);
        
        labNid.setBounds(50, 250, 80, 20);
        isi.add(labNid);
        textNid.setBounds(200, 250, 300, 20);
        isi.add(textNid);
        
        labPoli.setBounds(50, 280, 80, 20);
        isi.add(labPoli);
        Poli.setBounds(200, 280, 300, 20);
        isi.add(Poli);
        
        labNotelp.setBounds(50, 310, 80, 20);
        isi.add(labNotelp);
        textNotelp.setBounds(200, 310, 300, 20);
        isi.add(textNotelp);
        
        labAlamat.setBounds(50, 340, 80, 20);
        isi.add(labAlamat);
        textAlamat.setBounds(200, 340, 300, 20);
        isi.add(textAlamat);
        
        
        
        submit.setBounds(350,400,120,50);
        submit.addActionListener(this);
        isi.add(submit);
        
        
        frame.add(isi);
        frame.add(menu);
        frame.setVisible(true);
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
                String strnik = textNik.getText();
                String strnama = textNama.getText();
                String strlahir = model.getYear() + "-" + model.getMonth() + "-" + model.getDay();
                String strgoldar = "";
                if (gola.isSelected()) {
                    strgoldar = gola.getText();
                } else if (golb.isSelected()) {
                    strgoldar = golb.getText();
                } else if (golo.isSelected()) {
                    strgoldar = golo.getText();
                } else if (golab.isSelected()) {
                    strgoldar = golab.getText();
                }
                
                String strgender = "";
                if (male.isSelected()) {
                    strgender = male.getText();
                } else if (female.isSelected()) {
                    strgender = female.getText();
                }
                
                String strnid = textNid.getText();
                String strpoli = "";
                strpoli = String.valueOf(Poli.getSelectedItem());
                String strnotelp = textNotelp.getText();
                String stralamat = textAlamat.getText();
                
                Date lahir = (Date)datePicker.getModel().getValue();
                Dokter dokter = new Dokter(strnid, strpoli, strnama, strnik, lahir, strgoldar, strgender, stralamat, strnotelp);
                JOptionPane.showMessageDialog(null,"Data Sudah Di Ubah");
                boolean update = control.updateDokter(dokter, strlahir);
                if(update == true){
                    frame.setVisible(false);
                    new MenuDokter();
                }
            default: 
                break;
        }
    }
    
    
    
}