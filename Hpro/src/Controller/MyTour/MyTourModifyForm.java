package Controller.MyTour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.TourSuperController;
import DAO.MyTourDAO;
import VO.MyTourVO;

public class MyTourModifyForm implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//파라미터받기
		String np=req.getParameter("np"); //여행지 상세보기 릴레이용
		String strMNo=req.getParameter("mNo");
		int mNo = Integer.parseInt(strMNo);
		String strMtNo = req.getParameter("mtNo"); //여행번호
		int mtNo = Integer.parseInt(strMtNo);
		String nowPage = req.getParameter("nowPage"); //여행리스트 릴레이용
		
		//비즈니스로직 수행
		MyTourDAO dao = new MyTourDAO();
		MyTourVO vo = dao.selectMyTourNameDate(mNo, mtNo); //여행이름과 날짜 받아주기
		
		req.setAttribute("nowPage", nowPage);
		req.setAttribute("NP", np); //릴레이용
		req.setAttribute("MNO",mNo);
		req.setAttribute("VO", vo); 
		return "../VIEW/MyTour/myTourModifyForm.jsp";
	}

}
