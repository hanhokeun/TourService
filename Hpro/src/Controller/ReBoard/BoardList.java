package Controller.ReBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.TourSuperController;
import DAO.ReBoardDAO;
import Sql.ReBoardSql;
import Util.POOLUtil;
import Util.PageUtil;
import VO.ReBoardVO;

public class BoardList implements TourSuperController{
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//할일
		HttpSession session = req.getSession();
		int grade=0;
		if(session.getAttribute("mId")!=null) {
			String mid = (String)session.getAttribute("mId");
			grade = (int)session.getAttribute("grade");
		}else {
			grade=0;
		}
		// 보고싶은 페이지를 알아낸다
		String strPage = req.getParameter("nowPage");
		int nowPage = 0;
		if(strPage == null || strPage.length()==0) {
			//파라미터가 없다
			nowPage = 1;
		}
		else {
			nowPage = Integer.parseInt(strPage);
		}
		
		// 비즈니스로직 수행
		ReBoardDAO dao = new ReBoardDAO();
		
		int totalCount = dao.selectTotalCount();// 총데이터개수 구하기
		PageUtil pinfo = new PageUtil(nowPage,totalCount,5,3); //보고싶은 원글 갯수와 페이지 갯수 설정
				
		ArrayList list=dao.selectBoardList(pinfo); //총 리스트 구하기
		dao.close();
		
		//모델
		req.setAttribute("LIST", list);
		req.setAttribute("PINFO", pinfo);
		req.setAttribute("GRADE", grade);
		// 뷰(에서는 이 데이터를 이용해서 목록을 출력한다)
		return "../VIEW/ReBoard/BoardList.jsp";
	}

}







