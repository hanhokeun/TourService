package Controller.Member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Controller.TourSuperController;
import DAO.MemberDAO;
import VO.MemberVO;


public class LoginProc implements TourSuperController  {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
			System.out.println("LoginProc컨트롤러");
			//할일		
		
			// 파라미터값 받기		
			
			//로그인 화면에서 입력된 아이디와 비밀번호를 가져온다.
			String id = req.getParameter("id"); 
			System.out.println("id="+id);
			String pw = req.getParameter("pw");			
			System.out.println("pw="+pw);
			
			// 로직수행. DB에서 아이디.비밀번호 확인
			MemberDAO dao = new MemberDAO();
			//int result =dao.LoginCheck(id, pw);
			MemberVO vo = new MemberVO();
			vo=dao.LoginCheck(id, pw);
			String viewPage="";	
			dao.close();
			
			//로그인 성공
			if(vo.getChange()==1){
				HttpSession session = req.getSession();
				System.out.println("id="+id);
		        session.setAttribute("mId", id);	//아이디 세션에 넣어주기
		        session.setAttribute("mNo", vo.getNo()); //회원번호 넣어주기
		        session.setAttribute("grade", vo.getGrade()); //회원 등급받기
				viewPage="../VIEW/Member/LoginProc.jsp";
				}
			//비번불일치
			else if(vo.getChange()==0) {
				 req.setAttribute("CHANGE",vo.getChange());
				 viewPage="../VIEW/Member/LoginForm1.jsp";
				}
			//존재하지 않는 아이디	
			else{
				System.out.println("result=");
				req.setAttribute("CHANGE",vo.getChange());
				viewPage="../VIEW/Member/LoginForm1.jsp";
				}
			 return viewPage;
	}
}

