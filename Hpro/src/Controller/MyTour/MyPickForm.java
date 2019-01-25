package Controller.MyTour;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.TourSuperController;
import DAO.MyTourDAO;
import Util.PageUtil;
import VO.MyTourVO;

public class MyPickForm implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MyPickForm컨트롤러");
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			System.out.println("인코딩에러="+e);
		}
		//세션에 로그인이 되어있다고 가정하자
		HttpSession session = req.getSession();
		int mNo=0;
		String strNo= req.getParameter("tNo"); //관광지 번호 받기
		int tNo = Integer.parseInt(strNo);
		
		//로그인이 안된 경우
		if(session.getAttribute("mNo")==null) {
			mNo =0;
		}else {
			mNo=(int)session.getAttribute("mNo");			
			
			String strPage = req.getParameter("nowPage");
			int nowPage=0;
			if(strPage==null|| strPage.length()==0) {
				//파라미터가 없는 경우는 초기페이지를 1로 보여줌
				nowPage=1;
			}else {
				nowPage= Integer.parseInt(strPage);
			}
			
			
			MyTourDAO dao = new MyTourDAO();
			System.out.println("DAO생성완료");
			//페이지정보 만들기
			int totalCount = dao.selectMyListTotalCount(mNo);
			PageUtil pinfo = new PageUtil(nowPage,totalCount,3,5); //페이징 처리하기 위한 변수
			
			ArrayList list= dao.selectMyTour(mNo,pinfo); //후에 회원 번호를 매개변수로 사용
			dao.close();
			
			//모델
			req.setAttribute("MyTour", list); //내여행목록을 보여주기 위한 리스트
			req.setAttribute("PINFO", pinfo); //페이징 처리를 위한  정보
		}
		req.setAttribute("TNO", tNo); 
		req.setAttribute("MNO", mNo); //로그인확인을 위한 회원번호
		//뷰
		return "../VIEW/MyTour/myPickForm.jsp";
	}

}
