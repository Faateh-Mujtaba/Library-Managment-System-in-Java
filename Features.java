import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Features extends JFrame {

	private JPanel contentPane;

		public Features() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 577);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton addbook = new JButton("Add Book");
		addbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new Add_Book();
			setVisible(false);
			}
		});
		addbook.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		addbook.setForeground(new Color(0, 0, 0));
		addbook.setBackground(Color.CYAN);
		addbook.setBounds(10, 33, 164, 69);
		contentPane.add(addbook);
		
		JButton addstudent = new JButton("Add Student");
		addstudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			new Addstudent();
			
			
			}
		});
		addstudent.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		addstudent.setBackground(Color.CYAN);
		addstudent.setBounds(258, 34, 164, 69);
		contentPane.add(addstudent);
		
		JButton listallbooks = new JButton("List All Books");
		listallbooks.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		listallbooks.setBackground(Color.CYAN);
		listallbooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new Listall();
				setVisible(false);
			}
		});
		listallbooks.setBounds(504, 34, 193, 69);
		contentPane.add(listallbooks);
		
		JButton issuebook = new JButton("Issue Book");
		issuebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new IssueBook();
			setVisible(false);
			
			}
		});
		issuebook.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		issuebook.setBackground(Color.CYAN);
		issuebook.setBounds(10, 164, 164, 69);
		contentPane.add(issuebook);
		
		JButton listissuedbooks = new JButton("List Issued Books");
		listissuedbooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new ReturnBook();
			setVisible(false);
			
			}
		});
		listissuedbooks.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		listissuedbooks.setBackground(Color.CYAN);
		listissuedbooks.setBounds(258, 166, 164, 69);
		contentPane.add(listissuedbooks);
		
		JButton returnbook = new JButton("Book to be return today");
		returnbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new ReturnToday();
			setVisible(false);
			}
		});
		returnbook.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		returnbook.setBackground(Color.CYAN);
		returnbook.setBounds(504, 164, 193, 69);
		contentPane.add(returnbook);
		
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new Login();
			setVisible(false);
			}
		});
		logout.setBackground(Color.CYAN);
		logout.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 27));
		logout.setBounds(258, 338, 181, 98);
		contentPane.add(logout);
		setVisible(true);
	}

}
