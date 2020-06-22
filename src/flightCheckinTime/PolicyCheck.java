package flightCheckinTime;

import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PolicyCheck {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/InsurancePolicy?useUnicode=true&useJDBCCompliantTimeZoneShift=true&useLeagcyDateTimeCode=false&serverTimezone=UTC","root", "macbookair");
			
			Statement stat = con.createStatement();
			
			DataInputStream dstream = new DataInputStream(System.in);
			
			System.out.println("Enter the policy number");
			String policyNumber1 = dstream.readLine();
			
			String query = "Select * from policy where policyNumber=`"+policyNumber1+"`";
			
			ResultSet rs= stat.executeQuery(query);
			
			if(rs.next()) {
				System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4));
			}
			else {
				System.out.println("Record not found");
				
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
