package databasejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertingDataToDatabase {

	public static void main(String[] args) throws SQLException {
		Connection myConn=null;
		Statement myStat=null;
		ResultSet myRes=null;
		
		String dbUrl="jdbc:mysql://localhost:3306/demo";
		String user="student";
		String password="Student@123%";
		
		try {
			
		//1.Get connection to database
			myConn=DriverManager.getConnection(dbUrl, user, password);
			System.out.println("Successfully connected to Database");
			
		//2.Create a statement
			myStat=myConn.createStatement();
			
		//3.Execute SQL query for insert
			int rowAffected=myStat.executeUpdate("insert into employees "+"(last_name,first_name,email,department,salary) "+"values "+"('Hello','Hendry','hendry@gmail.com','QA',35000)");
			System.out.println("No of rows affected:"+rowAffected);
		//4.verification this by getting a list of employess
		myRes=myStat.executeQuery("select * from employees where last_name='Hello';");
		
		//5.process result
		while(myRes.next()) {
			System.out.println(myRes.getString("first_name"));
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
