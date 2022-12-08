package passwordencryptdecrypt;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.apache.poi.ss.formula.functions.Now;

public class SignUp {
	static Connection con;
	public static String epassword;

	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
		
		//properties class used for connection jdbc
		Properties prop = new Properties();
		InputStream input = new FileInputStream("C:\\Users\\Dhileepan\\Desktop\\db.properties");
		prop.load(input);
		String password = prop.getProperty("Password");
		String Username = prop.getProperty("User_Name");
		String JDBC_URL = prop.getProperty("JDBC_URL");
		String JDBC_DRIVER = prop.getProperty("JDBC_DRIVER");
		Class.forName(JDBC_DRIVER);
		con = DriverManager.getConnection(JDBC_URL, Username, password);
		//object created for signup class
		SignUp Spage = new SignUp();
		Spage.signUppage();

	}

	void signUppage() throws IOException, SQLException {
		
		//for password encrypt
		Base64.Encoder encoder = Base64.getEncoder();
		
		Statement stmt;
		
		Scanner sc = new Scanner(System.in);
		User s1 = new User();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			
			System.out.println("Enter your First Name :");
			String firstname = (sc.nextLine());
			s1.setFirstName(firstname);

			System.out.println("Enter your Last Name :");
			String lastName = sc.nextLine();
			s1.setLastname(lastName);

			System.out.println("Enter your  DateOfBirth :");
			String DOB = sc.nextLine();
			s1.setDateOfBirth(DOB);

			System.out.println("Enter your Mobile Number :");
			String MobNum = sc.nextLine();
			s1.setMobileNo(MobNum);

			System.out.println("Enter your Username :");
			String userName = sc.nextLine();
			s1.setUserName(userName);

			System.out.println("Enter your Password :");
			String password = sc.nextLine();
			s1.setPassword(password);
			//password encrypt
			epassword = encoder.encodeToString(password.getBytes());
			s1.setEncryptPassword(epassword);
			System.out.println("Encrypt password: " + epassword);

			System.out.println("Enter your Email :");
			String email = sc.nextLine();
			s1.setEmailId(email);

			System.out.println("Enter your Gender :");
			String gender = sc.nextLine();
			s1.setGender(gender);
			
			stmt = con.createStatement();
			stmt.execute("use user");
			String queryCheck = "SELECT * from userdetails WHERE username = '" + userName + "'";
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(queryCheck); // execute the query, and get a java resultset

			// if username already exists, we quit
			if (rs.next()) {
				System.out.println(" user name Already exist!!! please try again");
				con.close();
				return;
			}

			System.out.println("Want to add more records y/n");
			String ans = br.readLine();
			if (ans.equals("n")) {
				System.out.println("Thank you");
				break;
			}

		}

		try {

			stmt.execute("use user");

			PreparedStatement pst = con.prepareStatement(
					"insert into userdetails(firstName,lastName,emailId,mobileNumber,dateofbirth,gender,username,password,createdate,EncryptPassword) values (?,?,?,?,?,?,?,?,Current_Timestamp,?)");

			pst.setString(1, s1.getFirstName());
			pst.setString(2, s1.getLastname());
			pst.setString(3, s1.getEmailId());
			pst.setString(4, s1.getMobileNo());
			pst.setString(5, s1.getDateOfBirth());
			pst.setString(6, s1.getGender());
			pst.setString(7, s1.getUserName());
			pst.setString(8, s1.getPassword());
			pst.setString(9, s1.getEncryptPassword());

			pst.executeUpdate();
			System.out.println("Completed");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
}