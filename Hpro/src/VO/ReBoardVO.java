package VO;

import java.sql.Date;

public class ReBoardVO {
	
	private 	int		no;
	private int mNo;
	private 	String	writer;
	private 	String	title;
	private		String	wday;
	private 	int		cnt;
	private 	int		hit;
	private		String	body;
	private		String	pw;
	
	private		int		oriNo;
	
	public int getOriNo() {
		return oriNo;
	}
	public void setOriNo(int oriNo) {
		this.oriNo = oriNo;
	}
	
	public String getBrBody() {
		//�ٹٲ� ��ȣ�� <br/>�� �ٲپ �����ϴ� get�Լ�
		//JSTL�� ������ �ƴ� GET�Լ��� ����� �̿��ϹǷ�
		// ������ �ʿ��ϴٸ� �����͸� ���氡���Ͽ� ó���ϸ� �ȴ�.. �ʿ��ϸ� get�Լ����� ����ϼ���
		String temp = body;
		if(temp!=null && temp.length()!=0) {
			temp = temp.replaceAll("\r\n","<br/>");
		}
		return temp;
	}
	
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	
	public String getTitleTest() {
		return title.substring(0,10)+"...";
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWday() {
		return wday;
	}
	public void setWday(String wday) {
		this.wday = wday;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getmNo() {
		return mNo;
	}
	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
	
	
}
