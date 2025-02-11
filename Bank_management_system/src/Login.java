
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class Login extends JFrame implements ActionListener
{
    //Global declaration
    JButton signUp , logIn , clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login()
    {
        //nolayout
        setLayout(null);
        //Title of page
        setTitle("ATM");
        //setting logo for 1st page
        ImageIcon i1 = new ImageIcon(getClass().getResource("Icons\\logo.png"));
        Image i2 =i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=  new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(30,10,100,100);
        getContentPane().setBackground(Color.WHITE);
        add(label);

        //setting heading for the page
        JLabel text=new JLabel("Welcome To ATM");
        add(text);
        text.setFont(new Font("osward", Font.BOLD,38));
        text.setBounds(200,20,600,100);

        //setting card no
        JLabel cardNo=new JLabel("CARD NO:");
        cardNo.setFont(new Font("Raleway", Font.BOLD,28));
        cardNo.setBounds(150,150,150,40);
        add(cardNo);

       //setting textfield for uder to input card no
        cardTextField = new JTextField();
        cardTextField.setBounds(330,150,250,40);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        //setting pin 
        JLabel pin=new JLabel("PIN :");
        pin.setFont(new Font("Raleway", Font.BOLD,28));
        pin.setBounds(150,220,100,40);
        add(pin);

        //setting pinfield for user to enter pin
        pinTextField = new JPasswordField();
        pinTextField.setBounds(330,220,250,40);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

    
        //setting of login button
        //user can access atm if they login with correct cardno and pin
        logIn = new JButton("Log In");
        logIn.setBounds(350,300,80,50);
        add(logIn);
        logIn.addActionListener(this);

        //signup button for new user
        signUp =new JButton("Sign Up");
        signUp.setBounds(450,300,80,50);
        add(signUp);
        signUp.addActionListener(this);

        //clear cardno and pin entered
        clear= new JButton("Clear");
        clear.setBounds(400,370,80,50);
        add(clear);
        clear.addActionListener(this);

        //setting up frame
        setSize(800,500);
        setVisible(true);
        setLocation(250,250);

    }     

    /*since we have implemented actionlistner we must override it's function ie.action performed
     its work is to handle user action like what to do or call when user click a particular button
     */
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==signUp)
        {
            setVisible(false);
           new SignUpOne();
        }
        else if(ae.getSource()==logIn)
        {
            Conn conn=new Conn();
            String cardNumber=cardTextField.getText();
            String pinNumber=pinTextField.getText();
            String query="select * from login where cardNumber='"+cardNumber+"'and pinNumber='"+pinNumber+"'";

            try {
               ResultSet rs=conn.s.executeQuery(query);
               if(rs.next()){
                setVisible(false);
                new Transaction(pinNumber);
            }else{
                JOptionPane.showMessageDialog(null, "Incorrect credentials");
            }
    
               
                
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }
        else if(ae.getSource()==clear)
        {
            pinTextField.setText("");
            cardTextField.setText("");
        }
        
    }
    public static void main(String[] args)
    {
        new Login();
        
        
    }
}