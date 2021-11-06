/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerPasien;
import Model.Pasien;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author V for Vladimir
 */
public class ViewSearchPasien implements ActionListener{
    JFrame viewSearchPasien = new JFrame("Search Pasien");
    JLabel NIKOutputLabel,namaLabel,tglLahirLabel,golonganPasienLabel,
            alamatLabel,noKontakLabel,genderLabel,alergiLabel,goldarLabel,
            penyakitMenurunLabel,NIKInputLabel;
    JTextField NIKInputTextField;
    JButton buttonSearch,buttonUpdate;
    JPanel panelMenu,panelContent;
    JButton menu_pasien = new JButton("PASIEN");
    JButton menu_dokter = new JButton("DOKTER");
    JButton menu_admin = new JButton("ADMINISTRASI");
    
    public ViewSearchPasien(){
        NIKInputLabel = new JLabel("masukkan NIK pasien");
        NIKOutputLabel = new JLabel();
        namaLabel = new JLabel();
        tglLahirLabel = new JLabel();
        golonganPasienLabel = new JLabel();
        alamatLabel = new JLabel();
        noKontakLabel = new JLabel();
        genderLabel = new JLabel();
        alergiLabel = new JLabel();
        goldarLabel = new JLabel();
        penyakitMenurunLabel = new JLabel();
        NIKInputTextField = new JTextField();
        panelContent = new JPanel();
        panelMenu = new JPanel();
        buttonSearch = new JButton("Cari Pasien");
        buttonUpdate = new JButton("Ubah Data Pasien");
        
        viewSearchPasien.setSize(1200, 700);
        viewSearchPasien.setLocationRelativeTo(null);
        viewSearchPasien.setLayout(null);
        panelMenu.setLayout(null);
        panelContent.setLayout(null);
        panelMenu.setBounds(10,10,200,640);
        panelContent.setBounds(230,10,930,640);
        panelContent.setBackground(Color.cyan);
        panelMenu.setBackground(Color.cyan);
        
        menu_pasien.setBounds(35,200,120,50);
        menu_dokter.setBounds(35,260,120,50);
        menu_admin.setBounds(35,320,120,50);
        NIKInputLabel.setBounds(10, 10, 150, 25);
        NIKInputTextField.setBounds(170, 10, 120, 25);
        
        NIKOutputLabel.setBounds(10, 10, 200, 25);
        namaLabel.setBounds(10, 40, 200, 25);
        tglLahirLabel.setBounds(10, 70, 200, 25);
        golonganPasienLabel.setBounds(10, 100, 200, 25);
        alamatLabel.setBounds(10, 130, 200, 25);
        noKontakLabel.setBounds(10, 160, 200, 25);
        genderLabel.setBounds(10, 190, 200, 25);
        alergiLabel.setBounds(10, 210, 200, 25);
        goldarLabel.setBounds(10, 240, 200, 25);
        penyakitMenurunLabel.setBounds(10, 270, 200, 25);
        
        buttonSearch.setBounds(800, 500, 120, 25);
        buttonUpdate.setBounds(800, 500, 120, 25);
        
        namaLabel.setVisible(false);
        tglLahirLabel.setVisible(false);
        golonganPasienLabel.setVisible(false);
        alamatLabel.setVisible(false);
        noKontakLabel.setVisible(false);
        genderLabel.setVisible(false);
        alergiLabel.setVisible(false);
        goldarLabel.setVisible(false);
        buttonUpdate.setVisible(false);
        
        panelContent.add(NIKInputLabel);
        panelContent.add(NIKInputTextField);
        
        panelContent.add(namaLabel);
        panelContent.add(tglLahirLabel);
        panelContent.add(golonganPasienLabel);
        panelContent.add(alamatLabel);
        panelContent.add(noKontakLabel);
        panelContent.add(genderLabel);
        panelContent.add(alergiLabel);
        panelContent.add(goldarLabel);
        panelContent.add(penyakitMenurunLabel);
        panelContent.add(buttonSearch);
        panelContent.add(buttonUpdate);
        
        panelMenu.add(menu_dokter);
        panelMenu.add(menu_pasien);
        panelMenu.add(menu_admin);
        
        viewSearchPasien.add(panelContent);
        viewSearchPasien.add(panelMenu);
        viewSearchPasien.setVisible(true);
        viewSearchPasien.setLocationRelativeTo(null);
        viewSearchPasien.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu_dokter.addActionListener(this);
        menu_pasien.addActionListener(this);
        menu_admin.addActionListener(this);
        buttonSearch.addActionListener(this);
        buttonUpdate.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "PASIEN": 
                new MenuPasien();
                viewSearchPasien.setVisible(false);
                break;
            case "DOKTER":
                new MenuDokter();
                viewSearchPasien.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                viewSearchPasien.setVisible(false);
                break;
            case "Cari Pasien":
                Pasien p = ControllerPasien.getPasien(NIKInputTextField.getText());
                if(p != null){
                    NIKInputLabel.setVisible(false);
                    NIKInputTextField.setVisible(false); 
                    buttonSearch.setVisible(false);
                    
                    namaLabel.setVisible(true);
                    tglLahirLabel.setVisible(true);
                    golonganPasienLabel.setVisible(true);
                    alamatLabel.setVisible(true);
                    noKontakLabel.setVisible(true);
                    genderLabel.setVisible(true);
                    alergiLabel.setVisible(true);
                    goldarLabel.setVisible(true);
                    buttonUpdate.setVisible(true);
                    
                    NIKOutputLabel.setText("NIK : " + p.getNIK());
                    namaLabel.setText("Nama : " + p.getNama());
                    tglLahirLabel.setText("Tanggal Lahir : " + p.getTglLahir());
                    golonganPasienLabel.setText("Golongan : " + p.getBPJS());
                    alamatLabel.setText("alamat : " + p.getAlamat());
                    noKontakLabel.setText("no Kontak : " + p.getTelepon());
                    genderLabel.setText("Gender : " + p.getGender());
                    alergiLabel.setText("Alergi : " + p.getAlergi());
                    penyakitMenurunLabel.setText("Penyakit Menurun : " + p. getPenyakitMenurun());
                    goldarLabel.setText("Goldar : " + p.getGolDar());
                }else{
                    JOptionPane.showMessageDialog(null, "Data Pasien tidak ditemukan");
                }
                break;
            case "Ubah Data Pasien":
                p = ControllerPasien.getPasien(NIKInputTextField.getText());
                viewSearchPasien.setVisible(false);
                new ViewUpdateDataPasien(p.getNIK());
                break;
            default: 
                break;
        }
    }
}
