package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JTextField tfusername;
    JPasswordField tfpassword;
    Login() {
         getContentPane().setBackground(Color.white);
         setLayout(null);
         JLabel lbusername=new JLabel("Username :");
         lbusername.setBounds(40,20,100,30);
         add(lbusername);
         
         tfusername = new JTextField();
         tfusername.setBounds(150,20,150,30); 
         add(tfusername);
         
         JLabel lbpassword=new JLabel("Password :");
         lbpassword.setBounds(40,80,100,30);
         add(lbpassword);
         
         tfpassword = new JPasswordField();
         tfpassword.setBounds(150,80,150,30); 
         add(tfpassword);
         
         JButton login = new JButton("Login");
        login.setBounds(150,160,150,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        

         
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,250,200);
        add(image);
      
         
         setSize(650,330);
         setVisible(true);
         setLocation(400,150);

    }
    public void actionPerformed(ActionEvent ae) {
        try {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            Conn c = new Conn();
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
            
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        


    public static void main(String []args)
    {
        new Login();
    }
    
}
