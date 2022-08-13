import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Listall extends JFrame {

	private JPanel contentPane;
	private JTable listallbooktable;
Database query =new Database();
		




public Listall() {
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 821);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel listallbooks = new JLabel("List All Books");
		listallbooks.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		listallbooks.setBounds(337, 10, 188, 59);
		contentPane.add(listallbooks);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		scrollPane.setBounds(10, 149, 869, 625);
		contentPane.add(scrollPane);
		
		listallbooktable = new JTable();
		scrollPane.setViewportView(listallbooktable);
		listallbooktable.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		listallbooktable.setModel(new DefaultTableModel(
			query.showbooks(),
			new String[] {
				"Book ID", "Book Name", "Category", "Quantity", "Author ID", "Author Name"
			}
		));
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new Features();
			setVisible(false);
			}
		});
		back.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		back.setBounds(581, 77, 164, 62);
		contentPane.add(back);
		listallbooktable.getColumnModel().getColumn(0).setPreferredWidth(100);
		listallbooktable.getColumnModel().getColumn(0).setMinWidth(25);
		listallbooktable.getColumnModel().getColumn(1).setPreferredWidth(170);
		listallbooktable.getColumnModel().getColumn(1).setMinWidth(25);
		listallbooktable.getColumnModel().getColumn(2).setPreferredWidth(130);
		listallbooktable.getColumnModel().getColumn(2).setMinWidth(25);
		listallbooktable.getColumnModel().getColumn(3).setPreferredWidth(48);
		listallbooktable.getColumnModel().getColumn(3).setMinWidth(25);
		listallbooktable.getColumnModel().getColumn(4).setPreferredWidth(80);
		listallbooktable.getColumnModel().getColumn(4).setMinWidth(25);
		listallbooktable.getColumnModel().getColumn(5).setPreferredWidth(105);
		listallbooktable.getColumnModel().getColumn(5).setMinWidth(25);
	setVisible(true);
	}
}
