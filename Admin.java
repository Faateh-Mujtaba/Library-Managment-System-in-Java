import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Admin {
	 Connection contact;
	 Statement state;
	 ResultSet getData;

			
	public boolean logging(JTextField t1,JPasswordField t2)
	{boolean a=false;
	try
	
	{	Class.forName("com.mysql.jdbc.Driver");
	    contact = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root","root");
	
		state = contact.createStatement();
		getData = state.executeQuery("select admin_id,Password from admin");
		while(getData.next())
		{
			if(t1.getText().equals(getData.getString(1))&&t2.getText().equals(getData.getString(2)))
				{a= true;
				break;
		}
			
}
		
}
	catch(Exception ex) {
	
	}
	return a;
	}
	
}
	