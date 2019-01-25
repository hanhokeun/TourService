package Controller.MyTour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.MyTourDAO;

public class MyDetailModifyProc implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String np = req.getParameter("np"); //릴레이용
		String strMNo = req.getParameter("mNo"); //회원번호
		int mNo = Integer.parseInt(strMNo);
		String strMtNo = req.getParameter("mtNo"); //여행번호
		int mtNo = Integer.parseInt(strMtNo);
		String strTdNo = req.getParameter("tdNo"); //등록 상세여행지번호
		int tdNo = Integer.parseInt(strTdNo);
		String nowPage = req.getParameter("nowPage"); //여행리스트 릴레이용
		//수정사항
		String title=req.getParameter("title");
		String start=req.getParameter("startDate");
		String end=req.getParameter("endDate");
		
		//비즈니스로직
		MyTourDAO dao = new MyTourDAO();
		dao.updateMyTourDetail(start, end, tdNo);
		dao.close();
		
		req.setAttribute("MNO", mNo);
		req.setAttribute("MTNO", mtNo);
		req.setAttribute("NP", np);
		req.setAttribute("TDNO", tdNo);
		req.setAttribute("nowPage", nowPage);
		
		return "../VIEW/MyTour/myDetailModifyProc.jsp";
	}

}
