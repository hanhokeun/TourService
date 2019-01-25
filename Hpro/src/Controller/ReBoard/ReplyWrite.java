package Controller.ReBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.TourSuperController;
import DAO.ReBoardDAO;

public class ReplyWrite implements TourSuperController {
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//	�Ķ���� �ޱ�
		String	title = req.getParameter("title");
		String	body = req.getParameter("body");
		String	pw = req.getParameter("pw");
		String	strNo = req.getParameter("oriNo");
		int		oriNo = Integer.parseInt(strNo);
		String	nowPage = req.getParameter("nowPage");
		
		//	�����ͺ��̽��� ����ϱ� ���ؼ��� �ݵ�� �ʿ��� ������ �� �غ�Ǿ�� �Ѵ�.
		//	��� ������ �α����� ������ ����.
		HttpSession	session = req.getSession();
		int mNo=(int) session.getAttribute("mNo");
		String	writer = (String) session.getAttribute("mId");
		
		ReBoardDAO	dao = new ReBoardDAO();	
		dao.insertReply(oriNo, mNo, title, body, pw);
		dao.close();
		
		//��
		req.setAttribute("oriNo", oriNo);
		req.setAttribute("nowPage", nowPage);
		
		//��
		return "../VIEW/ReBoard/ReplyWrite.jsp";
	}
}



