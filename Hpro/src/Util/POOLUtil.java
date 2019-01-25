package Util;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;

public class POOLUtil {

	DataSource pool;
	public POOLUtil() {
		InitialContext initContext;
		try {
			initContext = new InitialContext();
			Context poolName = (Context)initContext.lookup("java:/comp/env");
			pool = (DataSource)poolName.lookup("jdbc/myoracle");
		} catch (Exception e) {
			System.out.println("Ŀ�ؼ� Ǯ ���� ����="+e);
		}
	}
	public Connection getCon() {
		Connection con = null;
		try {
			con = pool.getConnection();
		} catch (SQLException e) {
			System.out.println("Ŀ�ؼ� ����="+e);
		}
		return con;
	}
	public Statement getSTMT(Connection con) {
		Statement stmt = null;
		try {
			stmt=con.createStatement();
		} catch (SQLException e) {
			System.out.println("������Ʈ��Ʈ ��������="+e);
		}
		return stmt;
	}
	public PreparedStatement getSTMT(Connection con, String sql) {
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println("PreparedStatement ��������="+e);
		}
		return stmt;
	}
	public void close(Object obj) {
			try {
				if(obj instanceof Connection) {
					Connection temp = (Connection)obj;
					temp.close();
				}
				else if(obj instanceof Statement) {
					Statement temp = (Statement)obj;
					temp.close();
				}
				else if(obj instanceof PreparedStatement) {
					PreparedStatement temp = (PreparedStatement)obj;
					temp.close();
				}
				else if(obj instanceof ResultSet) {
					ResultSet temp = (ResultSet)obj;
					temp.close();
				}
			} catch (Exception e) {
				System.out.println("�ݱ� ����="+e);
			}
		
	}
}
