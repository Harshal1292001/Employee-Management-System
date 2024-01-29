package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {
    
    JButton view,update,add,remove;
    
    Home() {
        
        
        setSize(1050,580);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2=i1.getImage().getScaledInstance(1050,580,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1050,580);
        add(image);
        
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(550,15,400,40);
        heading.setForeground(Color.RED);
        heading.setFont(new Font("Arial Black",Font.BOLD,22));
        image.add(heading);
        
        add = new JButton("Add Employee");
        add.setBounds(550,80,150,30);
        add.addActionListener(this);
        image.add(add);
        
        view = new JButton("View Employee");
        view.setBounds(770,80,150,30);
        view.addActionListener(this);
        image.add(view);
        
        update = new JButton("Update Employee");
        update.setBounds(550,150,150,30);
        update.addActionListener(this);
        image.add(update);
        
        remove = new JButton("Remove Employee");
        remove.setBounds(770,150,150,30);
       remove.addActionListener(this);
        image.add(remove);
        
        
        setVisible(true);
        setLocation(200,80);
        setLayout(null);
    }
     public void actionPerformed(ActionEvent e) {
       if(e.getSource()==add) {
           setVisible(false);
           new AddEmployee();
           
       }
       else if(e.getSource()==view) {
           setVisible(false);
           new ViewEmployee();
           
       }
       else if(e.getSource()==update) 
       {
             setVisible(false);
             new ViewEmployee();
       }
       else if(e.getSource()==remove)
       {
            setVisible(false);
             new RemoveEmployee();
           
       }
       else {
           setVisible(false);
            new RemoveEmployee();
           
       }
    }
       
    public static void main(String []args) {
        new Home();
   
    }
    
}
