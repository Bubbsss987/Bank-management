import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Pinchange extends JFrame implements ActionListener{
	JPasswordField pin,Repin;
	JButton change, back;
	String pinnumber;
	Pinchange(String pinnumber){
		this.pinnumber = pinnumber;
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm4.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,800);
		add(image);
		
		JLabel text = new JLabel("Change your PIN");
		text.setBounds(260,300,700,25);
		text.setFont(new Font("Raleway", Font.BOLD,15));
		text.setForeground(Color.WHITE);
		image.add(text);
		
		JLabel pintext = new JLabel("New PIN: ");
		pintext.setBounds(165,350,200,25);
		pintext.setFont(new Font("Raleway", Font.BOLD,15));
		pintext.setForeground(Color.WHITE);
		image.add(pintext);
		
		pin = new JPasswordField();
		pin.setBounds(300,350,200,25);
		pin.setFont(new Font("Raleway", Font.BOLD,15));
		image.add(pin);
		
		JLabel Repintext = new JLabel("Re-enter PIN: ");
		Repintext.setBounds(165,400,200,25);
		Repintext.setFont(new Font("Raleway", Font.BOLD,15));
		Repintext.setForeground(Color.WHITE);
		image.add(Repintext);
		
		Repin = new JPasswordField();
		Repin.setBounds(300,400,200,25);
		Repin.setFont(new Font("Raleway", Font.BOLD,15));
		image.add(Repin);
		
		change = new JButton("Change");
		change.setBounds(165,470,150,30);
		change.addActionListener(this);
		image.add(change);
		
		back = new JButton("Back");
		back.setBounds(365,470,150,30);
		back.addActionListener(this);
		image.add(back);
		
		
		setSize(900,900);
		setLocation(350,0);
		setUndecorated(true);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==change) {
			try {
				String npin = pin.getText();
				String rpin = Repin.getText();
				if(ae.getSource()==change) {
					
				}
				
				if(!npin.equals(rpin)) {
					JOptionPane.showMessageDialog(null, "Entered PIN does not match");
					return;
				}else if(npin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter your PIN");
					return;
				}else if(rpin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please re-enter your PIN");
					return;
				}
				Conn conn = new Conn();
				String query1 = "update bank set pin = '"+rpin+"' where pin='"+pinnumber+"'";
				String query2 = "update login set pin = '"+rpin+"' where pin='"+pinnumber+"'";
				String query3 = "update signupthree set pinnumber = '"+rpin+"' where pinnumber='"+pinnumber+"'";
				conn.s.executeUpdate(query1);
				conn.s.executeUpdate(query2);
				conn.s.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null, "You PIN has been successfully changed");
				setVisible(false);
				new Transactions(rpin).setVisible(true);
				
			}catch(Exception e) {
				System.out.println(e);
			}
		}else {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Pinchange("").setVisible(true);
	}

}
