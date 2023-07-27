package rahilshettyacademy.AbsttactComponent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class jdbConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://qsrdb.cdrcfhqq8rks.ap-south-1.rds.amazonaws.com:3306/yum_dev_process_db?user=root&password=Hacker12##";
		  //String username = "root";
		  //String password = "Hacker12##";
		
		String host="qsrdb.cdrcfhqq8rks.ap-south-1.rds.amazonaws.com";
		String port="3306";
		
		
		Connection con=DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/yum_dev_process_db" , "root", "Hacker12##");
		
                    Statement s=con.createStatement();
                 
                    ResultSet rs=s.executeQuery ("select customer_waiting_time FROM yum_dev_process_db.customer_tracking where store_id = 2 and customer_waiting_time is not null and customer_date = '2023-06-27';");
                 while(rs.next()) {
                	 String time=rs.getString("customer_waiting_time");
                	 
                	 String[] timeUnit = time.split(":");
         			 int totalSeconds = 60 * Integer.parseInt(timeUnit[0]) + Integer.parseInt(timeUnit[1]);
         			 if (totalSeconds>400) {
         				System.out.println("Total Wait time is in second  :"+ totalSeconds +"");
         			 }
                	 
                	                	 
                	 
                	 }
                    	
                 }
                   
                   
	}


