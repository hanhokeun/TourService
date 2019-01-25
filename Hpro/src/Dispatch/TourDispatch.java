package Dispatch; 

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Controller.TourSuperController;

@WebServlet("*.han")
public class TourDispatch extends HttpServlet {

	private static final long serialVersionUID=1L;
	
	private HashMap map = new HashMap();
	
	public TourDispatch() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("TourDispatchŬ������ doPost()");
		this.doGet(req, resp);
	}

	public void init(ServletConfig config) throws ServletException{
		
		Properties prop = new Properties();
		
		try {
			FileInputStream fin 
				= new FileInputStream("E:\\JSPWorkspace\\Hpro\\src\\Dispatch\\TourDispatch.properties");
			prop.load(fin);
			Set set = prop.keySet();
			
			Iterator iter = set.iterator();
			while(iter.hasNext()) {
				String key = (String)iter.next();
				String value = (String)prop.getProperty(key);
				try{
					Class c = Class.forName(value);
					TourSuperController temp = (TourSuperController)c.newInstance();
					map.put(key, temp);
				}catch(Exception e) {
					System.out.println("���� Ŭ���� ��ȯ ����="+e);
				}
			}
		} catch (Exception e) {
			System.out.println("properties ���� �ҷ����̱� ����="+e);
		}
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String reqPath = req.getServletPath();
		System.out.println("��û="+reqPath);
		
		if(map.containsKey(reqPath)) {
			TourSuperController controller = (TourSuperController)map.get(reqPath);
			
			String view = controller.execute(req, resp);
			try{
				RequestDispatcher rd = req.getRequestDispatcher(view);
				rd.forward(req, resp);
			}catch(Exception e) {
				System.out.println("�� ȣ�� ����="+e);				
			}
			
		}else {
			//��û ���뿡 �غ�� ��Ʈ�ѷ� ���� ��� ������ ���������� ����
			//response.sendRedirect("����������")
		}
	}
}
