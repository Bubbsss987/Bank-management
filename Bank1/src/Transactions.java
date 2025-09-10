import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transactions extends JFrame implements ActionListener{
	JButton deposit, withdrawal, fastcash, ministatement, pinchange, balanceenquiry, exit;
	String pinnumber;
	Transactions(String pinnumber){
		this.pinnumber = pinnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm4.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,800);
		add(image);
		
		JLabel text = new JLabel("Please select your Transaction");
		text.setBounds(220,300,700,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway", Font.BOLD,15));
		image.add(text);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(170,380,150,30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawal = new JButton("Withdrawal");
		withdrawal.setBounds(350,380,150,30);
		withdrawal.addActionListener(this);
		image.add(withdrawal);
		
		fastcash = new JButton("Fast cash");
		fastcash.setBounds(170,420,150,30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		ministatement = new JButton("Mini statement");
		ministatement.setBounds(350,420,150,30);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		pinchange = new JButton("Pin change");
		pinchange.setBounds(170,460,150,30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceenquiry = new JButton("Balance Enquiry");
		balanceenquiry.setBounds(350,460,150,30);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);
		
		exit = new JButton("Exit");
		exit.setBounds(350,500,150,30);
		exit.addActionListener(this);
		image.add(exit);
		
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == exit) {
			System.exit(0);
		}else if(ae.getSource() == deposit) {
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
		}else if(ae.getSource() == withdrawal) {
			setVisible(false);
			new Withdrawal(pinnumber).setVisible(true);
		}else if(ae.getSource() == fastcash) {
			setVisible(false);
			new Fastcash(pinnumber).setVisible(true);
		}else if(ae.getSource() == pinchange) {
			setVisible(false);
			new Pinchange(pinnumber).setVisible(true);
		}else if(ae.getSource() == balanceenquiry) {
			setVisible(false);
			new Balanceenquiry(pinnumber).setVisible(true);
		}else if(ae.getSource() == ministatement) {
			new Ministatement(pinnumber).setVisible(true);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Transactions("");
	}

}
