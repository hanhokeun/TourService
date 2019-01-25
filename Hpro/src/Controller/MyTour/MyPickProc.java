package Controller.MyTour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.MyTourDAO;

public class MyPickProc implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//�Ķ���͹ޱ�
		String strTNo=req.getParameter("tNo");//��������ȣ
		int tNo = Integer.parseInt(strTNo);
		String strMNo=req.getParameter("mNo"); //ȸ����ȣ
		int mNo=Integer.parseInt(strMNo);
		String strmtNo = req.getParameter("mtNo"); //�����ȣ
		int mtNo = Integer.parseInt(strmtNo);
		//Ȯ�ο�
		String mtName = req.getParameter("mtName"); //�����̸�
		String nowPage = req.getParameter("nowPage"); 
		//����Ͻ�����
		MyTourDAO dao = new MyTourDAO();
		int change=dao.insertMyPick(mtNo,tNo,mNo,mtName);
		dao.close();

		//�� �ٽ� �� ������ �������� �Ѱ��ֱ� ����
		req.setAttribute("TNO", tNo);
		req.setAttribute("MNO", mNo);
		req.setAttribute("nowPage", nowPage);
		//����� ������ Ȯ���� ����
		req.setAttribute("CHANGE", change);
		//Ȯ�ο�
		req.setAttribute("TNO", tNo);
		req.setAttribute("MTNO", mtNo);
		
		//��
		return "../VIEW/MyTour/myPickProc.jsp";
	}

}
