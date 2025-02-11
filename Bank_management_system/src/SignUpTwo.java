import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SignUpTwo extends JFrame implements ActionListener {
    JTextField citizenShipTextField, occupationTextField;
    JRadioButton scyes,scno, eayes,eano;
    JComboBox religonBox,categoryBox,incomeBox,educationBox;
    String formNo;
    JButton next;

    SignUpTwo(String formNo) {
        this.formNo= formNo;
        setLayout(null);
        setTitle("New Application form Page-2:");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails); 

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 22));
        religion.setBounds(100, 140, 200, 30);
        add(religion);

        String religionVal[] ={"Hindu","Buddist","muslim","other"};
        religonBox = new JComboBox(religionVal);
        religonBox.setBounds(400, 140, 200, 30);
        religonBox.setBackground(Color.WHITE);
        add(religonBox);

       

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 22));
        category.setBounds(100, 190, 200, 30);
        add(category);

        String categoryVal[]={"Brahmin","Chhetri","Dashnami","Janjati","muslim","Others"};
        categoryBox= new JComboBox(categoryVal);
        categoryBox.setBounds(400, 190, 200, 30);
        categoryBox.setBackground(Color.WHITE);
        add(categoryBox);
    
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 22));
        income.setBounds(100, 240, 200, 30);
        add(income);

        String incomeVal[]={"<1,00,000","<5,00,000","<15,00,000","<30,00,000",">30,00,000"};
        incomeBox = new JComboBox(incomeVal);
        incomeBox.setBounds(400, 240, 200, 30);
        incomeBox.setBackground(Color.WHITE);
        add(incomeBox);

        JLabel educationQualification = new JLabel("Education");
        educationQualification.setFont(new Font("Raleway", Font.BOLD, 22));
        educationQualification.setBounds(100, 290, 200, 30);
        add(educationQualification);

        String educationVal[]={"Primary Level","Secondary Level","Intermediate Level","UnderGraduate Level","Graduate Level","Phd"};
        educationBox=new JComboBox(educationVal);
        educationBox.setBackground(Color.WHITE);
        educationBox.setBounds(400, 290, 200, 30);
        add(educationBox);

        JLabel occupation = new JLabel("Occupation");
        occupation.setFont(new Font("Raleway", Font.BOLD, 22));
        occupation.setBounds(100, 340, 200, 30);
        add(occupation);

        occupationTextField = new JTextField();
        occupationTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        occupationTextField.setBounds(400, 340, 400, 30);
        add(occupationTextField);


        JLabel citizenshipNumber = new JLabel("Citizenship Number:");
        citizenshipNumber.setFont(new Font("Raleway", Font.BOLD, 22));
        citizenshipNumber.setBounds(100, 390, 350, 30);
        add(citizenshipNumber);

      
        citizenShipTextField = new JTextField();
        citizenShipTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        citizenShipTextField.setBounds(400, 390, 400, 30);
        add(citizenShipTextField);

        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 22));
        seniorCitizen.setBounds(100, 440, 200, 30);
        add(seniorCitizen);
        
        scyes = new JRadioButton("Yes");
        scyes.setBounds(400, 440, 100, 32);
        scyes.setBackground(Color.WHITE);
        add(scyes);

        
        scno = new JRadioButton("no");
        scno.setBounds(500, 440, 100, 32);
        scno.setBackground(Color.WHITE);
        add(scno);

        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(scyes);
        seniorCitizenGroup.add(scno);

      
        JLabel existingAccount = new JLabel("Existing Account");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 22));
        existingAccount.setBounds(100, 490, 200, 30);
        add(existingAccount);

        eayes = new JRadioButton("Yes");
        eayes.setBounds(400, 490, 100, 32);
        eayes.setBackground(Color.WHITE);
        add(eayes);

        eano = new JRadioButton("No");
        eano.setBounds(500, 490, 100, 32);
        eano.setBackground(Color.WHITE);
        add(eano);

        ButtonGroup existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(eayes);
        existingAccountGroup.add(eano);
        
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
        String  religion = (String)religonBox.getSelectedItem();
        String  category = (String)categoryBox.getSelectedItem();
        String  income = (String)incomeBox.getSelectedItem(); 
        String  education= (String)educationBox.getSelectedItem();

        String seniorCitizen = null;
        if (scyes.isSelected()) {
            seniorCitizen = "Yes";
        } else if (scno.isSelected()) {
            seniorCitizen = "no";
        }
    
        String existingAccount = null;
        if (eayes.isSelected()) {
            existingAccount = "yes";
        } else if (eano.isSelected()) {
            existingAccount = "no";
        }

        String occupation= occupationTextField.getText();
        String citizenshipNumber = citizenShipTextField.getText();
        try {

            if (citizenshipNumber.equals("")) {
                JOptionPane.showMessageDialog(null, "CItizenship Number is Required");
            }
            else{
                Conn c= new Conn();
                String query ="insert into SignUpTwo Values('"+formNo+"','"+religion+"', '"+category+"','"+income+"','"+education+"','"+seniorCitizen+"','"+existingAccount+"','"+occupation+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                 new SignUpThree(formNo).setVisible(true);
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}    
