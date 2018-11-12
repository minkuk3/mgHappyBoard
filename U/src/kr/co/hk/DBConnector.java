package kr.co.hk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnector {
	
	public static Connection getConnection() throws Exception{
		
		Connection con = null;
			
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hkitedu");
			
			System.out.println("DB연결완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;

	}
	
	public static void close(Connection con, PreparedStatement ps, ResultSet rs){
		if(rs != null){
			try { rs.close(); } catch (Exception e) { e.printStackTrace(); } 
			}
		
		if(ps != null){
			try { ps.close(); } catch (Exception e) { e.printStackTrace(); }
		}
		
		if(con != null){
			try { con.close(); } catch (Exception e) { e.printStackTrace(); }
		}
	}

}
