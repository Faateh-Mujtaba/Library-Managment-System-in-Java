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

public class Add_Book extends JFrame {

	private JPanel contentPane;
	private JTextField bookIDtextfeild;
	private JTextField bookNametextfeild;
	private JTextField categorytextfeild;
	private JTextField authoridtextfeild;
	private JTextField authornametextfeild;
	private JTextField quantitytextfeild;
	public Add_Book() {
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 580);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel addbook = new JLabel("Add Book");
		addbook.setFont(new Font("Times New Roman", Font.BOLD, 30));
		addbook.setBackground(Color.GRAY);
		addbook.setBounds(295, 23, 175, 46);
		contentPane.add(addbook);
		
		JLabel bookID = new JLabel("Book ID");
		bookID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		bookID.setBounds(10, 91, 117, 36);
		contentPane.add(bookID);
		
		JLabel bookname = new JLabel("Book Name");
		bookname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		bookname.setBounds(10, 152, 125, 36);
		contentPane.add(bookname);
		
		JLabel category = new JLabel("Category");
		category.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		category.setBounds(10, 208, 125, 36);
		contentPane.add(category);
		
		JLabel authorID = new JLabel("Author ID");
		authorID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		authorID.setBounds(10, 273, 117, 36);
		contentPane.add(authorID);
		
		JLabel authorname = new JLabel("Author Name");
		authorname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		authorname.setBounds(10, 338, 117, 36);
		contentPane.add(authorname);
		
		JLabel quantity = new JLabel("Quantity");
		quantity.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		quantity.setBounds(10, 405, 86, 36);
		contentPane.add(quantity);
		
		bookIDtextfeild = new JTextField();
		bookIDtextfeild.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		bookIDtextfeild.setBounds(144, 91, 405, 36);
		contentPane.add(bookIDtextfeild);
		bookIDtextfeild.setColumns(10);
		
		bookNametextfeild = new JTextField();
		bookNametextfeild.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		bookNametextfeild.setColumns(10);
		bookNametextfeild.setBounds(144, 155, 405, 36);
		contentPane.add(bookNametextfeild);
		
		categorytextfeild = new JTextField();
		categorytextfeild.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		categorytextfeild.setColumns(10);
		categorytextfeild.setBounds(144, 208, 405, 36);
		contentPane.add(categorytextfeild);
		
		authoridtextfeild = new JTextField();
		authoridtextfeild.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		authoridtextfeild.setColumns(10);
		authoridtextfeild.setBounds(144, 273, 405, 36);
		contentPane.add(authoridtextfeild);
		
		authornametextfeild = new JTextField();
		authornametextfeild.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		authornametextfeild.setColumns(10);
		authornametextfeild.setBounds(144, 338, 405, 36);
		contentPane.add(authornametextfeild);
		
		quantitytextfeild = new JTextField();
		quantitytextfeild.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		quantitytextfeild.setColumns(10);
		quantitytextfeild.setBounds(144, 405, 405, 36);
		contentPane.add(quantitytextfeild);
		
		JButton addbutton = new JButton("ADD");
		addbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		if(bookIDtextfeild.getText().equals("")||bookNametextfeild.getText().equals("")||categorytextfeild.getText().equals("")||authoridtextfeild.getText().equals("")||authornametextfeild.getText().equals("")||quantitytextfeild.getText().equals(""))	
			JOptionPane.showMessageDialog(null,"<html>Fill all text fields");
		else
		{Database query =new Database();
		query.insertbook( bookIDtextfeild , bookNametextfeild,categorytextfeild,authoridtextfeild,authornametextfeild, quantitytextfeild );
		bookIDtextfeild.setText("");
		bookNametextfeild.setText("");
		categorytextfeild.setText("");
		authoridtextfeild.setText("");
		authornametextfeild.setText("");
		quantitytextfeild.setText("");
		
		
		}
			}
		});
		addbutton.setBackground(Color.LIGHT_GRAY);
		addbutton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		addbutton.setBounds(295, 473, 161, 46);
		contentPane.add(addbutton);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new Features();
				setVisible(false);
			}
		});
		back.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		back.setBounds(616, 23, 169, 63);
		contentPane.add(back);
	setVisible(true);
	}
}
