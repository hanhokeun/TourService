package Controller.ReBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Controller.TourSuperController;
import DAO.ReBoardDAO;
import VO.ReBoardVO;

// 수정을 하기위해 (db에서 해당글번호의 내용을 가지고 온) 수정 폼을 제공할 컨트롤러
public class ModifyForm implements TourSuperController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("ModifyForm컨트롤러");
		//할일
		//파라미터받기
		String strNo = req.getParameter("oriNo");
		int	   oriNo = Integer.parseInt(strNo);
		System.out.println("oriNo="+oriNo);
		String	nowPage = req.getParameter("nowPage");	//릴레이용
		
		//비즈니스로직 수행..db에서 해당글번호의 내용select
		ReBoardDAO dao = new ReBoardDAO();
		ReBoardVO vo = dao.selectDetail(oriNo);
		dao.close();
		
		//모델
		req.setAttribute("BOARD", vo);
		req.setAttribute("nowPage", nowPage);
		
		//뷰
		return "../VIEW/ReBoard/ModifyForm.jsp";
	}

}







