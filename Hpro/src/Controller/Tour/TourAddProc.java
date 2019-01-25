package Controller.Tour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import Sql.TourSql;
import Util.POOLUtil;

import java.io.UnsupportedEncodingException;
import java.sql.*;

public class TourAddProc implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//할일
		//파라미터
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			System.out.println("인코딩에러="+e);
		}
		String name = req.getParameter("atName");
		String area = req.getParameter("alName");
		String addr = req.getParameter("addr");
		String addr2 = req.getParameter("addr2");
		String theme = req.getParameter("atheme");
		String img1 = req.getParameter("img1");
		String img2 = req.getParameter("img2");
		String img3 = req.getParameter("img3");
		String img4 = req.getParameter("img4");
		String tcon = req.getParameter("tcon");
		String strx = req.getParameter("x");
		double x = Double.parseDouble(strx);
		String stry = req.getParameter("y");
		double y = Double.parseDouble(stry);
		//비즈니스로직
		//관광지 등록
		POOLUtil db = new POOLUtil();
		Connection con = db.getCon();
		String sql4 =  TourSql.getSQL(4);
		System.out.println("sql4="+sql4);
		PreparedStatement stmt = db.getSTMT(con, sql4);
		//?? 채우자
		try {
			
			stmt.setString(1,name);
			stmt.setString(2, theme);
			stmt.setString(3, area);
			stmt.setString(4,addr+" "+addr2);
			stmt.setString(5, img1);
			stmt.setString(6, img2);
			stmt.setString(7, img3);
			stmt.setString(8, img4);
			stmt.setDouble(9, x);
			stmt.setDouble(10, y);
			stmt.setString(11,tcon);
			
			stmt.executeUpdate();
			
		}
		catch(Exception e) {
			System.out.println("관광지정보추가 질의에러="+e);
		}
		//모델
		//뷰
		return "../VIEW/Tour/TourAddProc.jsp";
	}

}
