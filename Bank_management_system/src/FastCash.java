

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener{
    JButton rs100,rs500,rs1000,rs2000,rs5000,rs10000,back;
    String pinNumber;

    public FastCash(String pinNumber)  {
        this.pinNumber=pinNumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please Select The Amount");
        text .setBounds(215, 290, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        rs100= new JButton("Rs 100");
        rs100.setBounds(170,390,150,30);
        image.add(rs100);
        rs100.addActionListener(this);

        rs500= new JButton(" Rs 500");
        rs500.setBounds(355,390,150,30);
        image.add(rs500);
        rs500.addActionListener(this);

        rs1000= new JButton("Rs 1000");
        rs1000.setBounds(170,425,150,30);
        image.add(rs1000);
        rs1000.addActionListener(this);

        rs2000= new JButton("Rs 2000");
        rs2000.setBounds(355,425,150,30);
        image.add(rs2000);
        rs2000.addActionListener(this);

        rs5000= new JButton("Rs 5000");
        rs5000.setBounds(170,460,150,30);
        image.add(rs5000);
        rs5000.addActionListener(this);

        rs10000= new JButton("Rs 10000");
        rs10000.setBounds(355,460,150,30);
        image.add(rs10000);
        rs10000.addActionListener(this);
        
        back= new JButton("Back");
        back.setBounds(250,500,150,30);
        image.add(back);
        back.addActionListener(this);

        
       





        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new FastCash("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinNumber);
        }else {
            String amount=((JButton)ae.getSource()).getText().substring(3);
            Conn conn=new Conn();
            try {
                ResultSet rs =conn.s.executeQuery("select * from bank where pinNumber='"+pinNumber+"'");
                int balance=0;
                while (rs.next()){
                    if(rs.getString("type").equals("deposit"))
                    {
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }

                }
                if(ae.getSource() != "back" && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficent Balance");
                    return;
                }
             Date date= new Date();
             String query = "INSERT INTO bank VALUES('" + pinNumber + "', '" + date + "', 'withDrawl', '" + amount + "')";
             conn.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "Rs "+amount+ " Debited Sucessfully");
             setVisible(false);
             new Transaction(pinNumber);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
     
    }
    
}
