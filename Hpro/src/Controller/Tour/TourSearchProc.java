package Controller.Tour;

import java.sql.Connection;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.TourSuperController;
import DAO.TourDAO;
import Sql.TourSql;
import Util.POOLUtil;
import Util.PageUtil;
import VO.TourVO;
import java.sql.*;

public class TourSearchProc implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//할일
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			System.out.println("인코딩에러="+e);
		}
		//파라미터
		HttpSession session = req.getSession();
		int grade=0;
		if(session.getAttribute("mId")!=null) {
			String uid = (String)session.getAttribute("mId");
			grade = (int)session.getAttribute("grade");
		}else {
			grade=0;
		}
		String theme1 = req.getParameter("theme");
		String area = req.getParameter("lName");
		System.out.println(area);
		System.out.println(theme1);
		String strPage = req.getParameter("nowPage");
		int nowPage = 0;
			if(strPage==null||strPage.length()==0){
				nowPage=1;
			}
			else {
				nowPage=Integer.parseInt(strPage);
			}
			System.out.println("nowPage="+nowPage);
		//비즈니스로직
		//페이징처리	
		TourDAO dao = new TourDAO();
		TourVO vo = new TourVO();
		ArrayList list = new ArrayList();

		try {
			if(area==null||area.equals("0")){
				list = dao.searchTheme(theme1);
			}
			else if(theme1==null||theme1.length()==0) {
				list = dao.searchArea(area);
			}
			else if(area!="0"&&theme1!=null) {
				list = dao.searchEach(theme1,area);
			}
		}
		catch(Exception e) {
			System.out.println("가져오려는 지역과 테마가 없어요!");
		}
		if(list==null) {
		return "../VIEW/Tour/TourErrorPage.jsp";	
		}
		else {
			
		//모델
		req.setAttribute("nowPage", nowPage);
		req.setAttribute("SEARCH",list);
		req.setAttribute("GRADE", grade);
		//뷰
		return "../VIEW/Tour/TourSearchResult.jsp";
		}
	}

}
