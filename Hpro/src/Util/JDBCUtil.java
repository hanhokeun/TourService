package Util;

import java.sql.*;

public class JDBCUtil {

	public JDBCUtil() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("드라이버 로딩 에러:"+e);
			e.printStackTrace();
		}
	}
	
	public Connection getCon() {
	
	Connection con = null;
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="peach";
		String pw="1234";
	try {
		con = DriverManager.getConnection(url,user,pw);
	} catch (Exception e) {
		System.out.println("커넥션 에러:"+e);
		
	}
		return con;
	}

	public Statement getSTMT(Connection con) {
		Statement stmt = null;
		try {
			stmt=con.createStatement();
		} catch (Exception e) {
			System.out.println("스테이트먼트 생성 에러:"+e);
		}
		return stmt;
	}

	public PreparedStatement getSTMT(Connection con,String sql){

		PreparedStatement stmt = null;
		try {
			stmt=con.prepareStatement(sql);
		}
		catch(Exception e) {
		System.out.println("PreparedStament 생성 에러:"+e);
		}
		return stmt;
	}

	public void close(Object obj) {
		try {
			if(obj instanceof Connection) {
				Connection temp=(Connection)obj;
				temp.close();
			}
			else if(obj instanceof Statement) {
				Statement temp = (Statement)obj;
				temp.close();
			}
			else if(obj instanceof PreparedStatement) {
				PreparedStatement temp=(PreparedStatement)obj;
				temp.close();
			}
			else if(obj instanceof ResultSet) {
				ResultSet temp=(ResultSet)obj;
				temp.close();
			}
		}
		catch(Exception e) {
			System.out.println("닫기 에러:"+e);
		}
	}
}
