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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author V for Vladimir
 */
public class ViewBeliObat {
    JFrame formBeliObat = new JFrame();
    JLabel jumlahJenisObatLabel,namaObatLabel,totalHarga,jumlahObatLabel;
    JTextField jumlahJenisObatField;
    JTextField[] namaObatFields,jumlahObatFields;
    JButton buttonHitungTotalHarga,buttonLanjut;
    JPanel panelContent,panelMenu;
    JButton menu_pasien = new JButton("PASIEN");
    JButton menu_dokter = new JButton("DOKTER");
    JButton menu_admin = new JButton("ADMINISTRASI");
    public ViewBeliObat(){
        formBeliObat.setSize(1200, 700);
        jumlahJenisObatLabel = new JLabel("jumlah Jenis obat");
        jumlahJenisObatField = new JTextField();
        buttonLanjut = new JButton("Lanjut");
        buttonHitungTotalHarga = new JButton("hitung total harga");
        panelContent = new JPanel();
        panelMenu = new JPanel();
        
        panelContent.setLayout(null);
        panelMenu.setLayout(null);
        
        panelContent.setBackground(Color.CYAN);
        panelMenu.setBackground(Color.CYAN);
        
        panelMenu.setBounds(10,10,200,640);
        panelContent.setBounds(230,10,930,640);
        jumlahJenisObatLabel.setBounds(265, 10, 140, 25);
        jumlahJenisObatField.setBounds(420, 10, 140, 25);
        buttonLanjut.setBounds(265, 400, 150, 25);
        buttonHitungTotalHarga.setBounds(740, 500, 150, 25);
        
        menu_pasien.setBounds(35,200,120,50);
        menu_dokter.setBounds(35,260,120,50);
        menu_admin.setBounds(35,320,120,50);
        
        panelContent.add(jumlahJenisObatLabel);
        panelContent.add(jumlahJenisObatField);
        panelContent.add(buttonLanjut);
        panelContent.add(buttonHitungTotalHarga);
        panelContent.add(buttonLanjut);
        panelContent.add(buttonLanjut);
        panelMenu.add(menu_pasien);
        panelMenu.add(menu_dokter);
        panelMenu.add(menu_admin);
        
        formBeliObat.add(panelMenu);
        formBeliObat.add(panelContent);
        formBeliObat.setLayout(null);
        formBeliObat.setVisible(true);
        formBeliObat.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        buttonLanjut.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                jumlahJenisObatLabel.setVisible(false);
                jumlahJenisObatField.setVisible(false);
                buttonLanjut.setVisible(false);
                try {
                    String jmlStr = jumlahJenisObatField.getText();
                    int jml = Integer.parseInt(jmlStr);
                    namaObatFields = new JTextField[jml];
                    jumlahObatFields = new JTextField[jml];
                    for(int i = 0; i < namaObatFields.length; i++){
                        namaObatLabel = new JLabel("nama obat " + (i+1));
                        jumlahObatLabel = new JLabel("jumlah obat " + (i+1) + "(dalam mg)");
                        namaObatFields[i] = new JTextField();
                        jumlahObatFields[i] = new JTextField();
                        
                        namaObatLabel.setBounds(265, (i*3+1)*10, 100, 25);
                        namaObatFields[i].setBounds(385, (i*3+1)*10, 120, 25);
                        jumlahObatLabel.setBounds(515, (i*3+1)*10, 180, 25);
                        jumlahObatFields[i].setBounds(675, (i*3+1)*10, 120, 25);
                        
                        panelContent.add(namaObatLabel);
                        panelContent.add(namaObatFields[i]);
                        panelContent.add(jumlahObatLabel);
                        panelContent.add(jumlahObatFields[i]);
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "input bukan angka!");
                    if(JOptionPane.OK_OPTION == 0){
                        jumlahJenisObatField.setText("");
                    }
                }
            }
        });
        buttonHitungTotalHarga.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                //looping query ke DB bwt cek stok obat
                //tranksaksi masukkin ke db
            }
        });
    }
}
