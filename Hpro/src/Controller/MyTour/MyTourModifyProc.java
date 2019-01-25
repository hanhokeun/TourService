package Controller.MyTour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.MyTourDAO;

public class MyTourModifyProc implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//�Ķ���͹ޱ�
		String np =req.getParameter("np"); //�󼼺��� �������� ���� �����̿�
		String strMNo=req.getParameter("mNo");
		int mNo = Integer.parseInt(strMNo);
		String strMtNo=req.getParameter("mtNo");
		int mtNo = Integer.parseInt(strMtNo);
		String name = req.getParameter("title");
		String start = req.getParameter("startDate");
		String end = req.getParameter("endDate");
		String nowPage = req.getParameter("nowPage"); //���ฮ��Ʈ �������� ���� �����̿�
		//����Ͻ����� ����
		MyTourDAO dao = new MyTourDAO();
		int change=dao.updateMyTourNameDate(name,start,end,mtNo,mNo); //���� ����,�̸� �������θ� ���� change
		System.out.println("���� ����,�̸� �������θ� ���� change="+change);
		dao.close();
		
		MyTourDAO dao1 = new MyTourDAO();
		dao1.updateTourDetailStart(start,end,mtNo); //�������� ������ ���� �󼼿����� ���۳�¥ ����
		dao1.updateTourDetailEnd(end,start,mtNo); //�������� ������ ���� �󼼿����� ���ᳯ¥ ����
		dao1.close();
		
		//��
		req.setAttribute("nowPage", nowPage); //�����ฮ��Ʈ�� ���� �����̿�
		req.setAttribute("MNO", mNo); //�����̿�
		req.setAttribute("MTNO", mtNo); //�����̿�
		req.setAttribute("CHANGE", change); //�������θ� �˷��ֱ� ���� ��
		
		//��
		return "../VIEW/MyTour/myTourModifyProc.jsp";
	}

}
