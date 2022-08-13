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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class ReturnToday extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Database query =new Database();
		
	
	
	
		public ReturnToday() {
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1357, 832);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel returntodaylabel = new JLabel("Book To Be Return Today");
		returntodaylabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		returntodaylabel.setBounds(410, 10, 404, 54);
		contentPane.add(returntodaylabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 165, 1323, 532);
		contentPane.add(scrollPane);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		
		 LocalDate date = LocalDate.parse(dateFormat.format(cal.getTime()));
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			
			query.return_today(date),
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
