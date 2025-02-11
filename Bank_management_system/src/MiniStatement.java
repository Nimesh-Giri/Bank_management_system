
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class MiniStatement extends JFrame implements ActionListener {
    String pinNumber;
    MiniStatement( String pinNumber){
        this.pinNumber= pinNumber;

        JLabel bank = new JLabel("Citizens Bank");
        bank.setBounds(130,20,300,20);
        bank.setFont(new Font("System",Font.BOLD,18));
        add(bank);

        
        JLabel mini = new JLabel();
        mini.setBounds(20,100,400,350);
        add(mini);

        JLabel bal = new JLabel();
        bal.setBounds(20,480,500,20);
        add(bal);

        JLabel card = new JLabel ();
        card.setBounds(20,80,300,20);
        add(card);

        try {
            Conn conn = new Conn();
            ResultSet rs= conn.s.executeQuery("select * from login where pinNumber ='"+pinNumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("cardNumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardNumber").substring(12));

            }



            
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Conn conn = new Conn();
            int balance=0;
            ResultSet rs= conn.s.executeQuery("select * from bank where pinNumber ='"+pinNumber+"'");
            while(rs.next()){
                mini.setText(mini.getText()+"<html>" +rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getNString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getNString("amount")+"<br><br><html>");
                if(rs.getString("type").equals("deposit"))
                    {
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                bal.setText("Your Current balance is: Rs"+balance);   
            }



            
        } catch (Exception e) {
            System.out.println(e);
        }

        this.pinNumber=pinNumber;
        setLayout(null);
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);


    }
    

    public static void main(String[] args) {
        new MiniStatement("");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
}
