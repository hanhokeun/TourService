package Controller.MyTour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.MyTourDAO;

public class MyDetailDelete implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//파라미터받기
		String np=req.getParameter("np");
		String strMNo=req.getParameter("mNo");
		int mNo = Integer.parseInt(strMNo);
		String strMtNo=req.getParameter("mtNo");
		int mtNo = Integer.parseInt(strMtNo);
		String strTdNo=req.getParameter("tdNo");
		System.out.println("np="+np);
		System.out.println("mNo="+mNo);
		System.out.println("MtNo="+mtNo);
		System.out.println("td="+strTdNo);
		int tdNo = Integer.parseInt(strTdNo);
		String nowPage=req.getParameter("nowPage");
		
		//비즈니스로직 
		MyTourDAO dao = new MyTourDAO();
		dao.deleteMyTourDetail(mtNo, tdNo);
		dao.close();
		
		//모델
		req.setAttribute("MTNO", mtNo);
		req.setAttribute("MNO", mNo);
		req.setAttribute("nowPage", nowPage); //여행리스트의 릴레이용
		//req.setAttribute("NP", np); //상세 여행지 보기의 릴레이용
		
		//뷰
		return "../VIEW/MyTour/myDetailDelete.jsp";
	}

}
