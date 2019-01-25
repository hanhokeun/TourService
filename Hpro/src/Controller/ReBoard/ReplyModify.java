package Controller.ReBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.ReBoardDAO;

public class ReplyModify implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//할일
		// 파라미터 받고
		String strNo=req.getParameter("reNo");
		int    reNo=Integer.parseInt(strNo); //댓글번호
		String title=req.getParameter("title");//댓글제목
		String body=req.getParameter("body");//댓글내용
		String pw=req.getParameter("pw");//댓글비번
		String oriNo=req.getParameter("oriNo");//릴레이용
		String nowPage=req.getParameter("nowPage");//릴레이용
//		System.out.println("reNo ="+reNo);
//		System.out.println("pw ="+pw);
//		System.out.println("oriNo ="+oriNo);
//		System.out.println("nowPage ="+nowPage);
		
		// 로직수행.. DAO
		ReBoardDAO dao = new ReBoardDAO();
		dao.updateReply(reNo,title,body,pw);
		dao.close();
		
		// 모델
		req.setAttribute("oriNo", oriNo);
		req.setAttribute("nowPage", nowPage);
		
		// 뷰
		return "../VIEW/ReBoard/ReplyModify.jsp";
	}

}
