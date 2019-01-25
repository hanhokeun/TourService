package VO;

import java.sql.Date;

/*VO클래스는 Value Object로 데이터만 보관하기 위한 클래스
그러므로 이 클래스는
1. 데이터를 기억할 변수
2. 변수를 조작할 setXXX 이 필요, 데이터를 가져가라 할 getXXX함수가 준비되어야 한다.

getXXX함수 : JSTL에서 데이터를 사용ㅎㄹ 목적으로 만들어야 한다.
*/

public class MemberVO {

	private int no;
	private String id;
	private String pw;
	private String name;
	private String birth;	
	private String email;
	private Date bam;
	private int grade;
	private String phone;
	private char isshow;
	private int  cnt;
	private int change;
	
	
	public char getIsshow() {
		return isshow;
	}
	public void setIsshow(char isshow) {
		this.isshow = isshow;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public Date getBam() {
		return bam;
	}
	public void setBam(Date bam) {
		this.bam = bam;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getChange() {
		return change;
	}
	public void setChange(int change) {
		this.change = change;
	}
	
	
	
	
	
}
