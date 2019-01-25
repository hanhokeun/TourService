package Controller.Tour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.TourDAO;
import VO.TourVO;

public class TourModify implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//할일
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			System.out.println("인코딩에러="+e);
		}
		//파라미터
		String nowPage = req.getParameter("nowPage");
		String strNo = req.getParameter("tNo");
		int  tno = Integer.parseInt(strNo);
		
		//비즈니스로직
		//수정하기전에 해당글의 번호를 select 한다
		TourDAO dao = new TourDAO();
		TourVO vo = dao.SelectDetail(tno);
		//모델
		req.setAttribute("VIEW2", vo);
		req.setAttribute("nowPage",nowPage);
		//뷰
		return "../VIEW/Tour/TourModify.jsp";
	}

}
