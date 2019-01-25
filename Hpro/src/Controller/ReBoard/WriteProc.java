package Controller.ReBoard;

import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.TourSuperController;
import Sql.ReBoardSql;
import Util.POOLUtil;

public class WriteProc implements TourSuperController{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//할일
		// 파라미터받고
		String title = req.getParameter("title");
		String body = req.getParameter("body");
		String pw = req.getParameter("pw");
		
		// 부족한 데이터 글쓴이는 세션에서 받아서  생산한다
		HttpSession session = req.getSession();
		int mNo = (int) session.getAttribute("mNo");
		// 글등록 수행..db에서 insert.. 접속,스테이트먼트,실행
		POOLUtil db = new POOLUtil();
		Connection con = db.getCon();
		String sql = 
		ReBoardSql.getSQL(ReBoardSql.INSERT_ORIBOARD); 	
		System.out.println("sql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		
		try {
			//?채우자
			stmt.setInt(1, mNo);
			stmt.setString(2, title);
			stmt.setString(3, body);
			stmt.setString(4, pw);
			
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("원글등록 질의 실행 에러="+e);
		}
		db.close(stmt);
		db.close(con);
		
		// 모델
		
		// 뷰 
		return "../VIEW/ReBoard/WriteProc.jsp";
	}

}






