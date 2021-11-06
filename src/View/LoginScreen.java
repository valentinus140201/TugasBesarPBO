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
import Controller.*;


public class LoginScreen implements ActionListener{
    JFrame frame = new JFrame("Login");
    JLabel labusername = new JLabel("Username");
    JLabel labpassword = new JLabel("Password");
    JTextField textusername = new JTextField();
    JPasswordField textpassword = new JPasswordField();
    JButton login = new JButton("LOGIN");
    ControllerStaff control = new ControllerStaff();
    
    
    public LoginScreen(){
        
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        labusername.setBounds(30, 100, 100, 30);
        labpassword.setBounds(30, 150, 100, 30);
        textusername.setBounds(120, 100, 200, 30);
        textpassword.setBounds(120, 150, 200, 30);
        login.setBounds(140, 200, 100, 30);
        frame.add(login);
        frame.add(labusername);
        frame.add(labpassword);
        frame.add(textusername);
        frame.add(textpassword);
        
        login.addActionListener(this);
        
        
        frame.setVisible(true);
        
        
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae){
        String command = ae.getActionCommand();
        if(command == "LOGIN"){
            Staff staff = control.getStaff(textusername.getText());
            if(textusername.getText().equals(staff.getUsername())){
                if(textpassword.getText().equals(staff.getPassword())){
                    Singleton.getInstance().setStaff(staff);
                    Singleton.getInstance().setCabang(control.getCabang(staff.getIdCabang()));
                    frame.setVisible(false);
                    new MainMenu();
                }else{
                    JOptionPane.showMessageDialog(null,"Username Atau Password Salah");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Username Atau Password Salah");
            }
            
            if(textusername.getText().equals("") || textpassword.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Username Atau Password Harus Di isi");
            }
        }
        
    }
    
}
