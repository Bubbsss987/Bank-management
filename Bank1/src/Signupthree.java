import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class Signupthree extends JFrame implements ActionListener{
	JRadioButton current, fixed, saving, recurring;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton cancel, submit;
	String formno;
	Signupthree(String formno){
		this.formno = formno;
		setLayout(null);
		
		JLabel l1 = new JLabel("Page 3: Account Details");
		l1.setFont(new Font("Raleway", Font.BOLD,25));
		l1.setBounds(280,40,400,30);
		add(l1);
		
		JLabel type = new JLabel("Account Type: ");
		type.setFont(new Font("Raleway", Font.BOLD,22));
		type.setBounds(70,150,600,30);
		add(type);
		
		saving = new JRadioButton("Saving Account");
		saving.setBounds(80,180,200,30);
		saving.setBackground(Color.WHITE);
		add(saving);
		
		fixed = new JRadioButton("Fixed Deposit Account");
		fixed.setBounds(280,180,200,30);
		fixed.setBackground(Color.WHITE);
		add(fixed);
		
		current = new JRadioButton("Current Account");
		current.setBounds(80,210,200,30);
		current.setBackground(Color.WHITE);
		add(current);
		
		recurring = new JRadioButton("Recurring Deposit Account");
		recurring.setBounds(280,210,200,30);
		recurring.setBackground(Color.WHITE);
		add(recurring);
		
		ButtonGroup Acctype = new ButtonGroup();
		Acctype.add(recurring);
		Acctype.add(current);
		Acctype.add(fixed);
		Acctype.add(saving);
		
		JLabel card = new JLabel("Card Number: ");
		card.setFont(new Font("Raleway", Font.BOLD,22));
		card.setBounds(70,250,600,30);
		add(card);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-4184 ");
		number.setFont(new Font("Raleway", Font.BOLD,22));
		number.setBounds(270,250,400,30);
		add(number);
		
		JLabel carddetails = new JLabel("You 16 digit card number ");
		carddetails.setFont(new Font("Raleway", Font.BOLD, 12));
		carddetails.setBounds(70,270,400,30);
		add(carddetails);
		
		JLabel pin = new JLabel("PIN: ");
		pin.setFont(new Font("Raleway", Font.BOLD,22));
		pin.setBounds(70,300,600,30);
		add(pin);
		
		JLabel p_number = new JLabel("XXXX");
		p_number.setFont(new Font("Raleway", Font.BOLD,22));
		p_number.setBounds(270,300,400,30);
		add(p_number);
		
		JLabel pindetails = new JLabel("You 4 digit pin ");
		pindetails.setFont(new Font("Raleway", Font.BOLD, 12));
		pindetails.setBounds(70,320,400,30);
		add(pindetails);
		
		JLabel services = new JLabel("Services Required: ");
		services.setFont(new Font("Raleway", Font.BOLD, 22));
		services.setBounds(70,370,400,30);
		add(services);
		
		c1 = new JCheckBox("ATM CARD");
		c1.setBounds(70,410,200,30);
		c1.setFont(new Font("Raleway", Font.BOLD, 16));
		c1.setBackground(Color.WHITE);
		add(c1);
		
		c2 = new JCheckBox("INTERNET BANKING");
		c2.setBounds(370,410,200,30);
		c2.setFont(new Font("Raleway", Font.BOLD, 16));
		c2.setBackground(Color.WHITE);
		add(c2);
		
		c3 = new JCheckBox("MOBILE BANKING");
		c3.setBounds(70,440,200,30);
		c3.setFont(new Font("Raleway", Font.BOLD, 16));
		c3.setBackground(Color.WHITE);
		add(c3);
		
		c4 = new JCheckBox("EMIAL & SMS alert");
		c4.setBounds(370,440,200,30);
		c4.setFont(new Font("Raleway", Font.BOLD, 16));
		c4.setBackground(Color.WHITE);
		add(c4);
		
		c5 = new JCheckBox("CHEQUE BOOK");
		c5.setBounds(70,470,200,30);
		c5.setFont(new Font("Raleway", Font.BOLD, 16));
		c5.setBackground(Color.WHITE);
		add(c5);
		
		c6 = new JCheckBox("E-Statement");
		c6.setBounds(370,470,200,30);
		c6.setFont(new Font("Raleway", Font.BOLD, 16));
		c6.setBackground(Color.WHITE);
		add(c6);
		
		c7 = new JCheckBox("I hereby declare declare that the above entered details are correct to the best of my knowledge");
		c7.setBounds(70,500,1000,30);
		c7.setFont(new Font("Raleway", Font.BOLD, 16));
		c7.setBackground(Color.WHITE);
		add(c7);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(300, 600, 100, 30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		add(cancel);
		
		submit = new JButton("Submit");
		submit.setBounds(450, 600, 100, 30);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		add(submit);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850,820);
		setLocation(350,0);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == submit)
		{
			String accountType=null;
			if(saving.isSelected()) {
				accountType = "Saving";
			} else if(fixed.isSelected()) {
				accountType = "Fixed Deposit Account";
			} else if(current.isSelected()) {
				accountType = "Current Account";
			} else if(recurring.isSelected()) {
				accountType = "Recurring Deposit Account";
			} 
			
			Random random = new Random();
			String cardnumber = ""+Math.abs((random.nextLong() % 9000000L)+50409360000000000L);
			String pinnumber = ""+Math.abs((random.nextLong()%9000L)+1000L);
			String facility = "";
			if(c1.isSelected()) {
				facility = facility + "ATM CARD";
			} else if(c2.isSelected()) {
				facility = facility + "INTERNET BANKING";
			} else if (c3.isSelected()) {
				facility =  facility + "MOBILE BANKING";
			} else if (c4.isSelected()) {
				facility =  facility + "EMAIL & SMS alert";
			} else if (c5.isSelected()) {
				facility =  facility + "CHEQUE BOOK";
			} else if (c6.isSelected()) {
				facility =  facility + "E-Statement";
			}
			
			try {
				if (accountType.equals("")) {
					JOptionPane.showMessageDialog(null, "Account Type is required");
				} else {
					Conn conn = new Conn();
					String query1 = "insert into signupthree values('"+formno+"', '"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
					String query2 = "insert into login values('"+formno+"', '"+cardnumber+"','"+pinnumber+"')";
					conn.s.executeUpdate(query1);
					conn.s.executeUpdate(query2);
					JOptionPane.showMessageDialog(null, "Card Number: "+cardnumber+"\n Pin numner: "+pinnumber);
					setVisible(false);
					new Deposit(pinnumber).setVisible(false);
				
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			
		} else if (ae.getSource() == cancel) {
			setVisible(false);
			new Login().setVisible(true);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Signupthree("");
	}

}
