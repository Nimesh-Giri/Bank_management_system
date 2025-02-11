

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transaction extends JFrame implements ActionListener{
    JButton deposit,withDrawl,fastCash,miniStatement,pinChange,balanceEnquiry,exit;
    String pinNumber;

    public Transaction(String pinNumber)  {
        this.pinNumber=pinNumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text .setBounds(215, 290, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit= new JButton("Deposit");
        deposit.setBounds(170,390,150,30);
        image.add(deposit);
        deposit.addActionListener(this);

        withDrawl= new JButton(" Cash WithDrawl");
        withDrawl.setBounds(355,390,150,30);
        image.add(withDrawl);
        withDrawl.addActionListener(this);

        fastCash= new JButton("Fast Cash");
        fastCash.setBounds(170,425,150,30);
        image.add(fastCash);
        fastCash.addActionListener(this);

        miniStatement= new JButton("Mini-Statement");
        miniStatement.setBounds(355,425,150,30);
        image.add(miniStatement);
        miniStatement.addActionListener(this);

        pinChange= new JButton("Change Pin");
        pinChange.setBounds(170,460,150,30);
        image.add(pinChange);
        pinChange.addActionListener(this);

        balanceEnquiry= new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(355,460,150,30);
        image.add(balanceEnquiry);
        balanceEnquiry.addActionListener(this);
        
        exit= new JButton("Exit");
        exit.setBounds(250,500,150,30);
        image.add(exit);
        exit.addActionListener(this);

        
       





        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Transaction("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==exit){
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }else if(ae.getSource()==withDrawl){
            setVisible(false);
            new WithDrawl(pinNumber).setVisible(true);
        }else if(ae.getSource()==fastCash){
            new FastCash(pinNumber).setVisible(true);
        }else if(ae.getSource()==pinChange){
            new PinChange(pinNumber).setVisible(true);
        }else if(ae.getSource()== balanceEnquiry){
            new BalanceEnquiry(pinNumber).setVisible(true);
        }else if(ae.getSource()==miniStatement){
            new MiniStatement(pinNumber).setVisible(true);
        }
      
    }
    
}
