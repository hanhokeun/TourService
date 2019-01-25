package Controller.MyTour;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.MyTourDAO;

public class MyListAddProc implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//파라미터받기
		String strTNo=req.getParameter("tNo");//여행지번호
		if(req.getParameter("tNO") != null) {
			int tNo = Integer.parseInt(strTNo);		
			req.setAttribute("TNO",tNo);
		}
		String strMNo=req.getParameter("mNo"); //회원번호
		int mNo=Integer.parseInt(strMNo);
		String nowPage=req.getParameter("nowPage");//릴레이용
		String title=req.getParameter("title");//여행이름
		
		/*//여행일자까지 설정하고 난 뒤에 설정완료해주기
		MyTourDAO dao = new MyTourDAO();
		System.out.println("DAO생성완료");
		dao.insertTourList(tNo, mNo, title); //후에 회원 번호를 매개변수로 사용
		dao.close();*/
		
		//뷰
		req.setAttribute("TITLE",title );
		req.setAttribute("STRTNO",strTNo);//뷰단에서 사용하기 위한 변수 - 무엇을 보여줄 지, 보내줄지 확인용
		req.setAttribute("MNO",mNo);
		req.setAttribute("nowPage",nowPage);
		
		return "../VIEW/MyTour/myListAddProc.jsp";
	}

}
