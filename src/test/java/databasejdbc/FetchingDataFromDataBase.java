package databasejdbc;

import java.sql.*;


public class FetchingDataFromDataBase {

	public static void main(String[] args) {
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
			
		//3.Execute SQL query
			myRes=myStat.executeQuery("select * from employees");
			
		//4.Process the result set
			while(myRes.next()) {
				System.out.println(myRes.getString("last_name")+","+myRes.getString("first_name"));
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
