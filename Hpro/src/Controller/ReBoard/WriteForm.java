package Controller.ReBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Controller.TourSuperController;

//글쓰기 요청 컨트롤러
public class WriteForm implements TourSuperController{

	@Override
	public String execute(HttpServletRequest req, 
			HttpServletResponse resp) {
		System.out.println("WriteForm컨트롤러");
		//할일
		// 세션을 이용해서 로그인이 되어있는지 확인하고
		HttpSession session= req.getSession();
		//강제로 로그인 한 것으로 가정하고..
		String mId=(String) session.getAttribute("mId");
		
		//로그인 전이라면 
		if(mId==null || mId.length()==0) {
			//로그인안되었으니 글쓰기 폼대신에 로그인폼을 보여준다
			return "../Member/LoginForm.jsp";
		}
		else {
			//모델
			//뷰
			//로그인 된 유저만 글쓰기 폼보여주자
			return "../VIEW/ReBoard/WriteForm.jsp";		
		}
		
		
	}

}











