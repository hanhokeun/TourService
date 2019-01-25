package Controller.MyTour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.TourSuperController;
import DAO.MyTourDAO;

public class MyDateAddProc implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//�Ķ���͹ޱ�
		String strTNo=req.getParameter("tNo");//��������ȣ
		if(req.getParameter("tNO") != null) {
			int tNo = Integer.parseInt(strTNo);		
			req.setAttribute("TNO",tNo);
		}
		HttpSession session= req.getSession();
		int mNo=(int) session.getAttribute("mNo");
		String nowPage=req.getParameter("nowPage");//�����̿�
		String title=req.getParameter("title"); //�����̸�
		
		String start = req.getParameter("startDate"); //���۳�¥
		String end = req.getParameter("endDate"); //���ᳯ¥
		
		MyTourDAO dao = new MyTourDAO();
		dao.insertTourList(mNo,title,start,end);
		dao.close();

		//��
		req.setAttribute("STRTNO",strTNo); //��ܿ��� ����ϱ� ���� ���� - ������ ������ ��, �������� Ȯ�ο�
		req.setAttribute("MNO",mNo);
		req.setAttribute("nowPage",nowPage);
		req.setAttribute("TITLE",title);
		
		//��
		return "../VIEW/MyTour/myDateAddProc.jsp";
	}

}
