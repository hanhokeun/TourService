package Controller.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;

public class MemberJoinForm implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		//����		
		
		//ȸ������ ����ڰ� �Էµ� �Ķ���Ͱ� �ޱ�		        
		
		//����Ͻ� ���� ����
			
		//��
			return "../VIEW/Member/MemberJoinForm.jsp";
	}

}
