/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerRiwayatPasien;
import Model.RiwayatPasien;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author V for Vladimir
 */
public class viewLihatRiwayat1Pasien implements ActionListener{
    JFrame lihatRiwayatPasien = new JFrame("Lihat Riwayat Pasien");
    JLabel NIKInputLabel,tglKunjunganInput,namaLabel;
    JTextField NIKInputField;
    JTable tableRiwayatPasien;
    JButton lihatRiwayat;
    JPanel panelMenu,panelContent;
    JScrollPane scrollPane;
    JDatePickerImpl tglKunjungan;
    JDatePanelImpl datePanel;
    JButton menu_pasien = new JButton("PASIEN");
    JButton menu_dokter = new JButton("DOKTER");
    JButton menu_admin = new JButton("ADMINISTRASI");
    public viewLihatRiwayat1Pasien() {
        namaLabel = new JLabel("Nama : ");
        NIKInputLabel = new JLabel("NIK");
        NIKInputField = new JTextField();
        panelMenu = new JPanel();
        panelContent = new JPanel();
        lihatRiwayat = new JButton("lihat Riwayat");
        
        NIKInputLabel.setBounds(10,10,120,25);
        NIKInputField.setBounds(140,10,120,25);
        lihatRiwayat.setBounds(800, 500, 130, 25);
        
        menu_pasien.setBounds(35,200,120,50);
        menu_dokter.setBounds(35,260,120,50);
        menu_admin.setBounds(35,320,120,50);
        
        panelContent.add(NIKInputLabel);
        panelContent.add(NIKInputField);
        panelContent.add(lihatRiwayat);
        
        panelMenu.add(menu_dokter);
        panelMenu.add(menu_pasien);
        panelMenu.add(menu_admin);
        
        lihatRiwayatPasien.setSize(1200, 700);
        lihatRiwayatPasien.setLocationRelativeTo(null);
        lihatRiwayatPasien.setLayout(null);
        panelMenu.setLayout(null);
        panelContent.setLayout(null);
        panelMenu.setBounds(10,10,200,640);
        panelContent.setBounds(230,10,930,640);
        panelMenu.setBackground(Color.cyan);
        panelContent.setBackground(Color.cyan);
        lihatRiwayatPasien.add(panelContent);
        lihatRiwayatPasien.add(panelMenu);
        lihatRiwayatPasien.setVisible(true);
        lihatRiwayatPasien.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lihatRiwayat.addActionListener(this);
        menu_dokter.addActionListener(this);
        menu_pasien.addActionListener(this);
        menu_admin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command) {
            case "PASIEN": 
                new MenuPasien();
                lihatRiwayatPasien.setVisible(false);
                break;
            case "DOKTER":
                new MenuDokter();
                lihatRiwayatPasien.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                lihatRiwayatPasien.setVisible(false);
                break;
            case "lihat Riwayat":
                String[] column = {"tgl kunjungan","keluhan","penyakit","resep obat"};
                ArrayList<RiwayatPasien> RP = ControllerRiwayatPasien.getAllRiwayatPasiens(NIKInputField.getText());
                ArrayList<String> resepObat = ControllerRiwayatPasien.getResepObat1Pasien(NIKInputField.getText());
                StringBuffer sb = new StringBuffer();
                String data[][] = new String[RP.size()][4];
                for(int i = 0; i < RP.size(); i++){
                    data[i][0] = String.valueOf(RP.get(i).getTanggalKunjungan());
                    data[i][1] = RP.get(i).getKeluhan();
                    data[i][2] = RP.get(i).getPenyakit();
                    for(String s : resepObat){
                        sb.append(s);
                        sb.append(",");
                    }
                    String str = sb.toString();
                    data[i][3] = str;
                }
                tableRiwayatPasien = new JTable(data,column);
                scrollPane = new JScrollPane(tableRiwayatPasien);
                scrollPane.setBounds(10,80,910,200);
                panelContent.add(scrollPane);
                break;
            default: 
                break;
        }
    }
}
