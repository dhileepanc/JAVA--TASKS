import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Random;
import java.util.UUID;
import com.mysql.cj.result.Row;

public class task1 {

	static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver"; 
	static final String JDBC_URL = "jdbc:mysql://localhost:3306";  // Database URL
	static final String User_Name ="root"; // Database username 
	static final String Password ="1234";  // database password
	

	public static void main(String[] args) throws SQLException, FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException {
		
		 
		 try {
			 Connection con;
			 
			Class.forName(JDBC_DRIVER);
			
			
			
			con = DriverManager.getConnection(JDBC_URL,User_Name,Password);
			
			Statement stmt=con.createStatement();
			stmt.executeUpdate("drop database employee1");
			stmt.executeUpdate("create database employee1");
			stmt.executeUpdate("use employee1");
			
			
			
			
			
	
			
			stmt.executeUpdate("create table employeedata(employeeId varchar(36) primary key,firstName varchar(20) not null,MiddleName varchar(20) not null,lastName varchar(20) not null,fullname varchar(60),emailId varchar(30) not null,education varchar(20) not null,mobileNumber varchar(12) not null,dateOfBirth varchar(12) not null,gender varchar(10) not null,address1 varchar(60) not null,address2 varchar(60) not null,pincode varchar(6) not null,City varchar(20) not null,State varchar(20) not null,jobDesignation varchar(20) not null,jobRole varchar(25) not null,joiningDate varchar(30) default '01/03/2022 10:00:00 AM' ,Salary varchar(10) not null,PerAnnum varchar(12) not null)");
//			stmt.executeUpdate("insert into employeedata(employeeId,firstName,MiddleName,lastName,fullName,emailId,education,mobileNumber,dateofbirth,gender,address1,address2,pincode,City,State,jobDesignation,jobRole,joiningDate,Salary,PerAnnum) values (UUID(),f_Name,m_Name,l_Name,concat(firstName,MiddleName,lastname),email_Id,edu_cation,mob_num,d_o_b,genders,address_1,address_2,pin_code,city_Name,state_Name,job_Designation,job_Role,joining_Date,Salary_,Per_Annum)");
		
			PreparedStatement ps=con.prepareStatement("insert into employeedata(employeeId,firstName,MiddleName,lastName,fullName,emailId,education,mobileNumber,dateofbirth,gender,address1,address2,pincode,City,State,jobDesignation,jobRole,Salary,PerAnnum) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  

			while(true) {
				Scanner sc=new Scanner(System.in);
				System.out.println("Please enter your First Name :");
				String f_Name=sc.nextLine();
			
				System.out.println("Please enter your Middle Name :");
				String m_Name=sc.nextLine();
				
				System.out.println("Please enter your Last Name :");
				String l_Name=sc.nextLine();
				
				String full_Name=f_Name+m_Name+l_Name;
				
				System.out.println("Please enter your Email Id :");
				String email_Id=sc.nextLine();
				
				System.out.println("Please enter your Educational qualification :");
				String edu_cation=sc.nextLine();

				System.out.println("Please enter your Mobile Number :");
				String mob_num=sc.nextLine();

				System.out.println("Please enter your DateOfBirth as ddmmyyy :");
				String d_o_b=sc.nextLine();

				System.out.println("Please enter your Gender :");
				String genders=sc.nextLine();

				System.out.println("Please enter your Address1 :");
				String address_1=sc.nextLine();

				System.out.println("Please enter your Address2 :");
				String address_2=sc.nextLine();
				
				System.out.println("Please enter your Area Pincode :");
				String pin_code=sc.nextLine();
				
				System.out.println("Please enter your City Name :");
				String city_Name=sc.nextLine();
				
				System.out.println("Please enter your State_Name :");
				String state_Name=sc.nextLine();
				
				System.out.println("Please enter your Job_Designation :");
				String job_Designation=sc.nextLine();
				
				System.out.println("Please enter your Job Role :");
				String job_Role=sc.nextLine();
				
				System.out.println("Please enter your Salary :");
				int Salary_=sc.nextInt();
				
				int Per_Annum=(Salary_*12);
				
				UUID id = UUID.randomUUID();
				String empID=id.toString();
				
			
			ps.setNString(1,empID);
			ps.setString(2,f_Name);
			ps.setString(3,m_Name);
			ps.setString(4,l_Name);
			ps.setString(5,full_Name);
			ps.setString(6,email_Id);
			ps.setString(7,edu_cation);
			ps.setString(8,mob_num);
			ps.setString(9,d_o_b);
			ps.setString(10,genders);
			ps.setString(11,address_1);
			ps.setString(12,address_2);
			ps.setString(13,pin_code);
			ps.setString(14,city_Name);
			ps.setString(15,state_Name);
			ps.setString(16,job_Designation);
			ps.setString(17,job_Role);
			ps.setInt(18, Salary_);
			ps.setLong(19,Per_Annum);
						
			ps.executeUpdate();
			
			System.out.println("Want to add more records y/n");  
			String ans=br.readLine();  
			if(ans.equals("n")){  
			break;  }}
			
			ResultSet empdetails1=stmt.executeQuery("select * from employeedata");
			while(empdetails1.next())
			{
				System.out.println(empdetails1.getString(1)+" "+empdetails1.getString(2)+" "+empdetails1.getString(3)+" "+empdetails1.getString(4)+" "+empdetails1.getString(5)+" "+empdetails1.getString(6)+" "+empdetails1.getString(7)+" "+empdetails1.getString(8)+" "+empdetails1.getString(9)+" "+empdetails1.getString(10)+" "+empdetails1.getString(11)+" "+empdetails1.getString(12)+" "+empdetails1.getString(13)+" "+empdetails1.getString(14)+" "+empdetails1.getString(15)+" "+empdetails1.getString(16)+" "+empdetails1.getString(17)+" "+empdetails1.getString(18)+" "+empdetails1.getString(19)+" "+empdetails1.getString(20));
			}
			
		
			XSSFWorkbook workbook=new XSSFWorkbook();
			XSSFSheet sheet=workbook.createSheet("employeedata");
			
			XSSFRow row=sheet.createRow(0);
			row.createCell(0).setCellValue("employeeId");
			row.createCell(1).setCellValue("firstName");
			row.createCell(2).setCellValue("middleName");
			row.createCell(3).setCellValue("lastName");
			row.createCell(4).setCellValue("fullName");
			row.createCell(5).setCellValue("emailId");
			row.createCell(6).setCellValue("education");
			row.createCell(7).setCellValue("mobileNumber");
			row.createCell(8).setCellValue("dateofbirth");
			row.createCell(9).setCellValue("gender");
			row.createCell(10).setCellValue("address1");
			row.createCell(11).setCellValue("address2");
			row.createCell(12).setCellValue("pincode");
			row.createCell(13).setCellValue("City");
			row.createCell(14).setCellValue("State");
			row.createCell(15).setCellValue("jobDesignation");
			row.createCell(16).setCellValue("jobRole");
			row.createCell(17).setCellValue("joiningDate");
			row.createCell(18).setCellValue("Salary");
			row.createCell(19).setCellValue("PerAnnum");
			ResultSet empdetails=stmt.executeQuery("select * from employeedata");
			
			int r=1;
			while(empdetails.next())
			{
				String empid=empdetails.getString("employeeId");
				String fName=empdetails.getString("firstName");
				String mName=empdetails.getString("middleName");
				String lName=empdetails.getString("lastName");
				String fullName=empdetails.getString("fullName");
				String email=empdetails.getString("emailId");
				String education=empdetails.getString("education");
				String mob=empdetails.getString("mobileNumber");
				String dob=empdetails.getString("dateofbirth");
				String gender=empdetails.getString("gender");
				String address1=empdetails.getString("address1");
				String address2=empdetails.getString("address2");
				String pincode=empdetails.getString("pincode");
				String city=empdetails.getString("City");
				String state=empdetails.getString("State");
				String jobdesign=empdetails.getString("jobDesignation");
				String jobrole=empdetails.getString("jobRole");
				String jod=empdetails.getString("joiningDate");
				String sal=empdetails.getString("Salary");
				String salperannum=empdetails.getString("PerAnnum");
				
				
				row=sheet.createRow(r++);
				
				row.createCell(0).setCellValue(empid);
				row.createCell(1).setCellValue(fName);
				row.createCell(2).setCellValue(mName);
				row.createCell(3).setCellValue(lName);
				row.createCell(4).setCellValue(fullName);
				row.createCell(5).setCellValue(email);
				row.createCell(6).setCellValue(education);
				row.createCell(7).setCellValue(mob);
				row.createCell(8).setCellValue(dob);
				row.createCell(9).setCellValue(gender);
				row.createCell(10).setCellValue(address1);
				row.createCell(11).setCellValue(address2);
				row.createCell(12).setCellValue(pincode);
				row.createCell(13).setCellValue(city);
				row.createCell(14).setCellValue(state);
				row.createCell(15).setCellValue(jobdesign);
				row.createCell(16).setCellValue(jobrole);
				row.createCell(17).setCellValue(jod);
				row.createCell(18).setCellValue(sal);
				row.createCell(19).setCellValue(salperannum);
				
			}
			
			
			FileOutputStream fos=new FileOutputStream("C:\\Users\\Dhileepan\\Downloads\\employee.xlsx");
			workbook.write(fos);
			
			workbook.close();
			fos.close();
			con.close();
			
			System.out.println("completed!!!");            
            
            
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 
		
	}

	

}



