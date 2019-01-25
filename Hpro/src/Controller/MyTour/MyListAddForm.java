package Controller.MyTour;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.TourSuperController;
import DAO.MyTourDAO;

public class MyListAddForm implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MyListAddForm 컨트롤러야");
		//파라미터받기
		String strTNo=req.getParameter("tNo");//여행지번호
		if(req.getParameter("tNO") != null) {
			int tNo = Integer.parseInt(strTNo);	
			String strMNo=req.getParameter("mNo"); //회원번호
			int mNo=Integer.parseInt(strMNo);
			String nowPage=req.getParameter("nowPage");//릴레이용
			//로그인이 되었다고 가정
			//HttpSession session = req.getSession();
			//session.setAttribute("m_Id", "han");
			
			req.setAttribute("TNO", tNo);
			req.setAttribute("STRTNO",strTNo);//뷰단에서 사용하기 위한 변수 - 무엇을 보여줄 지, 보내줄지 확인용
			req.setAttribute("MNO",mNo);
			req.setAttribute("nowPage",nowPage);   
		}else {
			String strMNo=req.getParameter("mNo"); //회원번호
			int mNo=Integer.parseInt(strMNo);
			String nowPage=req.getParameter("nowPage");//릴레이용
			//로그인이 되었다고 가정
			//HttpSession session = req.getSession();
			//session.setAttribute("m_Id", "han");
			
			req.setAttribute("STRTNO",strTNo);//뷰단에서 사용하기 위한 변수 - 무엇을 보여줄 지, 보내줄지 확인용
			req.setAttribute("MNO",mNo);
			req.setAttribute("nowPage",nowPage);   
		}
	
		return "../VIEW/MyTour/myListAddForm.jsp";
		
	}

}
