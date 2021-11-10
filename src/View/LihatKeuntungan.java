package View;

import Controller.ControllerTransaksi;
import Model.Singleton;
import Model.Transaksi;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LihatKeuntungan implements ActionListener{
/**
 *
 * @author hp
 */
    
    JFrame frame = new JFrame("MenuAdmin");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menu_pasien = new JButton("PASIEN");
    JButton menu_dokter = new JButton("DOKTER");
    JButton menu_admin = new JButton("ADMINISTRASI");
    JButton kembali_ke_menu = new JButton("KEMBALI KE MENU");
    

    public LihatKeuntungan(){
        
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

        
        JLabel labidCabang = new JLabel("Nama Cabang : ");
        JLabel labKeuntungan = new JLabel("Keuntungan : ");
        
        ArrayList<Transaksi> listTransaksi = ControllerTransaksi.getAllTransaksi("");
        long Keuntungan = 0;
        for (Transaksi transaksi : listTransaksi) {
            Keuntungan += transaksi.getTotal();
        }
        JLabel isilabidCabang = new JLabel(Singleton.getInstance().getCabang().getNama());
        JLabel isilabKeuntungan = new JLabel("Rp. " + Keuntungan);
        
        
        labidCabang.setBounds(50, 80, 110, 20);
        isi.add(labidCabang);
        isilabidCabang.setBounds(200, 80, 300, 20);
        isi.add(isilabidCabang);
        labKeuntungan.setBounds(50, 110, 80, 20);
        isi.add(labKeuntungan);
        isilabKeuntungan.setBounds(200, 110, 300, 20);
        isi.add(isilabKeuntungan);
        
        kembali_ke_menu.addActionListener(this);
        kembali_ke_menu.setBounds(350, 200, 150, 50);
        isi.add(kembali_ke_menu);
        
        frame.add(isi);
        frame.add(menu);
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
            case "KEMBALI KE MENU":
                frame.setVisible(false);
                new MenuAdmin();
                break;
            default: 
                break;
        }
    }
}

