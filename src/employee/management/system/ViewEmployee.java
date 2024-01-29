
package employee.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
public class ViewEmployee extends JFrame implements ActionListener {
    
    JTable table;
    JLabel searchlb;
    Choice employeeId;
    JButton search, print, update, back;
 
    ViewEmployee()  {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        table=new JTable();
        
        searchlb = new JLabel("Searching Employee ID");
        searchlb.setBounds(20,20,150,30);
        add(searchlb);
        
        employeeId = new Choice();
        employeeId.setBounds(170,27,100,36);
        add(employeeId);
        
        search=new JButton("Search");
        search.setBounds(300,20,80,30);
        search.addActionListener(this);
        add(search);
        
        print=new JButton("Print");
        print.setBounds(400,20,80,30);
        print.addActionListener(this);
        add(print);
        
        update=new JButton("Update");
        update.setBounds(500,20,80,30);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(600,20,80,30);
        back .addActionListener(this);

        add(back);
        
        
        try {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from employee");
            while(rs.next())
            {
                employeeId.add(rs.getString("empId"));
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
        
        try {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
         JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,1010,800);
        add(jsp);
        
        setSize(400,300);
        setVisible(true);
        setLocation(230,100);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==search)
        {
            String query="select * from employee where empId= '"+employeeId.getSelectedItem()+"'";
            try {
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==print)
        {
            try {
                table.print();
                
            }
            catch(Exception e) 
            {
                e.printStackTrace();
                
            }
                
            
        }
        else if(ae.getSource()==update)
        {
            setVisible(false);
            new UpdateEmployee(employeeId.getSelectedItem());
        }
        else
        {
            setVisible(false);
            new Home();
            
        }
    }
 
    public static void main(String args[]) {
        
        new ViewEmployee();
    }
}
