package Controller.ReBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.ReBoardDAO;

public class BoardDelete implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//����
		//�Ķ���� �ް�
		String strNo = req.getParameter("oriNo");
		int	   oriNo = Integer.parseInt(strNo);
		String	  pw = req.getParameter("pw");
		
		//��������
		ReBoardDAO dao = new ReBoardDAO();
		int change = dao.deleteBoard(oriNo, pw);
		dao.close();
		
		//��
		req.setAttribute("CHANGE", change);
		
		//��
		return "../VIEW/ReBoard/BoardDelete.jsp";
	}

}




