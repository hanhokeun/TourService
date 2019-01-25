package Controller.MyTour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.MyTourDAO;

public class MyTourModifyProc implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//파라미터받기
		String np =req.getParameter("np"); //상세보기 페이지를 위한 릴레이용
		String strMNo=req.getParameter("mNo");
		int mNo = Integer.parseInt(strMNo);
		String strMtNo=req.getParameter("mtNo");
		int mtNo = Integer.parseInt(strMtNo);
		String name = req.getParameter("title");
		String start = req.getParameter("startDate");
		String end = req.getParameter("endDate");
		String nowPage = req.getParameter("nowPage"); //여행리스트 페이지를 위한 릴레이용
		//비즈니스로직 수행
		MyTourDAO dao = new MyTourDAO();
		int change=dao.updateMyTourNameDate(name,start,end,mtNo,mNo); //여행 일자,이름 수정여부를 위한 change
		System.out.println("여행 일자,이름 수정여부를 위한 change="+change);
		dao.close();
		
		MyTourDAO dao1 = new MyTourDAO();
		dao1.updateTourDetailStart(start,end,mtNo); //여행일자 수정에 따른 상세여행지 시작날짜 수정
		dao1.updateTourDetailEnd(end,start,mtNo); //여행일자 수정에 따른 상세여행지 종료날짜 수정
		dao1.close();
		
		//모델
		req.setAttribute("nowPage", nowPage); //내여행리스트를 위한 릴레이용
		req.setAttribute("MNO", mNo); //릴레이용
		req.setAttribute("MTNO", mtNo); //릴레이용
		req.setAttribute("CHANGE", change); //수정여부를 알려주기 위한 값
		
		//뷰
		return "../VIEW/MyTour/myTourModifyProc.jsp";
	}

}
