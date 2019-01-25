package Controller.MyTour;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.MyTourDAO;

public class MyListAddProc implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//�Ķ���͹ޱ�
		String strTNo=req.getParameter("tNo");//��������ȣ
		if(req.getParameter("tNO") != null) {
			int tNo = Integer.parseInt(strTNo);		
			req.setAttribute("TNO",tNo);
		}
		String strMNo=req.getParameter("mNo"); //ȸ����ȣ
		int mNo=Integer.parseInt(strMNo);
		String nowPage=req.getParameter("nowPage");//�����̿�
		String title=req.getParameter("title");//�����̸�
		
		/*//�������ڱ��� �����ϰ� �� �ڿ� �����Ϸ����ֱ�
		MyTourDAO dao = new MyTourDAO();
		System.out.println("DAO�����Ϸ�");
		dao.insertTourList(tNo, mNo, title); //�Ŀ� ȸ�� ��ȣ�� �Ű������� ���
		dao.close();*/
		
		//��
		req.setAttribute("TITLE",title );
		req.setAttribute("STRTNO",strTNo);//��ܿ��� ����ϱ� ���� ���� - ������ ������ ��, �������� Ȯ�ο�
		req.setAttribute("MNO",mNo);
		req.setAttribute("nowPage",nowPage);
		
		return "../VIEW/MyTour/myListAddProc.jsp";
	}

}
