import java.awt.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class Signup extends JFrame implements ActionListener{
	long ran;
	JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pcTextField;
	JButton next;
	JRadioButton male, female, other, married, unmarried;
	JDateChooser dateChooser;
	Signup(){
		
		setLayout(null);
		
		Random rand = new Random();
		ran = Math.abs((rand.nextLong() % 9000L)+1000L);
		JLabel formno = new JLabel("Application Number: "+ran);
		formno.setBounds(230,20,600,30);
		formno.setFont(new Font("Raleway",Font.BOLD,30));
		add(formno);
			
		JLabel personal = new JLabel("Page 1: Personal Details");
		personal.setBounds(265,90,600,30);
		personal.setFont(new Font("Raleway",Font.BOLD,25));
		add(personal);
		
		JLabel name = new JLabel("Name: ");
		name.setBounds(100,150,600,30);
		name.setFont(new Font("Raleway",Font.BOLD,20));
		add(name);
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Raleway", Font.BOLD,20));
		nameTextField.setBounds(300,150,400,30);
		add(nameTextField);
		
		JLabel fname = new JLabel("Father's Name: ");
		fname.setBounds(100,200,600,30);
		fname.setFont(new Font("Raleway",Font.BOLD,20));
		add(fname);
		fnameTextField = new JTextField();
		fnameTextField.setFont(new Font("Raleway", Font.BOLD,20));
		fnameTextField.setBounds(300,200,400,30);
		add(fnameTextField);
		
		JLabel dob = new JLabel("Date of Birth: ");
		dob.setBounds(100,250,600,30);
		dob.setFont(new Font("Raleway",Font.BOLD,20));
		add(dob);
		dateChooser = new JDateChooser();
		dateChooser.setBounds(300,250,400,30);
		add(dateChooser);
		
		JLabel gender = new JLabel("Gender: ");
		gender.setBounds(100,300,600,30);
		gender.setFont(new Font("Raleway",Font.BOLD,20));
		add(gender);
		male = new JRadioButton("Male");
		male.setBounds(300, 300,100,30);
		male.setBackground(Color.WHITE);
		add(male);;
		
		female = new JRadioButton("Female");
		female.setBounds(500, 300,100,30);
		female.setBackground(Color.WHITE);
		add(female);
		
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(female);
		genderGroup.add(male);
		
		JLabel email = new JLabel("Email Address: ");
		email.setBounds(100,350,600,30);
		email.setFont(new Font("Raleway",Font.BOLD,20));
		add(email);
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Raleway", Font.BOLD,20));
		emailTextField.setBounds(300,350,400,30);
		add(emailTextField);
		
		JLabel address = new JLabel("Address: ");
		address.setBounds(100,400,600,30);
		address.setFont(new Font("Raleway",Font.BOLD,20));
		add(address);
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Raleway", Font.BOLD,20));
		addressTextField.setBounds(300,400,400,30);
		add(addressTextField);
		
		JLabel marital = new JLabel("Marital Status: ");
		marital.setBounds(100,450,600,30);
		marital.setFont(new Font("Raleway",Font.BOLD,20));
		add(marital);
		
		married = new JRadioButton("Married");
		married.setBounds(300, 450,100,30);
		married.setBackground(Color.WHITE);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(430, 450,100,30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		other = new JRadioButton("Other");
		other.setBounds(560, 450,100,30);
		other.setBackground(Color.WHITE);
		add(other);
		
		ButtonGroup martialgroup = new ButtonGroup();
		martialgroup.add(married);
		martialgroup.add(unmarried);
		martialgroup.add(other);
		
		JLabel city = new JLabel("City: ");
		city.setBounds(100,500,600,30);
		city.setFont(new Font("Raleway",Font.BOLD,20));
		add(city);
		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Raleway", Font.BOLD,20));
		cityTextField.setBounds(300,500,400,30);
		add(cityTextField);
		
		JLabel state = new JLabel("State: ");
		state.setBounds(100,550,600,30);
		state.setFont(new Font("Raleway",Font.BOLD,20));
		add(state);
		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Raleway", Font.BOLD,20));
		stateTextField.setBounds(300,550,400,30);
		add(stateTextField);
		
		JLabel pc = new JLabel("Pin Code: ");
		pc.setBounds(100,600,600,30);
		pc.setFont(new Font("Raleway",Font.BOLD,20));
		add(pc);
		pcTextField = new JTextField();
		pcTextField.setFont(new Font("Raleway", Font.BOLD,20));
		pcTextField.setBounds(300,600,400,30);
		add(pcTextField);
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setBounds(620, 650, 80,30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String formno = ""+ran;
		String name = nameTextField.getText();
		String fname = fnameTextField.getText();
		String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if(male.isSelected())
		{
			gender = "Male";
		}
		else if(female.isSelected())
		{
			gender = "Female";
		}
		String email = emailTextField.getText();
		String marital = null;
		if(married.isSelected()){
			marital = "Married";
		}
		else if(unmarried.isSelected()) {
			marital = "Unmarried";
		}
		else if(other.isSelected()) {
			marital = "Other";
		}
		String address = addressTextField.getText();
		String city = cityTextField.getText();
		String state = stateTextField.getText();
		String pc = pcTextField.getText();
		
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is required");
			}
			else
			{
				Conn c = new Conn();
				String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+address+"', '"+marital+"', '"+city+"', '"+state+"', '"+pc+"')";
				c.s.executeUpdate(query);	
				setVisible(false);
				new Signuptwo(formno).setVisible(true);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Signup();
	}

}
