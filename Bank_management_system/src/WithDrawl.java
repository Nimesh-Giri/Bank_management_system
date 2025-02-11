
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;


public class WithDrawl extends JFrame implements ActionListener{
    JButton withDrawl,back;
    JTextField withDrawlField;
    String pinNumber;

    WithDrawl(String pinNumber){
        this.pinNumber=pinNumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text .setBounds(195, 290, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
         
        withDrawlField= new JTextField();
        withDrawlField .setBounds(195, 340, 300, 30);
        withDrawlField.setForeground(Color.BLACK);
        withDrawlField.setFont(new Font("Raleway",Font.BOLD,14));
        image.add(withDrawlField);

        withDrawl = new JButton("Withdraw");
        withDrawl .setBounds(355, 505, 150 , 30);
        withDrawl.addActionListener(this);
        image.add(withDrawl);

        back = new JButton("Back");
        back.setBounds(165, 505, 120 , 30);
        back.addActionListener(this);
        image.add(back);



        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    public static void main(String[] args) {
        new WithDrawl("");
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==withDrawl){
            String withDrawlAmount = withDrawlField.getText();
            Date date = new Date();
            if(withDrawlAmount.equals("")){
                JOptionPane.showMessageDialog(null, "No Amount Entered");
            }else{
                try {
                Conn conn =  new Conn();
                String query = "INSERT INTO bank VALUES('" + pinNumber + "', '" + date + "', 'withdrawl', '" +withDrawlAmount  + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+withDrawlAmount+" Sucessfully Withdrawn");
                setVisible(false); 
                new Transaction(pinNumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
                


            }

        }else if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinNumber);

        }
       
    }
}
