import java.awt.*;
import java.util.*;
import javax.swing.*;

import java.awt.event.*;

import java.awt.event.*;
public class Signuptwo extends JFrame implements ActionListener{
	JTextField educationalTextField, addressTextField, panTextField, aadharTextField, eaTextField;
	JButton next;
	JRadioButton syes, sno, eyes, eno;
	JComboBox religion, category, income,educational, occupation;
	String formno;
	Signuptwo(String formno){
		this.formno = formno;
		setTitle("New Account Application Form: Page 2");
		
		setLayout(null);
			
		JLabel additional = new JLabel("Page 2: Additional Details");
		additional.setBounds(265,50,600,30);
		additional.setFont(new Font("Raleway",Font.BOLD,25));
		add(additional);
		
		JLabel name = new JLabel("Religion: ");
		name.setBounds(100,150,600,30);
		name.setFont(new Font("Raleway",Font.BOLD,20));
		add(name);
		String valReligion[] ={"Hindu", "Christian", "Muslim", "Sikh", "Other"};
		religion = new JComboBox(valReligion);
		religion.setBounds(300,150,400,30);
		add(religion);
		religion.setBackground(Color.WHITE);
		
		JLabel fname = new JLabel("Category: ");
		fname.setBounds(100,200,600,30);
		fname.setFont(new Font("Raleway",Font.BOLD,20));
		add(fname);
		String valCategory[] ={"General", "OBC", "SC", "ST", "Other"};
		category = new JComboBox(valCategory);
		category.setBounds(300,200,400,30);
		category.setBackground(Color.WHITE);
		add(category);
				
		JLabel gender = new JLabel("Income: ");
		gender.setBounds(100,250,600,30);
		gender.setFont(new Font("Raleway",Font.BOLD,20));
		add(gender);
		String valIncome[] ={"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
		income = new JComboBox(valIncome);
		income.setBounds(300,250,400,30);
		income.setBackground(Color.WHITE);
		add(income);

		JLabel email = new JLabel("Educational: ");
		email.setBounds(100,300,600,30);
		email.setFont(new Font("Raleway",Font.BOLD,20));
		add(email);
		String valEducational[] ={"Non-Graduation", "Graduate", "Post-Graduate", "Doctrate", "Other"};
		educational = new JComboBox(valEducational);
		educational.setBounds(300,300,400,30);
		educational.setBackground(Color.WHITE);
		add(educational);
		JLabel q = new JLabel("Qualification");
		q.setBounds(100, 330, 600, 30);
		q.setFont(new Font("Raleway",Font.BOLD,20));
		add(q);
		
		JLabel marital = new JLabel("Occupation: ");
		marital.setBounds(100,380,600,30);
		marital.setFont(new Font("Raleway",Font.BOLD,20));
		add(marital);
		String valOccupation[] ={"Salaried", "Self-Employed", "Business", "Retired", "Other"};
		occupation = new JComboBox(valOccupation);
		occupation.setBounds(300,380,400,30);
		occupation.setBackground(Color.WHITE);
		add(occupation);
		
		JLabel city = new JLabel("PAN number: ");
		city.setBounds(100,450,600,30);
		city.setFont(new Font("Raleway",Font.BOLD,20));
		add(city);
		panTextField = new JTextField();
		panTextField.setFont(new Font("Raleway", Font.BOLD,20));
		panTextField.setBounds(300,450,400,30);
		add(panTextField);
		
		JLabel state = new JLabel("Aadhaar Number: ");
		state.setBounds(100,500,600,30);
		state.setFont(new Font("Raleway",Font.BOLD,20));
		add(state);
		aadharTextField = new JTextField();
		aadharTextField.setFont(new Font("Raleway", Font.BOLD,20));
		aadharTextField.setBounds(300,500,400,30);
		add(aadharTextField);
		
		JLabel pc = new JLabel("Senior Citizen: ");
		pc.setBounds(100,550,600,30);
		pc.setFont(new Font("Raleway",Font.BOLD,20));
		add(pc);
		syes = new JRadioButton("Yes");
		syes.setBounds(300,550,100,30);
		syes.setBackground(Color.WHITE);
		add(syes);
		sno = new JRadioButton("No");
		sno.setBounds(500,550,100,30);
		sno.setBackground(Color.WHITE);
		add(sno);
		ButtonGroup senior = new ButtonGroup();
		senior.add(sno);
		senior.add(syes);
		

		JLabel ea = new JLabel("Existing account: ");
		ea.setBounds(100,600,600,30);
		ea.setFont(new Font("Raleway",Font.BOLD,20));
		add(ea);
		eyes = new JRadioButton("Yes");
		eyes.setBounds(300,600,100,30);
		eyes.setBackground(Color.WHITE);
		add(eyes);
		eno = new JRadioButton("No");
		eno.setBounds(500,600,100,30);
		eno.setBackground(Color.WHITE);
		add(eno);
		ButtonGroup exac = new ButtonGroup();
		exac.add(eno);
		exac.add(eyes);
		
		
		
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
		String sreligion = (String) religion.getSelectedItem();
		String scategory = (String) category.getSelectedItem();
		String sincome = (String) income.getSelectedItem();
		String seducation = (String) educational.getSelectedItem();
		String soccupation = (String) occupation.getSelectedItem();
		String seniorcitizen = null;
		if(syes.isSelected())
		{
			seniorcitizen = "Yes";
		}
		else if(sno.isSelected())
		{
			seniorcitizen = "No";
		}
		String existingaccount = null;
		if(eyes.isSelected()){
			existingaccount = "Yes";
		}
		else if(eno.isSelected()) {
			existingaccount = "No";
		}
		String span = panTextField.getText();
		String saadhar = aadharTextField.getText();	
		
		try {
				Conn c = new Conn();
				String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorcitizen+"', '"+existingaccount+"')";
				c.s.execute(query);	
				setVisible(false);
				new Signupthree(formno).setVisible(true);
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Signuptwo("");
	}

}
