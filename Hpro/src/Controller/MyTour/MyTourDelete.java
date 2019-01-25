package Controller.MyTour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.MyTourDAO;

public class MyTourDelete implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String np=req.getParameter("np");
		String strMNo=req.getParameter("mNo");
		int mNo = Integer.parseInt(strMNo);
		String strMtNo=req.getParameter("mtNo");
		int mtNo = Integer.parseInt(strMtNo);
		//������� �������� �˾Ƴ���(�Ķ���͹ޱ�)
		String strPage=req.getParameter("nowPage");
		int nowPage=0;
		if(strPage==null || strPage.length()==0) {
			//�Ķ���Ͱ� ���� ��� ->�ʱ������� 1�� ����
			nowPage=1;
			
		}else {
			nowPage = Integer.parseInt(strPage);
		}
		
		//����Ͻ����� ����
		MyTourDAO dao = new MyTourDAO();
		int change=dao.deleteMyTourList(mtNo, mNo);
		dao.close();
		
		//��
		req.setAttribute("nowPage", nowPage);
		req.setAttribute("np", np);
		req.setAttribute("MNO", mNo);
		req.setAttribute("CHANGE", change); //���� Ȯ���� ���� �Ķ����
		//��
		return "../VIEW/MyTour/myTourDelete.jsp";
	}

}
