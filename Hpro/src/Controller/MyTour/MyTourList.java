package Controller.MyTour;

import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.TourSuperController;
import DAO.MyTourDAO;
import Sql.MyTourSql;
import Util.POOLUtil;
import Util.PageUtil;

public class MyTourList implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//파라미터받기
		String strPage=req.getParameter("nowPage");
		String strMNo= req.getParameter("mNo");
		//int mNo = Integer.parseInt(strMNo);
		int nowPage=0;
		if(strPage==null|| strPage.length()==0) {
			//파라미터가 없는 경우는 초기페이지를 1로 보여줌
			nowPage=1;
		}else {
			nowPage= Integer.parseInt(strPage);
		}
		HttpSession session = req.getSession();
		int mNo=(int) session.getAttribute("mNo");
		//비즈니스로직 수행
		MyTourDAO dao = new MyTourDAO();
		int totalCount=dao.selectMyListTotalCount(mNo);
		//상세보기에 가진 여행지 리스트 갯수 받아오기
		ArrayList list1 = dao.selectMyTourDetailTotalCount(mNo);
		//여행지목록들 페이징 처리
		PageUtil pinfo = new PageUtil(nowPage,totalCount,5,3);
		//이름과 날짜가 든 list
		ArrayList list2=dao.selectMyTourNameDate(pinfo,mNo); 
		//img가 든 list
		ArrayList list3=dao.selectMyTourImg(mNo); 
		dao.close();
		//모델
		req.setAttribute("TOTALCOUNT", list1); //여행지 찜한 갯수
		req.setAttribute("LIST1", list2); //이름과 날짜
		req.setAttribute("LIST2", list3); //이미지리스트
		req.setAttribute("PINFO", pinfo); //페이지정보
		req.setAttribute("MNO", mNo); //로그인된 회원정보 넘겨주기
		//뷰
		return "../VIEW/MyTour/myTourList.jsp";
	}

}
