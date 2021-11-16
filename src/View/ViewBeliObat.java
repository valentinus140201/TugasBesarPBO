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
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author V for Vladimir
 */
public class ViewBeliObat {
    JFrame beliObat = new JFrame();
    JLabel jumlahJenisObatLabel,namaObatLabel,totalHarga,jumlahObatLabel;
    JTextField jumlahJenisObatField;
    JTextField[] namaObatFields,jumlahObatFields;
    JButton buttonHitungTotalHarga,buttonLanjut;
    JPanel panelContent,panelMenu;
    JButton menuPasien = new JButton("PASIEN");
    JButton menuDokter = new JButton("DOKTER");
    JButton menuAdmin = new JButton("ADMINISTRASI");
   
    public ViewBeliObat(){
        beliObat.setSize(1200, 620);
        jumlahJenisObatLabel = new JLabel("Jumlah Jenis Obat");
        jumlahJenisObatField = new JTextField();
        buttonLanjut = new JButton("NEXT");
        buttonHitungTotalHarga = new JButton("Hitung Total Harga");
        panelContent = new JPanel();
        panelMenu = new JPanel();
        
        panelContent.setLayout(null);
        panelMenu.setLayout(null);
        
        panelContent.setBackground(Color.ORANGE);
        panelMenu.setBackground(Color.ORANGE);
        
        panelMenu.setBounds(10,10,200,640);
        panelContent.setBounds(230,10,930,640);
        jumlahJenisObatLabel.setBounds(265, 10, 140, 25);
        jumlahJenisObatField.setBounds(420, 10, 140, 25);
        buttonLanjut.setBounds(265, 400, 150, 25);
        buttonHitungTotalHarga.setBounds(740, 500, 150, 25);
        
        menuPasien.setBounds(35,200,120,50);
        menuDokter.setBounds(35,260,120,50);
        menuAdmin.setBounds(35,320,120,50);
        
        panelContent.add(jumlahJenisObatLabel);
        panelContent.add(jumlahJenisObatField);
        panelContent.add(buttonLanjut);
        panelContent.add(buttonHitungTotalHarga);
        panelContent.add(buttonLanjut);
        panelContent.add(buttonLanjut);
        panelMenu.add(menuPasien);
        panelMenu.add(menuDokter);
        panelMenu.add(menuAdmin);
        
        beliObat.add(panelMenu);
        beliObat.add(panelContent);
        beliObat.setLayout(null);
        
        beliObat.setUndecorated(true);
        beliObat.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        beliObat.setVisible(true);
        beliObat.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
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
                        namaObatLabel = new JLabel("Nama Obat " + (i+1));
                        jumlahObatLabel = new JLabel("Jumlah Obat " + (i+1) + "(Miligram)");
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
                    JOptionPane.showMessageDialog(null, "INPUT BUKAN ANGKA!");
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
