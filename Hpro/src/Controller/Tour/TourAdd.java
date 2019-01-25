package Controller.Tour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.TourSuperController;

public class TourAdd implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//할일
		//회원의 등급을 확인하고 관리자일때만 표시
		/*HttpSession session = req.getSession();
		session.setAttribute("m_Grade","9");
		//회원등급
		String ugrade = (String)session.getAttribute("m_Grade");
		if(ugrade=="9") {
			
		}
		else {
			return "../Tour/TourSearch.han";
		}*/
				
		//비즈니스로직
		//모델
		//뷰
		return "../VIEW/Tour/TourAdd.jsp";
	}

}
