package Controller.ReBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.ReBoardDAO;

public class BoardDelete implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//할일
		//파라미터 받고
		String strNo = req.getParameter("oriNo");
		int	   oriNo = Integer.parseInt(strNo);
		String	  pw = req.getParameter("pw");
		
		//로직수행
		ReBoardDAO dao = new ReBoardDAO();
		int change = dao.deleteBoard(oriNo, pw);
		dao.close();
		
		//모델
		req.setAttribute("CHANGE", change);
		
		//뷰
		return "../VIEW/ReBoard/BoardDelete.jsp";
	}

}




