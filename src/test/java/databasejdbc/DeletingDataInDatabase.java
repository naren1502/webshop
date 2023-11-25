package databasejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeletingDataInDatabase {

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
			
		//3.call the helper method to display the employees information
			System.out.println("Before The Delete...");
			displayEmployee(myConn,"John","Doe");
			
		//4.delete the employees
			int rowAffected=myStat.executeUpdate("delete from employees "
		+"where last_name='Doe' and first_name='John'");
		
		//5.call the helper method to displaye the employees information
			System.out.println("After The Delete... and No of Rows affected:"+rowAffected);
			displayEmployee(myConn,"John","Doe");
			
			
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

	private static void displayEmployee(Connection myConn, String firstname, String lastname) {
		
		try {
			Statement myStat = myConn.createStatement();
			ResultSet myRes = myStat.executeQuery("select * from employees where first_name='"+firstname+"' and last_name='"+lastname+"'");
			while(myRes.next()) {
				System.out.println(firstname+","+lastname+","+myRes.getString("email"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
