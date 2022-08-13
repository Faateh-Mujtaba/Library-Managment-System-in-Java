import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Database {
	static Connection contact;
	 Statement state;
	 ResultSet getData;
	 static
	 {try {
		 Class.forName("com.mysql.jdbc.Driver");
		   contact = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root","root");
		
	 }catch(Exception ex) {
		 
	 }
	 }

	 public void insertbook(JTextField t1,JTextField t2,JTextField t3,JTextField t4,JTextField t5,JTextField t6) {
		 
		 try
			{	
				state = contact.createStatement();
				
			 String val= "INSERT INTO author (author_id,author_name) VALUES ('"+t4.getText()+"','"+t5.getText()+"')";
			 state.executeUpdate(val);
			}catch(Exception ex) {
				
			}
		 try {
			 int quantity =Integer.parseInt(t6.getText());
			 String val= "INSERT INTO book (book_id,book_name,category,no_of_books,author_id) VALUES ('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+quantity+"','"+t4.getText()+"')";
			 state.executeUpdate(val);
			 JOptionPane.showMessageDialog(null,"<html>Successfully book has added");
			 
		 }catch(Exception ex) {
			 JOptionPane.showMessageDialog(null,"book_isbn ' "+t1.getText()+" ' is also dedicated to other book ");
			
		 }
		 
		
	 }
	 
public void insertStudent(JTextField t1,JTextField t2) {
		 
		 try
			{	
				state = contact.createStatement();
				
			 String val= "INSERT INTO student (student_id,name) VALUES ('"+t1.getText()+"','"+t2.getText()+"')";
			 state.executeUpdate(val);
			 
			 JOptionPane.showMessageDialog(null,"<html>Successfully student has added");
		 }catch(Exception ex) {
			 JOptionPane.showMessageDialog(null,"<html>student id ' "+t1.getText()+"' is also dedicated to other student ");
			}
	 }
public String[][] showbooks()
{
	
try
{
	
 
    state = contact.createStatement();
	getData = state.executeQuery("select * from book natural join author");
	int length=0;
	while(getData.next())
	{
		length++;
	}
		
	String record[][] = new String[length][6];
	getData = state.executeQuery("select * from book natural join author");
	int row=0;
	
	while(getData.next())
	{int column=0;
		record[row][column] = getData.getString(2);
		column++;
		record[row][column] = getData.getString(3);
		column++;			
		record[row][column] = getData.getString(4);
		column++;
		record[row][column] = getData.getString(5);
		column++;
		record[row][column] = getData.getString(1);
		column++;
		record[row][column] = getData.getString(6);
		column++;
		
		row++;
		
	}
	if(true)
	return record;
	//------------------------------------
	
}catch(Exception ex)
{
		
}


return new String[1][1];
}
	
public String[][] showstudent()
{
	
try
{
	
 
    state = contact.createStatement();
	getData = state.executeQuery("select * from student");
	int length=0;
	while(getData.next())
	{
		length++;
	}
		
	String record[][] = new String[length][2];
	getData = state.executeQuery("select * from student");
	int row=0;
	
	while(getData.next())
	{int column=0;
		record[row][column] = getData.getString(1);
		column++;
		record[row][column] = getData.getString(2);
					
		row++;
		
	}
	if(true)
	return record;
	//------------------------------------
	
}catch(Exception ex)
{
		
}


return new String[1][1];
}

public String[][] showbooks(JTextField t1)
{
	
try
{
	

    state = contact.createStatement();
	getData = state.executeQuery("select * from book natural join author where book_id = '"+t1.getText()+"'");
	int length=0;
	while(getData.next())
	{
		length++;
	}
		
	String record[][] = new String[length][6];
	getData = state.executeQuery("select * from book natural join author where book_id = '"+t1.getText()+"'");
	int row=0;
	
	while(getData.next())
	{int column=0;
		record[row][column] = getData.getString(2);
		column++;
		record[row][column] = getData.getString(3);
		column++;			
		record[row][column] = getData.getString(4);
		column++;
		record[row][column] = getData.getString(5);
		column++;
		record[row][column] = getData.getString(1);
		column++;
		record[row][column] = getData.getString(6);
		column++;
		
		row++;
		
	}
	if(true)
	return record;
	//------------------------------------
	
}catch(Exception ex)
{
		
}


return new String[1][1];
}
	
public String[][] showstudent(JTextField t1)
{
	
try
{
	
 
	 state = contact.createStatement();
		getData = state.executeQuery("select * from student where student_id = '"+t1.getText()+"'");
		int length=0;
		while(getData.next())
		{
			length++;
		}
			
		String record[][] = new String[length][2];
		getData = state.executeQuery("select * from student where student_id = '"+t1.getText()+"'");
		int row=0;
		
		while(getData.next())
		{int column=0;
			record[row][column] = getData.getString(1);
			column++;
			record[row][column] = getData.getString(2);
						
			row++;
			
		}	
	if(true)
	return record;
	//------------------------------------
	
}catch(Exception ex)
{
		
}


return new String[1][1];
}

public void issuebook(String s1,LocalDate date,LocalDate newDate,String s2) {
	 
	 try
		{	
			
		 state = contact.createStatement();
			

		 String val1= "INSERT INTO book_issue (student_id, issue_date , return_date ,book_id) VALUES ('"+s1+"','"+date+"','"+newDate+"','"+s2+"')";
		 state.executeUpdate(val1);
		 
		 
	 }catch(Exception ex) {
		 
		}
}


public void minusquantity(int quantity, String book_id) {
	 
	 try
		{	
			state = contact.createStatement();
			

		 String val= "Update book set no_of_books = '"+quantity+"' where book_id = '"+book_id+"' ";
		 state.executeUpdate(val);
		 
		 
	 }catch(Exception ex) {
		 
		}
}

public String[][] return_detail()
{
	
try
{
	

   state = contact.createStatement();
	getData = state.executeQuery("select issue_id,book_id,book_name,student_id,name,issue_date,return_date from book  natural join book_issue natural join student");
	int length=0;
	while(getData.next())
	{
		length++;
	}
		
	String record[][] = new String[length][7];
	getData = state.executeQuery("select issue_id,book_id,book_name,student_id,name,issue_date,return_date from book  natural join book_issue natural join student");
	int row=0;
	
	while(getData.next())
	{int column=0;
		record[row][column] = getData.getString(1);
		column++;
		record[row][column] = getData.getString(2);
		column++;			
		record[row][column] = getData.getString(3);
		column++;
		record[row][column] = getData.getString(4);
		column++;
		record[row][column] = getData.getString(5);
		column++;
		record[row][column] = getData.getString(6);
		column++;
		record[row][column] = getData.getString(7);
		column++;
		row++;
		
	}
	if(true)
	return record;
	//------------------------------------
	
}catch(Exception ex)
{
		
}


return new String[1][1];
}

public String[][] return_detail(JTextField t1)
{
	
try
{
	

   state = contact.createStatement();
	getData = state.executeQuery("select issue_id,book_id,book_name,student_id,name,issue_date,return_date from book  natural join book_issue natural join student where student_id = '"+t1.getText()+"'");
	int length=0;
	while(getData.next())
	{
		length++;
	}
		
	String record[][] = new String[length][7];
	getData = state.executeQuery("select issue_id,book_id,book_name,student_id,name,issue_date,return_date from book  natural join book_issue natural join student where student_id = '"+t1.getText()+"'");
	int row=0;
	
	while(getData.next())
	{int column=0;
		record[row][column] = getData.getString(1);
		column++;
		record[row][column] = getData.getString(2);
		column++;			
		record[row][column] = getData.getString(3);
		column++;
		record[row][column] = getData.getString(4);
		column++;
		record[row][column] = getData.getString(5);
		column++;
		record[row][column] = getData.getString(6);
		column++;
		record[row][column] = getData.getString(7);
		column++;
		row++;
		
	}
	if(true)
	return record;
	//------------------------------------
	
}catch(Exception ex)
{
		
}


return new String[1][1];
}

public void returned_book(String book_id,String issue_id) {
	 
	 try
		{	 
			state = contact.createStatement();
			getData = state.executeQuery("select no_of_books from book where book_id = '"+book_id+"' ");
            getData.next() ;
			int quantity = Integer.parseInt(getData.getString(1));
			String val= "Delete from book_issue where issue_id = '"+issue_id+"'";
			 state.executeUpdate(val);
			 quantity++;
		 String val1= "Update book set no_of_books = '"+quantity+"' where book_id = '"+book_id+"' ";
		 state.executeUpdate(val1);
		 
		 
	 }catch(Exception ex) {
		 ex.printStackTrace();
		}
}

public String[][] return_today(LocalDate Date)
{
	
try
{
	
 
    state = contact.createStatement();
	getData = state.executeQuery("select issue_id,book_id,book_name,student_id,name,issue_date,return_date from book  natural join book_issue natural join student where return_date = '"+Date+"'");
	int length=0;
	while(getData.next())
	{
		length++;
	}
		
	String record[][] = new String[length][7];
	getData = state.executeQuery("select issue_id,book_id,book_name,student_id,name,issue_date,return_date from book  natural join book_issue natural join student where return_date = '"+Date+"'");
	int row=0;
	
	while(getData.next())
	{int column=0;
		record[row][column] = getData.getString(1);
		column++;
		record[row][column] = getData.getString(2);
		column++;			
		record[row][column] = getData.getString(3);
		column++;
		record[row][column] = getData.getString(4);
		column++;
		record[row][column] = getData.getString(5);
		column++;
		record[row][column] = getData.getString(6);
		column++;
		record[row][column] = getData.getString(7);
		column++;
		row++;
		
	}
	if(true)
	return record;
	//------------------------------------
	
}catch(Exception ex)
{
		
}


return new String[1][1];
}

}