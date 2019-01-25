package Controller.Tour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TourSuperController;
import DAO.TourDAO;

public class TourModifyProc implements TourSuperController{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//할일
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			System.out.println("인코딩에러="+e);
		}
		//파라미터
		String name = req.getParameter("mtName");
		String area = req.getParameter("mlName");
		String addr1 = req.getParameter("addr");
		String addr2 = req.getParameter("maddr2");
		String addr = addr1+addr2;
		String theme1 = req.getParameter("mtheme");
		String img1 = req.getParameter("mimg1");
		String img2 = req.getParameter("mimg2");
		String img3 = req.getParameter("mimg3");
		String img4 = req.getParameter("mimg4");
		String tcon = req.getParameter("mtcon");
		String strx = req.getParameter("mx");
		double x = Double.parseDouble(strx);
		String stry = req.getParameter("my");
		double y = Double.parseDouble(stry);
		String nowPage = req.getParameter("nowPage");
		String strNo = req.getParameter("tNo");
		int tNo = Integer.parseInt(strNo);
		//비즈니스로직
		TourDAO dao = new TourDAO();
		dao.updateInfo(name,area,addr,theme1,img1,img2,img3,img4,tcon,x,y,tNo);
		
		//모델
		req.setAttribute("nowPage",nowPage);
		req.setAttribute("tNo",tNo);
		//뷰
		return "../VIEW/Tour/TourModifyProc.jsp";
	}

}
