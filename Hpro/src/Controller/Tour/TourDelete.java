package Controller.Tour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.TourDAO;

public class TourDelete implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//����
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			System.out.println("���ڵ�����="+e);
		}
		//�Ķ����
		String strNo = req.getParameter("tNo");
		int tNo = Integer.parseInt(strNo);
		//����Ͻ�����
		TourDAO dao = new TourDAO();
		int change = dao.deleteInfo(tNo);
		dao.close();
		//��
		req.setAttribute("CHANGE", change);
		//��
		return "../VIEW/Tour/TourDelete.jsp";
	}

}
