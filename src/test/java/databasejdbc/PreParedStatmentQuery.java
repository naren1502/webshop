package databasejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreParedStatmentQuery {

	public static void main(String[] args) throws SQLException {
		Connection myConn=null;
		PreparedStatement myStat=null;
		ResultSet myRes=null;
		
		String dbUrl="jdbc:mysql://localhost:3306/demo";
		String user="student";
		String password="Student@123%";
		
		try {
			
		//1.Get connection to database
			myConn=DriverManager.getConnection(dbUrl, user, password);
			System.out.println("Successfully connected to Database");
			
		//2.prepare statement
			myStat=myConn.prepareStatement("select * from employees where salary > ? and department=?");
		
		//3.Set the parameters
			myStat.setDouble(1, 40000);
			myStat.setString(2, "Legal");
		//4.Execute SQL query
			myRes=myStat.executeQuery();
		
		//5.process result
			while(myRes.next()) {
				System.out.println(myRes.getString("first_name")+", "+myRes.getString("last_name")+", "+myRes.getString("salary"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			if(myRes !=null) {
				myRes.close();
			}
		}

	}

}
