package Controller.Member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;

public class LoginForm implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp){
		
		//�α��� ���� �����ֱ� ���� ��Ʈ�ѷ�
		
		//��
		return "../VIEW/Member/LoginForm.jsp";
	}

}
