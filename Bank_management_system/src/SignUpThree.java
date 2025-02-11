import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.management.Query;

import javax.swing.*;

public class SignUpThree extends JFrame implements ActionListener{
    JRadioButton currentAC,savingAC,fixedAC,recurringAC;
    JCheckBox atm,internetBanking,mobileBanking,smsAlert,chequeBook,eStatement,declaration;
    JButton cancel, submit;
    String formNo;
    SignUpThree(String formNo){
        this.formNo=formNo;
        setLayout(null);

        JLabel l1 = new JLabel("Page3:Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,26));
        l1.setBounds(280,20,400,40);
        add(l1);

        JLabel accountType = new JLabel("Account Type:");
        accountType.setFont(new Font("Raleway",Font.BOLD,20));
        accountType.setBounds(100,100,300,40);
        add(accountType);

        currentAC = new JRadioButton("Current Account");
        currentAC.setBounds(100, 160, 200, 30);
        currentAC.setBackground(Color.WHITE);
        add(currentAC);

        savingAC= new JRadioButton("Saving Account");
        savingAC.setBounds(350, 160, 200, 30);
        savingAC.setBackground(Color.WHITE);
        add(savingAC);

        fixedAC= new JRadioButton("Fixed Account");
        fixedAC.setBounds(100, 210, 200, 30);
        fixedAC.setBackground(Color.WHITE);
        add(fixedAC);

        recurringAC= new JRadioButton("Reccuring Account");
        recurringAC.setBounds(350, 210, 200, 30);
        recurringAC.setBackground(Color.WHITE);
        add(recurringAC);

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(currentAC);
        accountGroup.add(savingAC);
        accountGroup.add(fixedAC);
        accountGroup.add(recurringAC);

        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,20));
        card.setBounds(100,260,200,40);
        add(card);

        JLabel cardDetail = new JLabel("Your 16 digits card number");
        cardDetail.setFont(new Font("Raleway",Font.BOLD,10));
        cardDetail.setBounds(100,295,200,10);
        add(cardDetail);

        JLabel cardNumber = new JLabel("XXXX-XXXX-XXXX-4186");
        cardNumber.setFont(new Font("Raleway",Font.PLAIN,20));
        cardNumber.setBounds(350,260,300,40);
        add(cardNumber);

        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100,320,200,40);
        add(pin);

        JLabel pinDetail = new JLabel("Your 4 digit pin code:");
        pinDetail.setFont(new Font("Raleway",Font.BOLD,10));
        pinDetail.setBounds(100,355,200,10);
        add(pinDetail);

        JLabel pNumber = new JLabel("XXXX");
        pNumber.setFont(new Font("Raleway",Font.PLAIN,20));
        pNumber.setBounds(350,320,300,40);
        add(pNumber);

        JLabel servicesRequired = new JLabel("Services Required:");
        servicesRequired.setFont(new Font("Raleway",Font.BOLD,20));
        servicesRequired.setBounds(100,400,300,40);
        add(servicesRequired);

        atm = new JCheckBox("ATM Card");
        atm.setBackground(Color.WHITE);
        atm.setFont(new Font("Raleway",Font.BOLD,12));
        atm.setBounds(100,450,200,30);
        add(atm);

        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBackground(Color.WHITE);
        internetBanking.setFont(new Font("Raleway",Font.BOLD,12));
        internetBanking.setBounds(350,450,200,30);
        add(internetBanking);

        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setBackground(Color.WHITE);
        mobileBanking.setFont(new Font("Raleway",Font.BOLD,12));
        mobileBanking.setBounds(100,490,200,30);
        add(mobileBanking);

        smsAlert = new JCheckBox("SMS Alerts");
        smsAlert.setBackground(Color.WHITE);
        smsAlert.setFont(new Font("Raleway",Font.BOLD,12));
        smsAlert.setBounds(350,490,200,30);
        add(smsAlert);

        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setBackground(Color.WHITE);
        chequeBook.setFont(new Font("Raleway",Font.BOLD,12));
        chequeBook.setBounds(100,530,200,30);
        add(chequeBook);

        eStatement = new JCheckBox("E-Statements");
        eStatement.setBackground(Color.WHITE);
        eStatement.setFont(new Font("Raleway",Font.BOLD,12));
        eStatement.setBounds(350,530,200,30);
        add(eStatement);

        declaration = new JCheckBox("I declare all information provided above are correct.");
        declaration.setBackground(Color.WHITE);
        declaration.setFont(new Font("Raleway",Font.BOLD,22));
        declaration.setBounds(100,600,800,40);
        add(declaration);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 15));
        submit.setBounds(650, 700, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 15));
        cancel.setBounds(500, 700, 100, 30);
        cancel.addActionListener(this);
        add(cancel);





        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }
  

  
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()== submit){
            String accountType= null;
            if(currentAC.isSelected()){
                accountType=" Current Account";
            }else if(savingAC.isSelected()){
                accountType=" Saving Account";
            }else if(fixedAC.isSelected()){
                accountType=" Fixed Account";
            }else if(recurringAC.isSelected()){
                accountType=" Recurring Account";
            }

        
        Random random = new Random();
        String cardNumber=""+Math.abs((random.nextLong()%90000000L)+504093600000000L);
        String pinNumber =""+Math.abs((random.nextLong()%9000L)+1000L);
        String facility ="";
        if(atm.isSelected()){
            facility= facility + "ATM CARD";
        }
        else if(internetBanking.isSelected()){
            facility= facility + "Internet Banking ";
        }
        else if(mobileBanking.isSelected()){
            facility= facility + "Mobile Banking";
        }
        else if(smsAlert.isSelected()){
            facility= facility + "SMS Alerts";
        }
        else if(chequeBook.isSelected()){
            facility= facility + "Cheque Book";
        }
        else if(eStatement.isSelected()){
            facility= facility + "E-Statement";
        }

        try {

            if(accountType.equals("")){
                JOptionPane.showMessageDialog(null, "Account type needed");
            }
            else{
                Conn conn =new Conn();
                String query1="insert into signupthree values('"+formNo+"', '"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
                String query2="insert into login values('"+formNo+"','"+cardNumber+"','"+pinNumber+"')";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Card Number: "+cardNumber +"\n"+"Pin Code:"+ pinNumber);
        
                setVisible(false);
                new Deposit(pinNumber).setVisible(true);
            }
            
        } catch (Exception e) {
         System.out.println(e);
        }


    }else if (ae.getSource()== cancel){
            setVisible(false);
            new Login();
        }
    }

    
}
