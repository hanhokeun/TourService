package Controller.MyTour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.MyTourDAO;
import VO.MyTourVO;

public class MyDetailModifyForm implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//ÆÄ¶ó¹ÌÅÍ¹Þ±â
		String np=req.getParameter("np");
		String strMNo=req.getParameter("mNo");
		int mNo = Integer.parseInt(strMNo);
		String strMtNo=req.getParameter("mtNo");
		int mtNo = Integer.parseInt(strMtNo);
		String strTdNo=req.getParameter("tdNo");
		int tdNo = Integer.parseInt(strTdNo);
		String nowPage = req.getParameter("nowPage");
		
		MyTourDAO dao= new MyTourDAO();
		MyTourVO vo = dao.selectDetailNameDate(tdNo);
		
		//¸ðµ¨
		req.setAttribute("MNO", mNo);
		req.setAttribute("MTNO", mtNo);
		req.setAttribute("NP", np);
		req.setAttribute("VO", vo);
		req.setAttribute("nowPage", nowPage);
		//ºä
		return "../VIEW/MyTour/myDetailModifyForm.jsp";
	}

}
