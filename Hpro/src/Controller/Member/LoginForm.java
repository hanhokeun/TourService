package Controller.Member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;

public class LoginForm implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp){
		
		//로그인 폼을 보여주기 위한 컨트롤러
		
		//뷰
		return "../VIEW/Member/LoginForm.jsp";
	}

}
