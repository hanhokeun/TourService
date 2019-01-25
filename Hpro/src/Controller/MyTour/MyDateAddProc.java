package Controller.MyTour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.TourSuperController;
import DAO.MyTourDAO;

public class MyDateAddProc implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//파라미터받기
		String strTNo=req.getParameter("tNo");//여행지번호
		if(req.getParameter("tNO") != null) {
			int tNo = Integer.parseInt(strTNo);		
			req.setAttribute("TNO",tNo);
		}
		HttpSession session= req.getSession();
		int mNo=(int) session.getAttribute("mNo");
		String nowPage=req.getParameter("nowPage");//릴레이용
		String title=req.getParameter("title"); //여행이름
		
		String start = req.getParameter("startDate"); //시작날짜
		String end = req.getParameter("endDate"); //종료날짜
		
		MyTourDAO dao = new MyTourDAO();
		dao.insertTourList(mNo,title,start,end);
		dao.close();

		//모델
		req.setAttribute("STRTNO",strTNo); //뷰단에서 사용하기 위한 변수 - 무엇을 보여줄 지, 보내줄지 확인용
		req.setAttribute("MNO",mNo);
		req.setAttribute("nowPage",nowPage);
		req.setAttribute("TITLE",title);
		
		//뷰
		return "../VIEW/MyTour/myDateAddProc.jsp";
	}

}
