package Controller.MyTour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.MyTourDAO;

public class MyTourDelete implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String np=req.getParameter("np");
		String strMNo=req.getParameter("mNo");
		int mNo = Integer.parseInt(strMNo);
		String strMtNo=req.getParameter("mtNo");
		int mtNo = Integer.parseInt(strMtNo);
		//보고싶은 페이지를 알아낸다(파라미터받기)
		String strPage=req.getParameter("nowPage");
		int nowPage=0;
		if(strPage==null || strPage.length()==0) {
			//파라미터가 없는 경우 ->초기페이지 1로 설정
			nowPage=1;
			
		}else {
			nowPage = Integer.parseInt(strPage);
		}
		
		//비즈니스로직 수행
		MyTourDAO dao = new MyTourDAO();
		int change=dao.deleteMyTourList(mtNo, mNo);
		dao.close();
		
		//모델
		req.setAttribute("nowPage", nowPage);
		req.setAttribute("np", np);
		req.setAttribute("MNO", mNo);
		req.setAttribute("CHANGE", change); //삭제 확인을 위한 파라미터
		//뷰
		return "../VIEW/MyTour/myTourDelete.jsp";
	}

}
