import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Addstudent extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;


	public Addstudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 361);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel addstudent = new JLabel("ADD STUDENT");
		addstudent.setFont(new Font("Times New Roman", Font.BOLD, 30));
		addstudent.setBounds(113, 10, 228, 39);
		contentPane.add(addstudent);
		
		JLabel studentid = new JLabel("Student ID");
		studentid.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		studentid.setBounds(10, 79, 109, 30);
		contentPane.add(studentid);
		
		JLabel studentname = new JLabel("Student Name");
		studentname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		studentname.setBounds(10, 150, 121, 30);
		contentPane.add(studentname);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField.setBounds(141, 79, 245, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_1.setBounds(141, 150, 250, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton addstudentbtn = new JButton("Add Student");
		addstudentbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(textField.getText().equals("")||textField_1.getText().equals(""))
				 JOptionPane.showMessageDialog(null,"<html>Fill all text Fields");
			else
			{Database query=new Database();
			query.insertStudent(textField,textField_1);
				
			}
			setVisible(false);
			}
		});
		addstudentbtn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		addstudentbtn.setBackground(Color.CYAN);
		addstudentbtn.setBounds(179, 225, 141, 55);
		contentPane.add(addstudentbtn);
	setVisible(true);
	}
}
