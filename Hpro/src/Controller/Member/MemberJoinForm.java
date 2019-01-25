package Controller.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;

public class MemberJoinForm implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		//할일		
		
		//회원가입 사용자가 입력된 파라미터값 받기		        
		
		//비즈니스 로직 수행
			
		//뷰
			return "../VIEW/Member/MemberJoinForm.jsp";
	}

}
