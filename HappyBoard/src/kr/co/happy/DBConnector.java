package kr.co.happy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnector {
	public static Connection getConnection(){
		Connection conn = null;
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String pw = "hkitedu";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,user,pw);
			System.out.println("DB 연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn , PreparedStatement ps , ResultSet rs){
		if(rs != null){
			try {rs.close();} catch (SQLException e) {e.printStackTrace();}
		}
		if(ps != null){
			try {ps.close();} catch (SQLException e) {e.printStackTrace();}
		}
		if(conn != null){
			try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}
}
