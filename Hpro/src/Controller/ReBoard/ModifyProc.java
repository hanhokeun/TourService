package Controller.ReBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.ReBoardDAO;

public class ModifyProc implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//����
		//�Ķ���� �ް�
		String nowPage = req.getParameter("nowPage");
		String  strNo = req.getParameter("oriNo");
		int     oriNo = Integer.parseInt(strNo);
		
		String title = req.getParameter("title");
		String body = req.getParameter("body");
		//String pw= req.getParameter("pw");
		
		//DAO�� ȣ��(����Ͻ���������)
		ReBoardDAO dao = new ReBoardDAO();
		dao.updateBoard(title,body,oriNo);
		
		//��
		req.setAttribute("oriNo", oriNo);
		req.setAttribute("nowPage", nowPage);
		
		//��
		return "../VIEW/ReBoard/ModifyProc.jsp";
	}

}





