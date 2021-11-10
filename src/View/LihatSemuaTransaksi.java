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

import Controller.ControllerTransaksi;
import Model.Dokter;
import Model.Singleton;
import Model.Transaksi;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
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
import javax.swing.table.JTableHeader;

public class LihatSemuaTransaksi implements ActionListener{
    
    JFrame frame = new JFrame("Lihat Semua Transaksi");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menu_pasien = new JButton("PASIEN");
    JButton menu_dokter = new JButton("DOKTER");
    JButton menu_admin = new JButton("ADMINISTRASI");
    JButton obatPasien = new JButton("PERNCAIRAN RESEP DOKTER");
    JButton lihatTransaksi = new JButton("LIHAT SEMUA TRANSAKSI");
    
    JTable table;
    JScrollPane scroll;
    
    
    public LihatSemuaTransaksi(){
        
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
        
        ArrayList<Transaksi> listTransaksi = ControllerTransaksi.getAllTransaksi("");
        String[] header = {"Id Transaksi", "NIK", "Tanggal", "Nama", "Total Harga"};
        
        String[][] isitable = new String[listTransaksi.size()][5];
        
        for(int i = 0; i < listTransaksi.size(); i++){
            Transaksi transaksi = listTransaksi.get(i);
            isitable[i][0] = transaksi.getIdTransaksi();
            isitable[i][1] = transaksi.getPasien().getNIK();
            isitable[i][2] = transaksi.getTanggalMasuk().toString();
            isitable[i][3] = transaksi.getPasien().getNama();
            isitable[i][4] = "" + transaksi.getTotal();
        }
        
        table = new JTable(isitable, header);
        scroll = new JScrollPane(table);
        scroll.setBounds(50, 50, 800, 500);
        isi.add(scroll);

        
        frame.add(isi);
        frame.add(menu);
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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