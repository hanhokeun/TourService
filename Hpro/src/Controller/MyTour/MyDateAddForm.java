package Controller.MyTour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;

public class MyDateAddForm implements TourSuperController {

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
		String title = req.getParameter("title"); //�����̸�
		System.out.println("nowPage="+nowPage);
		System.out.println("title="+title);
		
		//��
		req.setAttribute("STRTNO",strTNo);//��ܿ��� ����ϱ� ���� ���� - ������ ������ ��, �������� Ȯ�ο뤽
		req.setAttribute("MNO",mNo);
		req.setAttribute("nowPage",nowPage);
		req.setAttribute("TITLE", title);
		
		//��
		return "../VIEW/MyTour/myDateAddForm.jsp";
	}

}
