import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class Task1 {

	static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver"; 
	static final String JDBC_URL = "jdbc:mysql://localhost:3306";  // Database URL
	static final String User_Name ="root"; // Database username 
	static final String Password ="1234";  // database password
	static final String Database="EmployeesDetails"; // database name
	static final String Table="EmployeeData"; // table name 
	static final String TableColumn="(employeeId varchar(36) primary key,firstName varchar(20) not null,MiddleName varchar(20) not null,lastName varchar(20) not null,fullname varchar(60),emailId varchar(30) not null,education varchar(20) not null,mobileNumber varchar(12) not null,dateOfBirth varchar(12) not null,gender varchar(10) not null,address1 varchar(60) not null,address2 varchar(60) not null,pincode varchar(6) not null,City varchar(20) not null,State varchar(20) not null,jobDesignation varchar(20) not null,jobRole varchar(25) not null,joiningdDate varchar(30) default '01/03/2022 10:00:00 AM' ,Salary varchar(10) not null,PerAnnum varchar(12) not null)";
	static final String TableView="select * from "+Table;
	
	 
	public static void main(String[] args) throws ClassNotFoundException {
		
		
		Connection con;
		 try {
			 Class.forName(JDBC_DRIVER);
			 
			con = DriverManager.getConnection(JDBC_URL,User_Name,Password);
			
			Statement stmt=con.createStatement();
			
			// query for delete existing database 
			String s6="Drop database "+Database;
			stmt.executeUpdate(s6);
			
			// database create query
			String s1="create database "+Database;
			stmt.executeUpdate(s1);
			
			// table creation query with column
			String s2="create table "+Database+"."+Table+TableColumn;
			stmt.executeUpdate(s2);
			
			//must use this use database query for selecting database
			String s3="use "+Database;
			stmt.executeUpdate(s3);
			
			
			
			//insert data into the table 
			String s4="insert into "+Database+"."+Table+ " (employeeId,firstName,MiddleName,lastName,fullName,emailId,education,mobileNumber,dateofbirth,gender,address1,address2,pincode,City,State,jobDesignation,jobRole,Salary,PerAnnum) values(UUID(),'Dhileepan','Chinnaraj','C',concat(firstName,MiddleName,lastname),'dhileep2503@gmail.com','B.E','8682817160',Date_format(19950620,'%d.%m.%Y'),'Male','2/20 Muthumariyamman koil Street Ramayanpatti ','Katchaikatti(PO) T.Vadipatti(Tk) Madurai (DT)','625218','Madurai','Tamilnadu','Fresher','JAVA','30000',concat(salary*12/100000, if(salary*12>100000,'LPA','KPA'))),"
					+ "(UUID(),'Vinoth','Kumar','PG',concat(firstName,MiddleName,lastname),'vinoth@gmail.com','B.E','9598978574',Date_format(19920310,'%d.%m.%Y'),'Male','3/50 good street usilai ','usilai(PO) Usilampatti(Tk) Madurai (DT)','629545','Madurai','Tamilnadu','UI developer','React','30000',concat(salary*12/100000, if(salary*12>100000,'LPA','KPA'))),"
					+ "(UUID(),'Ragul','Dravit','R',concat(firstName,MiddleName,lastname),'ragul123@gmail.com','MCA','9578964578',Date_format(19930915,'%d.%m.%Y'),'Male','3/50 annanagar ','Nilakottai(PO) Nilakottai(Tk) Dindigul (DT)','624054','Dindigul','Tamilnadu','Senior developer','PHP','30000',concat(salary*12/100000, if(salary*12>100000,'LPA','KPA'))),"
					+ "(UUID(),'Stephy','Graph','R',concat(firstName,MiddleName,lastname),'stephy111@gmail.com','ME','7894561234',Date_format(19941202,'%d.%m.%Y'),'Female','4/25 gandhi nagar','samayanallur(PO) samayanallur(Tk) Madurai (DT)','625201','Madurai','Tamilnadu','senior developer','python','30000',concat(salary*12/100000, if(salary*12>100000,'LPA','KPA'))),"
					+ "(UUID(),'Karthick','Keyan','D',concat(firstName,MiddleName,lastname),'Karthick@gmail.com','MBA','8545789685',Date_format(19991005,'%d.%m.%Y'),'Male','4/20 kattapomman street','Taramani(PO) velachery(Tk) Chennai (DT)','600028','Chennai','Tamilnadu','junior developer','JAVA','30000',concat(salary*12/100000, if(salary*12>100000,'LPA','KPA')))";
			stmt.executeUpdate(s4);
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
