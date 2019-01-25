package Controller.ReBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.ReBoardDAO;

public class ReplyDelete implements TourSuperController{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//�Ķ���� �ް�
		String  strNo=req.getParameter("oriNo");
		int		oriNo=Integer.parseInt(strNo);
		String  pw=req.getParameter("pw");
		String  strReNo=req.getParameter("reNo");
		int		reNo = Integer.parseInt(strReNo);
		String  nowPage=req.getParameter("nowPage");
		
		// ��������
		ReBoardDAO dao = new ReBoardDAO();
		int change = dao.deleteReply(reNo,pw);
		dao.close();
		
		// ��
		req.setAttribute("CHANGE",change); //�������ν�����
		req.setAttribute("oriNo", oriNo);
		req.setAttribute("nowPage", nowPage);
		
		// ��
		return "/VIEW/ReBoard/ReplyDelete.jsp";
	}

}






