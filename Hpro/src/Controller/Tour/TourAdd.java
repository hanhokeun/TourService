package Controller.Tour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.TourSuperController;

public class TourAdd implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//����
		//ȸ���� ����� Ȯ���ϰ� �������϶��� ǥ��
		/*HttpSession session = req.getSession();
		session.setAttribute("m_Grade","9");
		//ȸ�����
		String ugrade = (String)session.getAttribute("m_Grade");
		if(ugrade=="9") {
			
		}
		else {
			return "../Tour/TourSearch.han";
		}*/
				
		//����Ͻ�����
		//��
		//��
		return "../VIEW/Tour/TourAdd.jsp";
	}

}
