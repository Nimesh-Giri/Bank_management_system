
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;


public class PinChange extends JFrame implements ActionListener{
    JTextField pinTextField,repinTextField;
    JButton change, back;
    String pinNumber;

    public PinChange(String pinNumber) {
        this.pinNumber=pinNumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Change your pin");
        text .setBounds(255, 290, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        JLabel pintext = new JLabel("New Pin: ");
        pintext .setBounds(165, 355, 100, 35);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        image.add(pintext);

        JLabel repintext = new JLabel(" Re-Enter New Pin: ");
        repintext .setBounds(165, 395, 200, 35);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        image.add(repintext);

        pinTextField = new JTextField();
        pinTextField.setBounds(370,355,120,25);
        pinTextField.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(pinTextField);

        repinTextField = new JTextField();
        repinTextField.setBounds(370,395,120,25);
        repinTextField.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(repinTextField);
        
        change = new JButton("Change");
        change.setBounds(390,490,100,35);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(190,490,100,35);
        back.addActionListener(this);
        image.add(back);


        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    
    public static void main(String args[])
    {
        new PinChange("");



    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==change){
            try {
                String npin = pinTextField.getText();
                String nrepin= repinTextField.getText();
                if(!npin.equals(nrepin)){
                    JOptionPane.showMessageDialog(null, "Entered pin doesn't match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new pin ");
                    return;
                }
                if(nrepin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter new pin" );
                }
                Conn conn = new Conn();
                String query1="update bank set pinNumber='"+npin+"' Where pinNumber ='"+pinNumber+"'";
                String query2="update login set pinNumber='"+npin+"' Where pinNumber ='"+pinNumber+"'";
                String query3="update signupthree set pinNumber='"+npin+"' Where pinNumber ='"+pinNumber+"'";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null, "Pin Changed Sucessfully");
                setVisible(false);
                new Transaction(npin).setVisible(true);
            } catch (Exception e) {

            }
        }
        else{
            setVisible(false);
            new Transaction(pinNumber);
        }

    }
    
}
