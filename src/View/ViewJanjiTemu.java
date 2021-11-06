/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerDokter;
import Model.Dokter;
import Model.Transaksi;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author V for Vladimir
 */
public class ViewJanjiTemu implements ActionListener{
    JFrame janjiTemu = new JFrame("buat Janji Temu pasien dengan dokter");
    JLabel NIKLabel,poliLabel,dokterLabel,hargaLabel;
    JTextField NIKField;
    JComboBox<Object>dokterField,poliField;
    JButton buttonNext,buttonBuatJanji,buttonBack;
    JPanel panelContent,panelMenu;
    JButton menu_pasien = new JButton("PASIEN");
    JButton menu_dokter = new JButton("DOKTER");
    JButton menu_admin = new JButton("ADMINISTRASI");
    public ViewJanjiTemu(){
        NIKLabel = new JLabel("NIK");
        poliLabel = new JLabel("poli");
        dokterLabel = new JLabel("nama dokter");
        hargaLabel = new JLabel("harga");
        String[] poli = {"Dokter Umum","Dokter THT","Dokter Spesialis Anak"};
        poliField = new JComboBox<>(poli);
        dokterField = new JComboBox<>();
        NIKField = new JTextField();
        buttonBuatJanji = new JButton("Done");
        buttonNext = new JButton("next");
        buttonBack = new JButton("back");
        panelContent = new JPanel();
        panelMenu = new JPanel();
        buttonBuatJanji.setVisible(false);
        buttonBack.setVisible(false);
        dokterLabel.setVisible(false);
        dokterField.setVisible(false);
        
        NIKLabel.setBounds(245, 10, 160, 25);
        poliLabel.setBounds(245, 50, 160, 25);
        dokterLabel.setBounds(245, 90, 160, 25);
        dokterField.setBounds(325, 90, 160, 25);
        NIKField.setBounds(325, 10, 160, 25);
        poliField.setBounds(325, 50, 160, 25);
        buttonBack.setBounds(690, 500, 100, 25);
        buttonNext.setBounds(800, 500, 100, 25);
        buttonBuatJanji.setBounds(800, 500, 100, 25);
        
        panelMenu.setBounds(10,10,200,640);
        panelContent.setBounds(230,10,930,640);
        
        panelContent.setLayout(null);
        panelMenu.setLayout(null);
        janjiTemu.setLayout(null);
        
        
        panelContent.setBackground(Color.cyan);
        panelMenu.setBackground(Color.cyan);
        menu_pasien.setBounds(35,200,120,50);
        menu_dokter.setBounds(35,260,120,50);
        menu_admin.setBounds(35,320,120,50);
        
        panelContent.add(NIKLabel);
        panelContent.add(NIKField);
        panelContent.add(poliLabel);
        panelContent.add(poliField);
        panelContent.add(dokterLabel);
        panelContent.add(dokterField);
        panelContent.add(buttonNext);
        panelContent.add(buttonBack);
        panelContent.add(buttonBuatJanji);
        
        panelMenu.add(menu_admin);
        panelMenu.add(menu_dokter);
        panelMenu.add(menu_pasien);
        menu_dokter.addActionListener(this);
        menu_pasien.addActionListener(this);
        menu_admin.addActionListener(this);
        buttonNext.addActionListener(this);
        buttonBack.addActionListener(this);
        buttonBuatJanji.addActionListener(this);
        janjiTemu.add(panelContent);
        janjiTemu.add(panelMenu);
        janjiTemu.setSize(1200, 700);
        janjiTemu.setVisible(true);
        janjiTemu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        ControllerDokter CD = new ControllerDokter();
        ArrayList<Dokter> DAL = CD.getAllDokter();
        switch(command) {
            case "PASIEN": 
                new MenuPasien();
                janjiTemu.setVisible(false);
                break;
            case "DOKTER":
                new MenuDokter();
                janjiTemu.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                janjiTemu.setVisible(false);
                break;
            case "next":
                for (int i = 0; i < DAL.size(); i++) {
                    if(DAL.get(i).getPoliklinik().equals(poliField.getSelectedItem())){
                        dokterField.addItem(DAL.get(i).getNama());
                    }
                }
                dokterLabel.setVisible(true);
                dokterField.setVisible(true);
                buttonBack.setVisible(true);
                buttonBuatJanji.setVisible(true);
                poliField.setVisible(false);
                NIKField.setVisible(false);
                buttonNext.setVisible(false);
                poliLabel.setText("poliklinik : " + poliField.getSelectedItem());
                NIKLabel.setText("NIK : " + NIKField.getText());
                break;
            case "back":
                dokterField.removeAllItems();
                dokterLabel.setVisible(false);
                dokterField.setVisible(false);
                buttonBack.setVisible(false);
                buttonBuatJanji.setVisible(false);
                poliField.setVisible(true);
                NIKField.setVisible(true);
                buttonNext.setVisible(true);
                poliLabel.setText("poliklinik");
                NIKLabel.setText("NIK");
                break;
            case "Done":
                double hargaKonsul = 15000;
                hargaLabel.setText("harga = " + hargaKonsul);
                new ViewBeliObatPasien(NIKField.getText(),hargaKonsul);
                janjiTemu.setVisible(false);
                break;
            default: 
                break;
        }
    }
}
