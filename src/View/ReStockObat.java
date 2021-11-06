/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerObat;
import Model.Obat;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author hp
 */

public class ReStockObat implements ActionListener{
    private ControllerObat control = new ControllerObat();
    JFrame frame = new JFrame("reStock obat");
    JLabel namaObatLabel,tglBeliLabel,tglKadaluarsaLabel,StockLabel;
    UtilDateModel model1 = new UtilDateModel();
    UtilDateModel model2 = new UtilDateModel();
    Properties p = new Properties();
    JTextField textStok,namaField;
    JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, p);
    JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p);
    JDatePickerImpl tgl_beli = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
    JDatePickerImpl tgl_kadaluarsa = new JDatePickerImpl(datePanel2, new DateLabelFormatter());

    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    JButton menu_pasien = new JButton("PASIEN");
    JButton menu_dokter = new JButton("DOKTER");
    JButton menu_admin = new JButton("ADMINISTRASI");
    JButton submit = new JButton("SUBMIT");
    public ReStockObat(){
        namaObatLabel = new JLabel("nama obat");
        tglBeliLabel = new JLabel("tgl beli");
        tglKadaluarsaLabel = new JLabel("tgl kadaluarsa");
        StockLabel = new JLabel("stock");
        textStok = new JTextField();
        namaField = new JTextField();
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
        
        namaObatLabel.setBounds(10, 10, 120, 25);
        tglBeliLabel.setBounds(10, 40, 120, 25);
        tglKadaluarsaLabel.setBounds(10, 70, 120, 25);
        StockLabel.setBounds(10, 100, 120, 25);
        
        namaField.setBounds(140, 10, 120, 25);
        tgl_beli.setBounds(140, 40, 120, 25);
        tgl_kadaluarsa.setBounds(140, 70, 120, 25);
        textStok.setBounds(140, 100, 120, 25);
        
        submit.setBounds(10, 500, 100, 25);
        
        isi.add(namaObatLabel);
        isi.add(tglBeliLabel);
        isi.add(tglKadaluarsaLabel);
        isi.add(StockLabel);
        isi.add(namaField);
        isi.add(tgl_beli);
        isi.add(tgl_kadaluarsa);
        isi.add(textStok);
        isi.add(submit);
        
        menu.add(menu_dokter);
        menu.add(menu_pasien);
        menu.add(menu_admin);
        menu_dokter.addActionListener(this);
        menu_pasien.addActionListener(this);
        menu_admin.addActionListener(this);
        submit.addActionListener(this);
        frame.add(isi);
        frame.add(menu);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                String strnama = namaField.getText();
                int stok = Integer.parseInt(textStok.getText());
                String strtglbeli = model1.getYear() + "-" + model1.getMonth() + "-" + model1.getDay();
                String strtglkadal = model2.getYear() + "-" + model2.getMonth() + "-" + model2.getDay();
                
                Obat obat = new Obat();
                obat.setIDMasaLakuObat(control.getIDMLO());
                obat.setIDObat(control.getObat(strnama).getIDObat());
                obat.setStok(stok);
                obat.setTgl_beli(strtglbeli);
                obat.setTgl_kadaluarsa(strtglkadal);
                boolean input = control.beliObat(obat);
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
