package Controller.ReBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.ReBoardDAO;

public class ReplyDelete implements TourSuperController{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//파라미터 받고
		String  strNo=req.getParameter("oriNo");
		int		oriNo=Integer.parseInt(strNo);
		String  pw=req.getParameter("pw");
		String  strReNo=req.getParameter("reNo");
		int		reNo = Integer.parseInt(strReNo);
		String  nowPage=req.getParameter("nowPage");
		
		// 로직수행
		ReBoardDAO dao = new ReBoardDAO();
		int change = dao.deleteReply(reNo,pw);
		dao.close();
		
		// 모델
		req.setAttribute("CHANGE",change); //삭제여부실행결과
		req.setAttribute("oriNo", oriNo);
		req.setAttribute("nowPage", nowPage);
		
		// 뷰
		return "/VIEW/ReBoard/ReplyDelete.jsp";
	}

}






