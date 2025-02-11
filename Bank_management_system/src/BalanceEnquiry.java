
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    String pinNumber;
    BalanceEnquiry(String pinNumber){
    this.pinNumber = pinNumber;

    setLayout(null);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image= new JLabel(i3);
    image.setBounds(0,0,900,900);
    add(image);


  
    back=new JButton("Back");
    back.setBounds(355,500,150,30);
    image.add(back);
    back.addActionListener(this);

     Conn conn=new Conn();
     int balance=0;
            try {
                ResultSet rs =conn.s.executeQuery("select * from bank where pinNumber='"+pinNumber+"'");
                while (rs.next()){
                    if(rs.getString("type").equals("deposit"))
                    {
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }

                }
            }catch (Exception e) {
                System.out.println(e);
            }

        JLabel text = new JLabel("Your current account balance is:  Rs "+balance);
        text.setBounds(175,300,400,30);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);

   
    }

    
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       setVisible(false);
       new Transaction(pinNumber);
    }
}
