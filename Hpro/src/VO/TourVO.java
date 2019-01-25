package VO;


//관광지 정보 조회 VO
public class TourVO {
	private int no;
	private String name;
	private String addr;
	private String con;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	private String theme1;
	private String theme2;
	private String theme3;
	private double x;
	private double y;
	private String area;
	private int cnt;
	private int tNo;
	private int tot;
	private double ty;
	
	

	
	
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getTy() {
		return ty;
	}
	public void setTy(double ty) {
		this.ty = ty;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public int gettNo() {
		return tNo;
	}
	public void settNo(int tNo) {
		this.tNo = tNo;
	}
	public String getTheme2() {
		return theme2;
	}
	public void setTheme2(String theme2) {
		this.theme2 = theme2;
	}
	public String getTheme3() {
		return theme3;
	}
	public void setTheme3(String theme3) {
		this.theme3 = theme3;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getBrCon() {
		String temp=con;
		if(temp!=null && temp.length()!=0) {
			temp = temp.replaceAll("\n","<br/>");
		}
		return con;
	}
	public String getCon() {
		return con;
	}
	public void setCon(String con) {
		this.con = con;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public String getImg4() {
		return img4;
	}
	public void setImg4(String img4) {
		this.img4 = img4;
	}
	public String getTheme1() {
		return theme1;
	}
	public void setTheme1(String theme1) {
		this.theme1 = theme1;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
}
