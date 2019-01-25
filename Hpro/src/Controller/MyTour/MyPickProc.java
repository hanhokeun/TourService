package Controller.MyTour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.MyTourDAO;

public class MyPickProc implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//파라미터받기
		String strTNo=req.getParameter("tNo");//여행지번호
		int tNo = Integer.parseInt(strTNo);
		String strMNo=req.getParameter("mNo"); //회원번호
		int mNo=Integer.parseInt(strMNo);
		String strmtNo = req.getParameter("mtNo"); //여행번호
		int mtNo = Integer.parseInt(strmtNo);
		//확인용
		String mtName = req.getParameter("mtName"); //여행이름
		String nowPage = req.getParameter("nowPage"); 
		//비즈니스로직
		MyTourDAO dao = new MyTourDAO();
		int change=dao.insertMyPick(mtNo,tNo,mNo,mtName);
		dao.close();

		//모델 다시 그 관광지 페이지로 넘겨주기 위해
		req.setAttribute("TNO", tNo);
		req.setAttribute("MNO", mNo);
		req.setAttribute("nowPage", nowPage);
		//저장된 여부의 확인을 위해
		req.setAttribute("CHANGE", change);
		//확인용
		req.setAttribute("TNO", tNo);
		req.setAttribute("MTNO", mtNo);
		
		//뷰
		return "../VIEW/MyTour/myPickProc.jsp";
	}

}
