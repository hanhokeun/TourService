package Controller.ReBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.TourSuperController;
import DAO.ReBoardDAO;

public class ReplyWrite implements TourSuperController {
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//	파라메터 받기
		String	title = req.getParameter("title");
		String	body = req.getParameter("body");
		String	pw = req.getParameter("pw");
		String	strNo = req.getParameter("oriNo");
		int		oriNo = Integer.parseInt(strNo);
		String	nowPage = req.getParameter("nowPage");
		
		//	데이터베이스에 기록하기 위해서는 반드시 필요한 정보가 다 준비되어야 한다.
		//	편법 강제로 로그인한 것으로 간주.
		HttpSession	session = req.getSession();
		int mNo=(int) session.getAttribute("mNo");
		String	writer = (String) session.getAttribute("mId");
		
		ReBoardDAO	dao = new ReBoardDAO();	
		dao.insertReply(oriNo, mNo, title, body, pw);
		dao.close();
		
		//모델
		req.setAttribute("oriNo", oriNo);
		req.setAttribute("nowPage", nowPage);
		
		//뷰
		return "../VIEW/ReBoard/ReplyWrite.jsp";
	}
}



