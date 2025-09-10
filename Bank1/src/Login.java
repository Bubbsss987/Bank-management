import java.awt.Image;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
	JTextField cardTextField;
	JButton login, signup, clear;
	JPasswordField pinTextField;
	Login(){
		setTitle("Automated teller Machine"); 
		setLayout(null);
		ImageIcon i1 = new ImageIcon("icons/atm3.png");
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(70,20, 100, 100);		
		add(label);
		
		JLabel text = new JLabel("Welcome to ATM");
		text.setBounds(200, 50, 400, 40);
		text.setFont(new Font("Osward",Font.BOLD,38));
		add(text); 
		
		JLabel card_no = new JLabel("Card No: ");
		card_no.setBounds(100, 150, 150, 40);
		card_no.setFont(new Font("Raleway",Font.BOLD,25));
		add(card_no); 
		cardTextField = new JTextField();
		cardTextField.setBounds(300, 150, 250, 40);
		add(cardTextField);
		
		JLabel pin = new JLabel("Pin: ");
		pin.setBounds(100, 225, 150, 40);
		pin.setFont(new Font("Raleway",Font.BOLD,25));
		add(pin); 
		pinTextField = new JPasswordField();
		pinTextField.setBounds(300, 225, 250, 40);
		add(pinTextField);
		
		login = new JButton("Sign In");
		login.setBounds(300, 300, 100, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("clear");
		clear.setBounds(450, 300, 100, 30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		signup = new JButton("Sign Up");
		signup.setBounds(300, 350, 250, 30);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);
		
		
		getContentPane().setBackground(Color.WHITE);
		setSize(800, 480);
		setVisible(true);
		setLocation(400,200);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==clear) {
			cardTextField.setText("");
			pinTextField.setText("");
			
		} else if(ae.getSource()==signup) {
			setVisible(false);
			new Signup().setVisible(true);
			
			
		} else if(ae.getSource()==login) {
			Conn conn = new Conn();
			String cardnumber = cardTextField.getText();
			String pinnumber = pinTextField.getText();
			String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
			try {
				ResultSet rs = conn.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect Card number or Pin");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login();
	}

}
