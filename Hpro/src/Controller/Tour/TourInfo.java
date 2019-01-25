package Controller.Tour;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.TourSuperController;
import DAO.TourDAO;
import Sql.TourSql;
import VO.TourVO;
import Util.*;

public class TourInfo implements TourSuperController  {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//할일
		POOLUtil db = new POOLUtil();
		Connection con = db.getCon();
		
		TourVO vo2 = new TourVO();
		HttpSession session = req.getSession();
		int grade=0;
		if(session.getAttribute("mId")!=null) {
			String uid = (String)session.getAttribute("mId");
			grade = (int)session.getAttribute("grade");
		}else {
			grade=0;
		}
		//파라미터 받고
		String nowPage = req.getParameter("nowPage");
		System.out.println(nowPage);
		String strNo = req.getParameter("tNo");
		System.out.println(strNo);
		int tNo = Integer.parseInt(strNo);
		
		
		//조회수 증가
		String sql7= TourSql.getSQL(7);
		System.out.println("sql7="+sql7);
		PreparedStatement stmt2 = db.getSTMT(con, sql7);
		
		TourVO vo1 = new TourVO();
		
		try {
			//세션에 그 사람이 본 게시물의 글번호를 누적해서 기록해 놓는다
			boolean isHit = false;	//조회수 증가를 할지 말지를 판단하는 변수
			ArrayList list = (ArrayList)session.getAttribute("SHOW");
			if(list==null || list.size()==0) {
				// 한 번도 어떤 글도 본적이 없다
				// 이 사람은 조회수를 증가시켜야 한다
				isHit = true;
				list= new ArrayList();	//주소값 기억
				list.add(tNo);
				session.setAttribute("SHOW",list);
			}
			else if(list.contains(tNo)) {
				//이사람은 그 글을 본적이 있으므로 조회수를 증가x
				isHit = false;
			}
			else {
				//이 사람은 다른 글은 봤어도 지금 글은 본적이 없는 경우 조회수 증가
				isHit=true;
				list.add(tNo);
				session.setAttribute("SHOW",list);
			}
			
			//해당 글번호의 rb_Hit컬럼의 데이터를 
			//조회수 증가를 해도 되는 사람만 증가시킨다
			//만약 어떤 사람이 다시 게시물을 보려고 하면
			//먼저 세션에 이미 본 게시물 번호를 확인하여서
			//존재하면 조회수를 증가를 하지말고
			//존재하지 않으면 조회수 증가
			
			stmt2.setInt(1,tNo);
			//해당 글번호의 컬럼의 데이터를 조회수 증가를 해도 되는 사람만 증가시킨다
			if(isHit==true) {
			stmt2.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println("조회수증가 에러="+e);
		}
		
		
		
		
		//상세보기를위해 관광지 정보 검색
		//관광지 번호에 맞는 관광지 정보를 보여줄 예정
		String sql2 = TourSql.getSQL(3);
		System.out.println("관광지정보질의문="+sql2);
		PreparedStatement stmt = db.getSTMT(con, sql2);
		try {
			stmt.setInt(1,tNo);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			vo2.setNo(rs.getInt("NO"));
			vo2.setName(rs.getString("NAME"));
			vo2.setArea(rs.getString("AREA"));
			vo2.setTheme1(rs.getString("THEME1"));
			vo2.setCnt(rs.getInt("CNT"));
			vo2.setImg1(rs.getString("IMG1"));
			vo2.setImg2(rs.getString("IMG2"));
			vo2.setImg3(rs.getString("IMG3"));
			vo2.setImg4(rs.getString("IMG4"));
			vo2.setAddr(rs.getString("ADDR"));
			vo2.setCon(rs.getString("CON"));
			vo2.setX(rs.getDouble("X"));
			vo2.setTy(rs.getDouble("TY"));
			db.close(rs);
		}
		catch(Exception e) {
			System.out.println("관광지 정보조회 실행에러="+e);
		}
		db.close(stmt);
		db.close(con);
		//모델
		req.setAttribute("VIEW",vo2);
		req.setAttribute("nowPage",nowPage);
		req.setAttribute("GRADE", grade);
		//뷰
		return "../VIEW/Tour/TourInfo.jsp";
	}

}
