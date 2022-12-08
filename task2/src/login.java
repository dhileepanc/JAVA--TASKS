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

public class login {
	static Connection con;

	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

		// properties used for connection

		Properties prop = new Properties();
		InputStream input = new FileInputStream("C:\\Users\\Dhileepan\\Desktop\\db.properties");
		prop.load(input);
		String password = prop.getProperty("Password");
		String Username = prop.getProperty("User_Name");
		String JDBC_URL = prop.getProperty("JDBC_URL");
		String JDBC_DRIVER = prop.getProperty("JDBC_DRIVER");
		Class.forName(JDBC_DRIVER);
		con = DriverManager.getConnection(JDBC_URL, Username, password);

		// object created for login class
		login l1 = new login();
		l1.LoginPage();

	}

	void LoginPage() throws SQLException {

		//for password decryption
		Base64.Decoder decoder = Base64.getDecoder();
		Base64.Encoder encoder = Base64.getEncoder();

		Statement stmt1 = con.createStatement();
		
		Scanner sc1 = new Scanner(System.in);

		System.out.println("Enter your UserName ");
		String Username1 = sc1.nextLine();

		System.out.println("enter your Password :");
		String password1 = sc1.nextLine();

		//choosing database
		stmt1.execute("use user");
		
		//table selection for getting data
		ResultSet rs1 = stmt1.executeQuery("Select * from userdetails");


		while (rs1.next()) {
			
			// encryptpassword table 
			String encrypt = rs1.getString("EncryptPassword");
			
			//username table 
			String userNameTable = rs1.getString("username");
			
			//for decrypt password
			String dPassword = new String(decoder.decode(encrypt));
			
			//condition checking
			if (Username1.equals(userNameTable) & password1.equals(dPassword)) {
				System.out.println(" match!!");
				break;
			}

			/*
			 * else { System.out.println(" not match"); }
			 */

		}

	}
}