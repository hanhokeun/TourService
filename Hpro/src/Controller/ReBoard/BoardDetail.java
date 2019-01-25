package Controller.ReBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Controller.TourSuperController;
import Sql.ReBoardSql;
import Util.POOLUtil;
import VO.ReBoardVO;

public class BoardDetail implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//할일
		//1. 파라미터받고
		String strNo = req.getParameter("oriNo");//글번호몇번
		int    oriNo = Integer.parseInt(strNo);
		
		// 파라미터 릴레이로 넘어온 데이터를 받자
		String nowPage=req.getParameter("nowPage");//보고싶은페이지번호 
		HttpSession session = req.getSession();
		
		// 세션에 그 사람이 본 게시물의 글번호를 누적해서 기록해 놓는다
		boolean isHit = false;	//조회수 증가를 할지말지를 판단하는 변수
		ArrayList	list = 
				(ArrayList)session.getAttribute("SHOW");
		
		if(list==null || list.size()==0 ) {
			isHit = true;
			list = new ArrayList();
			list.add(oriNo);
			session.setAttribute("SHOW",list);
		}
		else if(list.contains(oriNo)) {
			isHit = false;
		}
		else {
			isHit = true;
			list.add(oriNo);
			session.setAttribute("SHOW",list);
		}
			
		//2. 조회수증가.. db연결..쿼리..스테이트먼트, 실행
		POOLUtil db = new POOLUtil();
		Connection con = db.getCon();
		String sql  = 
				ReBoardSql.getSQL(ReBoardSql.UPDATE_HIT);
		System.out.println("sql="+sql);
		
		PreparedStatement stmt = db.getSTMT(con, sql);
		
		try {
			stmt.setInt(1, oriNo);
			if(isHit == true) {
				stmt.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println("UPDATE_HIT실행 에러="+e);
		}
		db.close(stmt);
		
		
		//3. 상세보기를 하기위해 해당 글정보를 검색
		String sqlD = ReBoardSql.getSQL(ReBoardSql.SELECT_DETAIL);
		System.out.println("상세보기sqlD="+sqlD);
		ReBoardVO vo = new ReBoardVO();//상세보기 결과를 담기위한 변수	
		stmt = db.getSTMT(con, sqlD);
		try {
			stmt.setInt(1,oriNo);
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
			System.out.println("상세보기 실행 에러="+e);
		}		
		db.close(stmt);
						
		//4. 해당 글에 달린 댓글을 검색
		sql = ReBoardSql.getSQL(6);
		System.out.println("댓글검색 sql="+sql);
		stmt = db.getSTMT(con, sql);
		ArrayList list1 = new ArrayList();		
		
		try {
			stmt.setInt(1,oriNo);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				//한 줄의 데이터를 VO에 묶고
				ReBoardVO vo1 = new ReBoardVO();
				vo1.setNo(rs.getInt("NO"));
				vo1.setOriNo(rs.getInt("ORINO"));
				vo1.setWriter(rs.getString("WRITER"));
				vo1.setTitle(rs.getString("TITLE"));
				vo1.setBody(rs.getString("BODY"));
				vo1.setWday(rs.getString("WDAY"));
				list1.add(vo1);
			}
			db.close(rs);
		}
		catch(Exception e) {
			System.out.println("댓글검색 실행 에러="+e);
		}
				
		db.close(stmt);
		db.close(con);
		
		//5. 결과를 모델로..
		req.setAttribute("VIEW",vo); //상세보기 결과 데이터
		req.setAttribute("REPLY",list1);//댓글검색 결과 데이터
		//	파라미터 릴레이는 계속해서 다음 문서에 알려주어야 한다
		req.setAttribute("nowPage",nowPage);
		
		//뷰
		return "../VIEW/ReBoard/BoardDetail.jsp";
	}

}









