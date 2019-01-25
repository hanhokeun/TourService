package Controller.Tour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.TourDAO;

public class TourDelete implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//할일
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			System.out.println("인코딩에러="+e);
		}
		//파라미터
		String strNo = req.getParameter("tNo");
		int tNo = Integer.parseInt(strNo);
		//비즈니스로직
		TourDAO dao = new TourDAO();
		int change = dao.deleteInfo(tNo);
		dao.close();
		//모델
		req.setAttribute("CHANGE", change);
		//뷰
		return "../VIEW/Tour/TourDelete.jsp";
	}

}
