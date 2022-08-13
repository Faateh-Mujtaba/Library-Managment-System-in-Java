import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
public class Login extends JFrame {
	private JTextField Admin_textField;
	private JPasswordField passwordField;

	

		public Login() {
		
		getContentPane().setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 570);
		
		setTitle("BOOK HUB");
		getContentPane().setLayout(null);
		
		JLabel welcom_label = new JLabel("Welcom To BOOK HUB");
		welcom_label.setFont(new Font("Times New Roman", Font.BOLD, 40));
		welcom_label.setBounds(175, 25, 436, 79);
		getContentPane().add(welcom_label);
		
		JLabel adminID_label = new JLabel("Admin ID : ");
		adminID_label.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		adminID_label.setBounds(78, 152, 123, 39);
		getContentPane().add(adminID_label);
		
		Admin_textField = new JTextField();
		Admin_textField.setBounds(254, 152, 307, 39);
		getContentPane().add(Admin_textField);
		Admin_textField.setColumns(10);
		
		JLabel password_label = new JLabel("Password : ");
		password_label.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		password_label.setBounds(78, 244, 123, 39);
		getContentPane().add(password_label);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		passwordField.setBounds(254, 234, 307, 39);
		getContentPane().add(passwordField);
		
		JButton login = new JButton("Login");
		login.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Admin log =new Admin();
			if(log.logging(Admin_textField, passwordField))
				{new Features();
				setVisible(false);
				}
			else
				JOptionPane.showMessageDialog(null, "<html>Admin ID or Password is Incorrect");
			
			}
		});
		login.setBounds(332, 347, 181, 56);
		getContentPane().add(login);
		setVisible(true);
		}
}
