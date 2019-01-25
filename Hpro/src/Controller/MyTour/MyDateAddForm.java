package Controller.MyTour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;

public class MyDateAddForm implements TourSuperController {

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
		String title = req.getParameter("title"); //여행이름
		System.out.println("nowPage="+nowPage);
		System.out.println("title="+title);
		
		//모델
		req.setAttribute("STRTNO",strTNo);//뷰단에서 사용하기 위한 변수 - 무엇을 보여줄 지, 보내줄지 확인용ㅍ
		req.setAttribute("MNO",mNo);
		req.setAttribute("nowPage",nowPage);
		req.setAttribute("TITLE", title);
		
		//뷰
		return "../VIEW/MyTour/myDateAddForm.jsp";
	}

}
