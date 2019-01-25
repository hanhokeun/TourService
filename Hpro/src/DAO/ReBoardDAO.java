package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Sql.ReBoardSql;
import Util.POOLUtil;
import Util.PageUtil;
import VO.ReBoardVO;

/* DAO(Data Access Object)
 * =>Dats�� �����ϴ� ��ü
 * =>�����ͺ��̽� �۾��� ������ Ŭ����
 * =>�����ͺ��̽� �۾��� ������ ����ų�, ���õ� ó���� �ٲ��
 * 	 ������ DAO���ϸ� �����ϸ� �� ���̴�
 */
public class ReBoardDAO {
	
	private POOLUtil db;
	private Connection con;
	
	public ReBoardDAO() {
		db = new POOLUtil();
		con = db.getCon();
	}
	//����� �ʿ��� ������ (�Լ�)�߰�	
	//���� ����Ʈ�� ���ϱ�
	public ArrayList selectBoardList(PageUtil pinfo) {
		String sql = ReBoardSql.getSQL(ReBoardSql.SELECT_BOARDLIST);
		System.out.println("SELECT_BOARDLIST sql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		ArrayList  list = new ArrayList();
		try {
			ResultSet rs = stmt.executeQuery();
			int skip = (pinfo.getNowPage()-1)*pinfo.getListCount();
			for(int i=0;i<skip ;i++) {
				rs.next(); //������ ������
			}
			for(int i=0;i<pinfo.getListCount() && rs.next();i++) {
				ReBoardVO vo = new ReBoardVO();
				vo.setNo(rs.getInt("RBNO"));
				vo.setmNo(rs.getInt("MNO"));
				vo.setWriter(rs.getString("ID"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setHit(rs.getInt("HIT"));
				vo.setWday(rs.getString("WDAY"));
				vo.setCnt(rs.getInt("CNT"));
				list.add(vo);
			}
			db.close(rs);
		} catch (Exception e) {
			System.out.println("SELECT_BOARDLIST ���࿡�� ="+e);
		}
		//����� ���� Ŀ�ؼ��� �ݵ�� Ŀ�ؼ� Ǯ�� �ݳ��ؾ� ���� �۾����� Ŀ�ؼ��� ����� �� �ִ�
		db.close(stmt);
		return list;
	}
	//���� �� ���� ���ϱ�
	public int selectTotalCount() {
		String sql1 = ReBoardSql.getSQL(ReBoardSql.SELECT_TOTALCOUNT);
		System.out.println("sql1="+sql1);
		int totalCount = 0;
		PreparedStatement stmt1 = db.getSTMT(con,sql1);
		try {
			ResultSet rs1 = stmt1.executeQuery();
			rs1.next();
			totalCount = rs1.getInt("CNT");
			System.out.println("totalCount ="+totalCount);
			db.close(rs1);
		} catch (Exception e) {
			System.out.println("�ѵ����Ͱ��� ����="+e);
		}
		db.close(stmt1);
		return totalCount;
	}
	//��۵��
	public void insertReply(int oriNo, int mNo, String title, String body, String pw) {		
		String	sql = ReBoardSql.getSQL(11);
		PreparedStatement	stmt = db.getSTMT(con, sql);
		try {
			stmt.setInt(1, oriNo);
			stmt.setInt(2, mNo);
			stmt.setString(3, title);
			stmt.setString(4, body);
			stmt.setString(5, pw);
			stmt.execute();
		}
		catch(Exception e) {
			System.out.println("��� ������� ���� ���� = " + e);
		}
	}
	//��ۻ����ϱ�
	public int deleteReply(int reNo,String pw) {
		String sql = ReBoardSql.getSQL(10);
		System.out.println("��ۻ������� sql="+sql);
		
		PreparedStatement stmt = db.getSTMT(con,sql);
		int change = 0;//���ǽ������� ��� ���� ����  0�̸� ����,1�̸� ����
		
		try {
			stmt.setInt(1, reNo);
			stmt.setString(2, pw);
			change = stmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("��ۻ������ǽ��� ����="+e);
		}
		
		return change;
	}
	//��ۼ����ϱ�
	public void updateReply(int reNo,String title,String body,String pw) {
		String sql = ReBoardSql.getSQL(9);
		System.out.println("��ۼ����ϱ� sql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		
		try {
			stmt.setString(1 , title);
			stmt.setString(2 , body);
			stmt.setString(3 , pw);
			stmt.setInt(4 , reNo);
			
			stmt.execute();
		}
		catch(Exception e) {
			System.out.println("��ۼ��� ���ǽ��� ����="+e);
		}
		db.close(stmt);
	}
	
	
	//���� �����ϱ�
	public int deleteBoard(int oriNo, String pw) {
		String sql = ReBoardSql.getSQL(8);
		PreparedStatement stmt = db.getSTMT(con, sql);
		int change = 0;
		try {
				stmt.setInt(1, oriNo);
				stmt.setString(2, pw);
				change = stmt.executeUpdate();
			System.out.println("���ۻ��� ���� ������="+change);
			
		}
		catch(Exception e) {
			System.out.println("���ۻ��� ���� ���� ����="+e);
		}
		db.close(stmt);
		return change;
	}
	//���� �����ϱ�      
	public void updateBoard(String title, String body, int oriNo) {
		//���ǹ�
		String sql  = ReBoardSql.getSQL(7);
		System.out.println("���ۼ������ǹ�="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		try {
			stmt.setString(1,title);
			stmt.setString(2,body);
			//stmt.setString(3,pw);
			stmt.setInt(3,oriNo);
			
			stmt.execute();
		}
		catch(Exception e) {
			System.out.println("���ۼ��� ���� ���� ����="+e);
		}
		db.close(stmt);
	}
	
	//���� �󼼺���
	public ReBoardVO selectDetail(int oriNo) {
		String sql = ReBoardSql.getSQL(ReBoardSql.SELECT_DETAIL);
		PreparedStatement stmt = db.getSTMT(con, sql);
		//������� ������� ����
		ReBoardVO vo = new ReBoardVO();
		try {
			stmt.setInt(1, oriNo);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			vo.setNo(rs.getInt("NO"));
			vo.setWriter(rs.getString("WRITER"));
			vo.setTitle(rs.getString("TITLE"));
			vo.setBody(rs.getString("BODY"));
			vo.setHit(rs.getInt("HIT"));
			vo.setWday(rs.getString("WDAY"));
			db.close(rs);
		} catch (Exception e) {
			System.out.println("(�������� �Ѹ�)���ۻ󼼺��� ���� ���࿡��="+e);
		}
		db.close(stmt);
		return vo;
	}
	
	public void close() {
		db.close(con);
	}
	
}









