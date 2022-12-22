package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.testng.Assert;

import com.mysql.jdbc.Driver;

public class Task14122022 {

	public static void main(String[] args) throws Throwable {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_yantra","root","root");
		Statement stat = conn.createStatement();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee name");
		String name = sc.next();

		String selectQuery = "INSERT INTO Employee(ename) values('"+name+"')";

		try{
			stat.executeUpdate(selectQuery);
			System.out.println(name +" added to database");
		}
		catch(Exception e){
			System.out.println(name + " is already Present in the Database");
		}
		sc.close();
	}
}
