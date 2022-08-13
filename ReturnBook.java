import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReturnBook extends JFrame {

	private JPanel contentPane;
	private JTextField studentidtextField;
	private JTable table;
	Database query =new Database();
		
	
	
	
		public ReturnBook() {
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1357, 832);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel returnbooklabel = new JLabel("Return Book");
		returnbooklabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		returnbooklabel.setBounds(522, 10, 209, 54);
		contentPane.add(returnbooklabel);
		
		JLabel studentidlabel = new JLabel("Student ID");
		studentidlabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		studentidlabel.setBounds(10, 80, 115, 43);
		contentPane.add(studentidlabel);
		
		studentidtextField = new JTextField();
		studentidtextField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		studentidtextField.setBounds(148, 80, 241, 43);
		contentPane.add(studentidtextField);
		studentidtextField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(btnNewButton.getText().equals(""))
				JOptionPane.showMessageDialog(null,"<html>Text FIeld is not fill");
			else {
				table.setModel(new DefaultTableModel(
						query.return_detail(studentidtextField),
						new String[] {
							"Issue ID", "Book ID", "Book Name", "Student ID", "Student Name", "Issue Date", "Return Date"
						}
					));
			}
			
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		btnNewButton.setBounds(447, 74, 159, 54);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 165, 1323, 532);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			query.return_detail(),
			new String[] {
				"Issue ID", "Book ID", "Book Name", "Student ID", "Student Name", "Issue Date", "Return Date"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(0).setMinWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setMinWidth(25);
		table.getColumnModel().getColumn(2).setPreferredWidth(160);
		table.getColumnModel().getColumn(2).setMinWidth(25);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setMinWidth(25);
		table.getColumnModel().getColumn(4).setPreferredWidth(165);
		table.getColumnModel().getColumn(4).setMinWidth(25);
		table.getColumnModel().getColumn(5).setPreferredWidth(90);
		table.getColumnModel().getColumn(5).setMinWidth(25);
		table.getColumnModel().getColumn(6).setPreferredWidth(90);
		table.getColumnModel().getColumn(6).setMinWidth(25);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		table.setBackground(Color.WHITE);
		
		JButton returnbtn = new JButton("Return");
		returnbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				int row =table.getSelectedRow();
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			String issue_id = model.getValueAt(row, 0).toString();
			String book_id = model.getValueAt(row, 1).toString();
			query.returned_book(book_id, issue_id);
			table.setModel(new DefaultTableModel(
					query.return_detail(),
					new String[] {
						"Issue ID", "Book ID", "Book Name", "Student ID", "Student Name", "Issue Date", "Return Date"
					}
				));
			
			}catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"<html> Select the table row");
			}		}
		});
		returnbtn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		returnbtn.setBounds(547, 718, 166, 67);
		contentPane.add(returnbtn);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new Features();
			setVisible(false);
			}
		});
		back.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		back.setBounds(1056, 80, 124, 67);
		contentPane.add(back);
		setVisible(true);
	}

}
