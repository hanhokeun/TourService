package Controller.MyTour;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.TourSuperController;
import DAO.MyTourDAO;

public class MyListAddForm implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MyListAddForm ��Ʈ�ѷ���");
		//�Ķ���͹ޱ�
		String strTNo=req.getParameter("tNo");//��������ȣ
		if(req.getParameter("tNO") != null) {
			int tNo = Integer.parseInt(strTNo);	
			String strMNo=req.getParameter("mNo"); //ȸ����ȣ
			int mNo=Integer.parseInt(strMNo);
			String nowPage=req.getParameter("nowPage");//�����̿�
			//�α����� �Ǿ��ٰ� ����
			//HttpSession session = req.getSession();
			//session.setAttribute("m_Id", "han");
			
			req.setAttribute("TNO", tNo);
			req.setAttribute("STRTNO",strTNo);//��ܿ��� ����ϱ� ���� ���� - ������ ������ ��, �������� Ȯ�ο�
			req.setAttribute("MNO",mNo);
			req.setAttribute("nowPage",nowPage);   
		}else {
			String strMNo=req.getParameter("mNo"); //ȸ����ȣ
			int mNo=Integer.parseInt(strMNo);
			String nowPage=req.getParameter("nowPage");//�����̿�
			//�α����� �Ǿ��ٰ� ����
			//HttpSession session = req.getSession();
			//session.setAttribute("m_Id", "han");
			
			req.setAttribute("STRTNO",strTNo);//��ܿ��� ����ϱ� ���� ���� - ������ ������ ��, �������� Ȯ�ο�
			req.setAttribute("MNO",mNo);
			req.setAttribute("nowPage",nowPage);   
		}
	
		return "../VIEW/MyTour/myListAddForm.jsp";
		
	}

}
