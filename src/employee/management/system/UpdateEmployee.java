

package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {
    
   
    JLabel heading,firstname,jlbname,fathername,lastname,DOB,lbsalary,lbmobile,lbemail,lbaddress,lbeducation,lbdesignation,lbaddarno,lbempid,empid;
    
    JTextField tfeducation,jtmiddle,jtlast,jtsalary,jtmobile,jtemail,jtaddress,jtdesignation,jtaddarno;
   
    JButton add,back;
    String empId;
    
   
    
    UpdateEmployee(String empId)  {
        this.empId=empId;
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
          
        heading = new JLabel("Update Employee Detail");
        heading.setBounds(280, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        firstname=new JLabel("First Name :");
        firstname.setBounds(40,120,200,40);
        firstname.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(firstname);
        
        jlbname=new JLabel();
        jlbname.setBounds(155,133,100,25);
        add(jlbname);
        
        fathername=new JLabel("Middle Name");
        fathername.setBounds(285,120,200,40);
        fathername.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(fathername);
        
        jtmiddle=new JTextField();
        jtmiddle.setBounds(420,133,100,25);
        add(jtmiddle);
        
        
        lastname=new JLabel("Last Name :");
        lastname.setBounds(550,120,200,40);
        lastname.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lastname);
        
        jtlast=new JTextField();
        jtlast.setBounds(670,133,100,25);
        add(jtlast);
        
        DOB=new JLabel("Date Of Birthday :");
        DOB.setBounds(40,180,200,40);
        DOB.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(DOB);
        
        JLabel dob=new JLabel();
        dob.setBounds(210,189,100,25);
        add(dob);
        
        lbsalary=new JLabel("Salary :");
        lbsalary.setBounds(338,180,200,40);
        lbsalary.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbsalary);
        
        jtsalary=new JTextField();
        jtsalary.setBounds(410,190,100,25);
        add(jtsalary);
        
        lbmobile=new JLabel("Mobile Number :");
        lbmobile.setBounds(540,180,150,40);
        lbmobile.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbmobile);
        
        jtmobile=new JTextField();
        jtmobile.setBounds(690,188,80,25);
        add(jtmobile);
        
        lbaddress = new JLabel("Address :");
        lbaddress.setBounds(40, 250, 150, 25);
        lbaddress.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbaddress);
        
        jtaddress = new JTextField();
        jtaddress.setBounds(140, 253, 300, 25);
        add(jtaddress);
        
        
        lbemail=new JLabel("EMAIL ID :");
        lbemail.setBounds(40,300,200,40);
        lbemail.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbemail);
        
        jtemail=new JTextField();
        jtemail.setBounds(148,312,200,25);
        add(jtemail);
        
       
        lbeducation=new JLabel("Highest Education :");
        lbeducation.setBounds(390,303,200,40);
        lbeducation.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbeducation);
        
        tfeducation=new JTextField();
        tfeducation.setBounds(570,312,200,25);
        add(tfeducation);
        
        
        lbdesignation=new JLabel("Designation :");
        lbdesignation.setBounds(40,360,200,40);
        lbdesignation.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbdesignation);
        
        jtdesignation=new JTextField();
        jtdesignation.setBounds(165,368,150,25);
        add(jtdesignation);
        
        lbaddarno=new JLabel("Aadhar Number :");
        lbaddarno.setBounds(385,360,200,40);
        lbaddarno.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbaddarno);
        
        JLabel jladdr=new JLabel();
        jladdr.setBounds(547,375,150,25);
        add(jladdr);
        
        lbempid=new JLabel("Employee ID :");
        lbempid.setBounds(40,420,200,40);
        lbempid.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbempid);
        
        empid=new JLabel();
        empid.setBounds(170,420,150,40);
        empid.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(empid);
        
        try {
            Conn c=new Conn();
            String query="select * from employee where empId='"+empId+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                 jlbname.setText(rs.getString("fname"));
                jtmiddle.setText(rs.getString("mname"));
                jtlast.setText(rs.getString("lname"));

                dob.setText(rs.getString("dob"));
                jtaddress.setText(rs.getString("address"));
                jtsalary.setText(rs.getString("salary"));
                jtmobile.setText(rs.getString("mobile"));
                jtemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                jladdr.setText(rs.getString("aadhar"));
                empid.setText(rs.getString("empId"));
                jtdesignation.setText(rs.getString("designation"));
                                        
                
                
            }
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        
        add=new JButton("Update Details");
        add.setBounds(150,480,200,50);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        add.setForeground(Color.red);
        add(add);
        
        back=new JButton("Back");
        back.setBounds(490,480,200,50);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.red);
        back.addActionListener(this);
        add(back);
        
        setSize(800,600);
        setVisible(true);
        setLocation(300,50);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add)
        {
            String fname = jlbname.getText();
            String mname = jtmiddle.getText();
            String lname = jtlast.getText();
            String salary = jtsalary.getText();
            String address = jtaddress.getText();
            String mobile = jtmobile.getText();
            String email = jtemail.getText();
            String designation = jtdesignation.getText();
            String education = tfeducation.getText();
            
            try {
                Conn conn = new Conn();
                String query = "update employee set fname = '"+fname+"',mname='"+mname+"',lname='"+lname+"', salary = '"+salary+"', address = '"+address+"', mobile = '"+mobile+"', email =  '"+email+"', education = '"+education+"', designation = '"+designation+"' where empId = '"+empId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Home();
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
   
        }
        else 
        {
            setVisible(false);
            new Home();
            
        }
        
    }


    public static void main(String args[]) {
        new UpdateEmployee("");
    }
}
