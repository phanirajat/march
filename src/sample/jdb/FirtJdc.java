package sample.jdb;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class FirtJdc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		Class.forName("com.mysql.jdbc.Driver");  
		java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school?characterEncoding=latin1&useConfigs=maxPerformance","amitha","qwerty123456");  
		//here sonoo is database name, root is username and password  
		java.sql.Statement stmt=con.createStatement(); 
		//"INSERT INTO `school`.`users_table` (`uname`, `password`) VALUES (,);"

		ResultSet rs=stmt.executeQuery("SELECT * FROM school.users_table");  
		while(rs.next())  
		System.out.println(rs.getString(1));  
		con.close();  
		  
	}

}
