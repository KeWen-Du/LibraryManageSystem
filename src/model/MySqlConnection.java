package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
public class MySqlConnection {
	public MySqlConnection(){
	}
	public static  Connection getConnection() {
		String DB_Driver = "com.mysql.cj.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost:3306/librarybookmanagesystem?useSSL=false&&serverTimezone=GMT&&allowPublicKeyRetrieval=true" ;		
		String userName = "root" ; 
		String userPassword = "123456" ;
		Connection conn = null ;
		Statement sta = null ;
		try {
			Class.forName(DB_Driver).newInstance();			
			conn =  DriverManager.getConnection(DB_URL,userName,userPassword);			
			System.out.println("Connection Success !");		
		} catch (Exception e) {
			
			System.out.println("Connection Fail !");
			e.printStackTrace() ;
		}	
		return conn ;
	}
	public static void free(ResultSet rs, Statement sta , Connection con)
	{
		try {
			if(null != rs)
			{
				rs.close();
				rs = null ;
			}
			
			if(null != sta)
			{
				sta.close();
				sta = null ;
			}
			
			if(null != con)
			{
				con.close();
				con = null ;
				System.out.println("Connection ¹Ø±Õ³É¹¦");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
