import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.util.Random;
import javax.print.DocFlavor;

public class SignUpOne extends JFrame implements ActionListener {
    long random;
    JTextField nameTextField, fatherNameTextField, emailTextField, adressTextField, cityTextField, stateTextField, pinCodeTextField;
    JRadioButton male, female, married, unmarried, divorced;
    JDateChooser dateChooser;
    JButton next;
    String formNo;

    SignUpOne() {
        setLayout(null);
        
        
        Random ran = new Random();
       random = ran.nextInt(9000) + 1000;

        JLabel formNo = new JLabel("APPLICATION FORM NO: " + random);
        formNo.setFont(new Font("Raleway", Font.BOLD, 38));
        formNo.setBounds(140, 20, 600, 40);
        add(formNo);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100, 140, 100, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        JLabel fatherName = new JLabel("Father's Name:");
        fatherName.setFont(new Font("Raleway", Font.BOLD, 22));
        fatherName.setBounds(100, 190, 200, 30);
        add(fatherName);

        fatherNameTextField = new JTextField();
        fatherNameTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        fatherNameTextField.setBounds(300, 190, 400, 30);
        add(fatherNameTextField);

        JLabel DOB = new JLabel("Date Of Birth:");
        DOB.setFont(new Font("Raleway", Font.BOLD, 22));
        DOB.setBounds(100, 240, 200, 30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 100, 32);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 290, 100, 32);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);

        JLabel maritalStatus = new JLabel("Marital Status:");
        maritalStatus.setFont(new Font("Raleway", Font.BOLD, 22));
        maritalStatus.setBounds(100, 390, 200, 30);
        add(maritalStatus);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 32);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(420, 390, 100, 32);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        divorced = new JRadioButton("Divorced");
        divorced.setBounds(550, 390, 100, 32);
        divorced.setBackground(Color.WHITE);
        add(divorced);

        ButtonGroup maritalButtonGroup = new ButtonGroup();
        maritalButtonGroup.add(married);
        maritalButtonGroup.add(unmarried);
        maritalButtonGroup.add(divorced);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 22));
        address.setBounds(100, 440, 200, 30);
        add(address);

        adressTextField = new JTextField();
        adressTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        adressTextField.setBounds(300, 440, 400, 30);
        add(adressTextField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(100, 540, 200, 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 22));
        city.setBounds(100, 490, 200, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);


        JLabel pinCode = new JLabel("Pin Code:");
        pinCode.setFont(new Font("Raleway", Font.BOLD, 22));
        pinCode.setBounds(100, 590, 200, 30);
        add(pinCode);

        pinCodeTextField = new JTextField();
        pinCodeTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        pinCodeTextField.setBounds(300, 590, 400, 30);
        add(pinCodeTextField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 15));
        next.setBounds(700, 700, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String formNo = "" + random;
        String name = nameTextField.getText();
        String fatherName = fatherNameTextField.getText();
        String DOB = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        
        String gender = null;
        if (male.isSelected()) {
            gender = "male";
        } else if (female.isSelected()) {
            gender = "female";
        }
    
        String email = emailTextField.getText();
        
        String maritalStatus = null; 
        if (married.isSelected()) {
            maritalStatus = "married";
        } else if (unmarried.isSelected()) {
            maritalStatus = "unmarried";
        } else if (divorced.isSelected()) {
            maritalStatus = "Divorced";
        } 
    
        String address = adressTextField.getText(); 
        String state = stateTextField.getText();
        String city = cityTextField.getText();
        String pinCode = pinCodeTextField.getText();
    
        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else{
                Conn c= new Conn();
                String query ="insert into SignUp Values('"+formNo+"', '"+name+"','"+fatherName+"','"+DOB+"','"+gender+"','"+email+"','"+maritalStatus+"','"+address+"','"+state+"','"+city+"','"+pinCode+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignUpTwo(formNo).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        new SignUpOne();
    }
}    
