package Controller.ReBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Controller.TourSuperController;

//�۾��� ��û ��Ʈ�ѷ�
public class WriteForm implements TourSuperController{

	@Override
	public String execute(HttpServletRequest req, 
			HttpServletResponse resp) {
		System.out.println("WriteForm��Ʈ�ѷ�");
		//����
		// ������ �̿��ؼ� �α����� �Ǿ��ִ��� Ȯ���ϰ�
		HttpSession session= req.getSession();
		//������ �α��� �� ������ �����ϰ�..
		String mId=(String) session.getAttribute("mId");
		
		//�α��� ���̶�� 
		if(mId==null || mId.length()==0) {
			//�α��ξȵǾ����� �۾��� ����ſ� �α������� �����ش�
			return "../Member/LoginForm.jsp";
		}
		else {
			//��
			//��
			//�α��� �� ������ �۾��� ����������
			return "../VIEW/ReBoard/WriteForm.jsp";		
		}
		
		
	}

}











