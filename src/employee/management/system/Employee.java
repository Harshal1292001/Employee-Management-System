package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Employee extends JFrame implements ActionListener{
    Employee() {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80,20,1200,60);
        heading.setFont(new Font("serit",Font.BOLD,52));
        heading.setForeground(Color.red);
        add(heading);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2=i1.getImage().getScaledInstance(1000,600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(40,85,970,500);
        add(image);

        JButton clickhere = new JButton("CLICK HARE TO CONTINUE");
        clickhere.setBounds(380,380,280,50);
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.white);
        clickhere.addActionListener(this);
        image.add(clickhere);

        setSize(1070,650);
        setVisible(true);

        while(true)
        {
            heading.setVisible(false);
            try 
            {
                Thread.sleep(300);
            }
            catch (Exception e) 
            {

            }
            heading.setVisible(true);
            
            try 
            {
                Thread.sleep(300);
            }
            catch (Exception e) 
            {

            }
        }

    }
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }
        

    public static void main(String [] args) {
        new Employee();
      
    }
}
