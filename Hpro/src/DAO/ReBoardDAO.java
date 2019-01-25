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
 * =>Dats에 접속하는 객체
 * =>데이터베이스 작업을 전담할 클래스
 * =>데이터베이스 작업에 문제가 생기거나, 관련된 처리가 바뀌면
 * 	 앞으로 DAO파일만 수정하면 될 것이다
 */
public class ReBoardDAO {
	
	private POOLUtil db;
	private Connection con;
	
	public ReBoardDAO() {
		db = new POOLUtil();
		con = db.getCon();
	}
	//기능을 필요할 때마다 (함수)추가	
	//원글 리스트들 구하기
	public ArrayList selectBoardList(PageUtil pinfo) {
		String sql = ReBoardSql.getSQL(ReBoardSql.SELECT_BOARDLIST);
		System.out.println("SELECT_BOARDLIST sql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		ArrayList  list = new ArrayList();
		try {
			ResultSet rs = stmt.executeQuery();
			int skip = (pinfo.getNowPage()-1)*pinfo.getListCount();
			for(int i=0;i<skip ;i++) {
				rs.next(); //포인터 내리기
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
			System.out.println("SELECT_BOARDLIST 실행에러 ="+e);
		}
		//사용이 끝난 커넥션은 반드시 커넥션 풀에 반납해야 다음 작업에서 커넥션을 사용할 수 있다
		db.close(stmt);
		return list;
	}
	//원글 총 갯수 구하기
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
			System.out.println("총데이터개수 에러="+e);
		}
		db.close(stmt1);
		return totalCount;
	}
	//댓글등록
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
			System.out.println("댓글 등록질의 실행 에러 = " + e);
		}
	}
	//댓글삭제하기
	public int deleteReply(int reNo,String pw) {
		String sql = ReBoardSql.getSQL(10);
		System.out.println("댓글삭제질의 sql="+sql);
		
		PreparedStatement stmt = db.getSTMT(con,sql);
		int change = 0;//질의실행결과를 담기 위한 변수  0이면 실패,1이면 성공
		
		try {
			stmt.setInt(1, reNo);
			stmt.setString(2, pw);
			change = stmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("댓글삭제질의실행 에러="+e);
		}
		
		return change;
	}
	//댓글수정하기
	public void updateReply(int reNo,String title,String body,String pw) {
		String sql = ReBoardSql.getSQL(9);
		System.out.println("댓글수정하기 sql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		
		try {
			stmt.setString(1 , title);
			stmt.setString(2 , body);
			stmt.setString(3 , pw);
			stmt.setInt(4 , reNo);
			
			stmt.execute();
		}
		catch(Exception e) {
			System.out.println("댓글수정 질의실행 에러="+e);
		}
		db.close(stmt);
	}
	
	
	//원글 삭제하기
	public int deleteBoard(int oriNo, String pw) {
		String sql = ReBoardSql.getSQL(8);
		PreparedStatement stmt = db.getSTMT(con, sql);
		int change = 0;
		try {
				stmt.setInt(1, oriNo);
				stmt.setString(2, pw);
				change = stmt.executeUpdate();
			System.out.println("원글삭제 질의 실행결과="+change);
			
		}
		catch(Exception e) {
			System.out.println("원글삭제 질의 실행 에러="+e);
		}
		db.close(stmt);
		return change;
	}
	//원글 수정하기      
	public void updateBoard(String title, String body, int oriNo) {
		//질의문
		String sql  = ReBoardSql.getSQL(7);
		System.out.println("원글수정질의문="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		try {
			stmt.setString(1,title);
			stmt.setString(2,body);
			//stmt.setString(3,pw);
			stmt.setInt(3,oriNo);
			
			stmt.execute();
		}
		catch(Exception e) {
			System.out.println("원글수정 질의 실행 에러="+e);
		}
		db.close(stmt);
	}
	
	//원글 상세보기
	public ReBoardVO selectDetail(int oriNo) {
		String sql = ReBoardSql.getSQL(ReBoardSql.SELECT_DETAIL);
		PreparedStatement stmt = db.getSTMT(con, sql);
		//결과물을 담기위한 변수
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
			System.out.println("(수정폼에 뿌릴)원글상세보기 질의 실행에러="+e);
		}
		db.close(stmt);
		return vo;
	}
	
	public void close() {
		db.close(con);
	}
	
}









