package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//게시물들의 컨트롤러의 상위역할을 할 슈퍼컨트롤러
public interface TourSuperController {

	public String execute(HttpServletRequest req, HttpServletResponse resp);
}
