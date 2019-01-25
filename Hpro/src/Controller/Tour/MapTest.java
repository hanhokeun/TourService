package Controller.Tour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;

public class MapTest implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//����
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			System.out.println("���ڵ�����="+e);
		}
		//�Ķ���͹ް�
		
		String strx = req.getParameter("x");
		double x = Double.parseDouble(strx);
		System.out.println("����="+x);
		String stry = req.getParameter("y");
		double y = Double.parseDouble(stry);
		System.out.println("�浵="+y);
		String nowPage = req.getParameter("nowPage");
		//����Ͻ�����
		//��
		req.setAttribute("X", x);
		req.setAttribute("Y", y);
		req.setAttribute("nowPage", nowPage);
		//��
		return "../VIEW/Map/MapTest.jsp";
	}

}
