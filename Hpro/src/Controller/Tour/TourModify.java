package Controller.Tour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.TourDAO;
import VO.TourVO;

public class TourModify implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//����
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			System.out.println("���ڵ�����="+e);
		}
		//�Ķ����
		String nowPage = req.getParameter("nowPage");
		String strNo = req.getParameter("tNo");
		int  tno = Integer.parseInt(strNo);
		
		//����Ͻ�����
		//�����ϱ����� �ش���� ��ȣ�� select �Ѵ�
		TourDAO dao = new TourDAO();
		TourVO vo = dao.SelectDetail(tno);
		//��
		req.setAttribute("VIEW2", vo);
		req.setAttribute("nowPage",nowPage);
		//��
		return "../VIEW/Tour/TourModify.jsp";
	}

}
