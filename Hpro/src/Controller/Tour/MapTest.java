package Controller.Tour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;

public class MapTest implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//할일
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			System.out.println("인코딩에러="+e);
		}
		//파라미터받고
		
		String strx = req.getParameter("x");
		double x = Double.parseDouble(strx);
		System.out.println("위도="+x);
		String stry = req.getParameter("y");
		double y = Double.parseDouble(stry);
		System.out.println("경도="+y);
		String nowPage = req.getParameter("nowPage");
		//비즈니스로직
		//모델
		req.setAttribute("X", x);
		req.setAttribute("Y", y);
		req.setAttribute("nowPage", nowPage);
		//뷰
		return "../VIEW/Map/MapTest.jsp";
	}

}
