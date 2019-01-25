package Controller.ReBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.ReBoardDAO;

public class ModifyProc implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//할일
		//파라미터 받고
		String nowPage = req.getParameter("nowPage");
		String  strNo = req.getParameter("oriNo");
		int     oriNo = Integer.parseInt(strNo);
		
		String title = req.getParameter("title");
		String body = req.getParameter("body");
		//String pw= req.getParameter("pw");
		
		//DAO를 호출(비즈니스로직수행)
		ReBoardDAO dao = new ReBoardDAO();
		dao.updateBoard(title,body,oriNo);
		
		//모델
		req.setAttribute("oriNo", oriNo);
		req.setAttribute("nowPage", nowPage);
		
		//뷰
		return "../VIEW/ReBoard/ModifyProc.jsp";
	}

}





