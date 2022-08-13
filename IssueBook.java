import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class IssueBook extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel bookid;
	private JTextField bookidtextField;
	private JButton search;
	private JTable table_1;
	private JScrollPane scrollPane_1;
	private JLabel searchstudent;
	private JTextField searchstudenttextField;
	private JButton searchstudentbtn;
	private JButton issuebookbtn;
	private JButton back;
	Database query =new Database();

	public IssueBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1190, 837);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel issuebook = new JLabel("Issuebook");
		issuebook.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		issuebook.setBackground(Color.WHITE);
		issuebook.setBounds(483, 10, 137, 43);
		contentPane.add(issuebook);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 120, 1156, 249);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			query.showbooks(),
			new String[] {
				"Book ID", "Book Name", "Category", "Quantity", "Author ID", "Author Name"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(101);
		table.getColumnModel().getColumn(0).setMinWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(166);
		table.getColumnModel().getColumn(1).setMinWidth(25);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setMinWidth(25);
		table.getColumnModel().getColumn(3).setPreferredWidth(47);
		table.getColumnModel().getColumn(3).setMinWidth(25);
		table.getColumnModel().getColumn(4).setPreferredWidth(108);
		table.getColumnModel().getColumn(4).setMinWidth(25);
		table.getColumnModel().getColumn(5).setPreferredWidth(160);
		table.getColumnModel().getColumn(5).setMinWidth(25);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		
		bookid = new JLabel("Book ID");
		bookid.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		bookid.setBounds(10, 70, 98, 35);
		contentPane.add(bookid);
		
		bookidtextField = new JTextField();
		bookidtextField.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		bookidtextField.setBounds(118, 70, 300, 35);
		contentPane.add(bookidtextField);
		bookidtextField.setColumns(10);
		
		search = new JButton("Search");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(bookidtextField.getText().equals(""))
				JOptionPane.showMessageDialog(null,"<html>Text FIeld is not fill");
			else {		
				table.setModel(new DefaultTableModel(
						query.showbooks(bookidtextField),
						new String[] {
							"Book ID", "Book Name", "Category", "Quantity", "Author ID", "Author Name"
						}
					));
			
			}
			
			}
		});
		search.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		search.setBounds(648, 70, 131, 43);
		contentPane.add(search);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 476, 665, 300);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			query.showstudent(),
			new String[] {
				"Student ID", "Student Name"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(92);
		table_1.getColumnModel().getColumn(0).setMinWidth(25);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(175);
		table_1.getColumnModel().getColumn(1).setMinWidth(25);
		table_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		searchstudent = new JLabel("Search Student");
		searchstudent.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		searchstudent.setBounds(10, 401, 137, 35);
		contentPane.add(searchstudent);
		
		searchstudenttextField = new JTextField();
		searchstudenttextField.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		searchstudenttextField.setBounds(148, 401, 289, 35);
		contentPane.add(searchstudenttextField);
		searchstudenttextField.setColumns(10);
		
		searchstudentbtn = new JButton("Search");
		searchstudentbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(searchstudenttextField.getText().equals(""))
					JOptionPane.showMessageDialog(null,"<html>Text FIeld is not fill");
				else {		
					table_1.setModel(new DefaultTableModel(
							query.showstudent(searchstudenttextField),
							new String[] {
								"Student ID", "Student Name"
							}
						));
				
				}
			}
		});
		searchstudentbtn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		searchstudentbtn.setBounds(483, 401, 137, 43);
		contentPane.add(searchstudentbtn);
		
		issuebookbtn = new JButton("Issue Book");
		issuebookbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
			String s_id;
			String book_id;
			int quantity;
			int row =table.getSelectedRow();
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			book_id = model.getValueAt(row, 0).toString();
			quantity =Integer.parseInt(model.getValueAt(row, 3).toString());
			quantity--;
			row =table_1.getSelectedRow();
			model = (DefaultTableModel)table_1.getModel();
			s_id = model.getValueAt(row, 0).toString();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			
			 LocalDate date = LocalDate.parse(dateFormat.format(cal.getTime()));
			 LocalDate newDate = date.plusMonths(1);
			query.issuebook(s_id, date, newDate, book_id);
			query.minusquantity(quantity, book_id);
			JOptionPane.showMessageDialog(null,"<html> BOOK has been issued");
			table.setModel(new DefaultTableModel(
					query.showbooks(),
					new String[] {
						"Book ID", "Book Name", "Category", "Quantity", "Author ID", "Author Name"
					}
				));
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null,"<html> Select the book in book table or student in student table");
			}
			}
		});
		issuebookbtn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		issuebookbtn.setBounds(786, 612, 209, 95);
		contentPane.add(issuebookbtn);
		
		back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new Features();
				setVisible(false);
			}
		});
		back.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		back.setBounds(971, 27, 137, 72);
		contentPane.add(back);
		setVisible(true);
	}

}
