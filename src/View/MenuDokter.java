/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;

/**
 *
 * @author hp
 */

public class MenuDokter implements ActionListener{
    JFrame frame = new JFrame("MenuDokter");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menu_pasien = new JButton("PASIEN");
    JButton menu_dokter = new JButton("DOKTER");
    JButton menu_admin = new JButton("ADMINISTRASI");
    JButton insert_dokter = new JButton("INSERT DOKTER");
    JButton update_dokter = new JButton("UPDATE DOKTER");
    JButton delete_dokter = new JButton("DELETE DOKTER");
    JButton absensi_dokter = new JButton("ABSENSI DOKTER");
    JButton hitung_gaji = new JButton("HITUNG GAJI");
    
    
    public MenuDokter(){
        
        frame.setSize(1200, 700);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
        menu.setLayout(null);
        isi.setLayout(null);
        
        menu.setBounds(10,10,200,640);
        isi.setBounds(230,10,930,640);
        
        isi.setBackground(Color.ORANGE);
        menu.setBackground(Color.ORANGE);
        
        menu_pasien.setBounds(35,200,120,50);
        menu_dokter.setBounds(35,260,120,50);
        menu_admin.setBounds(35,320,120,50);
        
        menu.add(menu_dokter);
        menu.add(menu_pasien);
        menu.add(menu_admin);
        
        menu_dokter.addActionListener(this);
        menu_pasien.addActionListener(this);
        menu_admin.addActionListener(this);
        
        insert_dokter.setBounds(350,100,200,50);
        update_dokter.setBounds(350,200,200,50);
        delete_dokter.setBounds(350,300,200,50);
        absensi_dokter.setBounds(350,400,200,50);
        hitung_gaji.setBounds(350, 500, 200, 50);
        
        isi.add(insert_dokter);
        isi.add(update_dokter);
        isi.add(delete_dokter);
        isi.add(absensi_dokter);
        isi.add(hitung_gaji);

        insert_dokter.addActionListener(this);
        update_dokter.addActionListener(this);
        delete_dokter.addActionListener(this);
        absensi_dokter.addActionListener(this);
        hitung_gaji.addActionListener(this);

        frame.add(isi);
        frame.add(menu);
   
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
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
            case "INSERT DOKTER":
                new InputDokter();
                frame.setVisible(false);
                break;
            case "UPDATE DOKTER":
                new PreUpdateDokter();
                frame.setVisible(false);
                break;
            case "DELETE DOKTER":
                new DeleteDokter();
                frame.setVisible(false);
                break;
            case "ABSENSI DOKTER":
                new ViewAbsensiDokter();
                frame.setVisible(false);
                break;
            case "HITUNG GAJI":
                new PreHitungGaji();
                frame.setVisible(false);
                break;
            default: 
                break;
        }
    }
    
//    public static void main(String[] args){
//        new MenuDokter();
//    }
}
