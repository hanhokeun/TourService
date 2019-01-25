package DAO;

import java.sql.*;
import java.util.*;

import Sql.MyTourSql;
import Util.POOLUtil;
import Util.PageUtil;
import VO.MyTourVO;

public class MyTourDAO {

	//private static final String Integer = null;
	private POOLUtil db;
	private Connection con;
	public MyTourDAO() {
		db= new POOLUtil();
		con = db.getCon();
	}
	//�� ���� ���� �����ϱ�
	public void updateMyTourDetail(String start, String end, int tdNo) {
		String sql = MyTourSql.getSQL(MyTourSql.UPDATE_DETAILDATE);
		System.out.println("�� ������ ���� �����ϱ� sql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		try {
			stmt.setString(1, start);
			stmt.setString(2, end);
			stmt.setInt(3, tdNo);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("�� ������ ���� ���� ���ǹ� ���� ����="+e);
		}
		db.close(stmt);
	}
	//�� ������ �����ϱ�
	public void deleteMyTourDetail(int mtNo, int tdNo) {
		String sql = MyTourSql.getSQL(MyTourSql.DELETE_MYTOURDETAIL);
		System.out.println("�� ������ �����ϱ� sql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		try {
			stmt.setInt(1, mtNo);
			stmt.setInt(2, tdNo);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("�� ������ �����ϱ� ���ǹ� ���� ����="+e);
		}
		db.close(stmt);
	}
	//�� ���� �����ϱ�
	public int deleteMyTourList(int mtNo, int mNo) {
		String sql = MyTourSql.getSQL(MyTourSql.DELETE_MYTOURLIST);
		System.out.println("�� ���� �����ϱ� sql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		int change=0;
		try {
			stmt.setInt(1,mtNo);
			stmt.setInt(2,mNo);
			change=stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("�� ���� �����ϱ� ���ǹ� ���� ����="+e);
		}
		db.close(stmt);
		return change;
	}
	//�� �������� ���� �˻�
	public MyTourVO selectDetailNameDate(int tdNo) {
		String sql = MyTourSql.getSQL(MyTourSql.SELECT_DETAILNANEDATE);
		System.out.println("�� �������� �̸��� ��¥ ��ȸ sql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		MyTourVO vo = new MyTourVO();
		try {
			stmt.setInt(1, tdNo);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			vo.setTdNo(tdNo);
			vo.setName(rs.getString("name"));
			vo.setStart(rs.getString("tdstart"));
			vo.setEnd(rs.getString("tdend"));
			db.close(rs);
		} catch (Exception e) {
			System.out.println("�� �������� �̸��� ��¥ ��ȸ ���ǹ� ���� ����="+e);
		}
		db.close(stmt);
		return vo; 
	}
	//�� ������ �̸��� ��¥ ���� �Լ�
	public int updateMyTourNameDate(String name, String start, String end,int mtNo, int mNo) {
		String sql = MyTourSql.getSQL(MyTourSql.UPDATE_MYTOURNAMEDATE);
		System.out.println("�ش� ������ �̸��� ��¥ ���� sql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		int change=0;
		try {
			stmt.setString(1, name);
			stmt.setString(2, start);
			stmt.setString(3, end);
			stmt.setInt(4, mtNo);
			stmt.setInt(5, mNo);
			change=stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("�ش� ������ �̸��� ��¥ ���� ���ǹ� ���� ����="+e);
		}
		db.close(stmt);
		return change;
	}
	//������ ��¥ ������ ���� �� ������ ���۳�¥ �����Լ�
	public void updateTourDetailStart(String start,String end,int mtNo) {
		String sql = MyTourSql.getSQL(MyTourSql.SELECT_DETAILSTART);
		System.out.println("�� ������ ���۳�¥ ��ȸsql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		try {
			stmt.setInt(1, mtNo);
			stmt.setString(2, start);
			stmt.setString(3, end);
			ResultSet rs = stmt.executeQuery();
			System.out.println("rs.next()��");
			if(rs.next()) {
				System.out.println("rs.next()��");
				String sql1= MyTourSql.getSQL(MyTourSql.UPDATE_DETAILSTART);
				System.out.println("�������� ������ ���� �󼼿����� ���۳�¥ ���� sql1="+sql1);
				PreparedStatement stmt1 = db.getSTMT(con, sql1);
				stmt1.setString(1, start);
				stmt1.setInt(2, mtNo);
				stmt1.setString(3, start);
				stmt1.setString(4, end);
				int stmt1Result=stmt1.executeUpdate();
				System.out.println("stmt1Result="+stmt1Result);
				db.close(stmt1);
			}
			db.close(rs);
		} catch (Exception e) {
			System.out.println("���� ��¥ ������ ���� �󼼿����� ���۳�¥ ���� ���ǹ�  ���� ����="+e);
		}
		db.close(stmt);
	}
	//������ ��¥ ������ ���� �� ������ ���ᳯ¥ �����Լ�
	public void updateTourDetailEnd(String end,String start,int mtNo) {
		String sql = MyTourSql.getSQL(MyTourSql.SELECT_DETAILEND);
		System.out.println("�� ������ ���ᳯ¥ ��ȸsql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		try {
			stmt.setInt(1, mtNo);
			stmt.setString(2, end);
			stmt.setString(3, start);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				String sql1= MyTourSql.getSQL(MyTourSql.UPDATE_DETAILEND);
				PreparedStatement stmt1 = db.getSTMT(con, sql1);
				stmt1.setString(1, end);
				stmt1.setInt(2, mtNo);
				stmt1.setString(3, end);
				stmt1.setString(4, start);
				stmt1.executeUpdate();
				db.close(stmt1);
			}
			db.close(rs);
		} catch (Exception e) {
			System.out.println("���� ��¥ ������ ���� �󼼿����� ���۳�¥ ���� ���ǹ�  ���� ����="+e);
		}
		db.close(stmt);
	}
	//�ش� ������ �̸��� ��¥ �˻� �Լ� ->����¡ ó�� ����(�������� �󼼺��⿡�� ���)
	public MyTourVO selectMyTourNameDate(int mNo, int mtNo) {
		String sql = MyTourSql.getSQL(MyTourSql.SELECT_MYTOURNAMEDATE);
		System.out.println("�ش� ������ �̸��� ��¥ �˻� sql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		MyTourVO vo = new MyTourVO();
		try {
			stmt.setInt(1, mNo);
			stmt.setInt(2, mtNo);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			vo.setMtNo(rs.getInt("no"));
			vo.setName(rs.getString("name"));
			vo.setStart(rs.getString("mtstart"));
			vo.setEnd(rs.getString("mtend"));
			db.close(rs);
		} catch (Exception e) {
			System.out.println("�ش� ���� �̸��� ��¥ �˻� ���ǹ� ���� ����="+e);
		}
		db.close(stmt);
		return vo;
	}
	//���� ������ �󼼺��� �˻� �Լ�
	public ArrayList selectMyTourDetail(int mtNo,PageUtil pinfo) {
		String sql = MyTourSql.getSQL(MyTourSql.SELECT_MYTOURDETAIL);
		System.out.println("���� ������ �󼼺��� �˻� �Լ�sql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		ArrayList list = new ArrayList();
		try {
			stmt.setInt(1, mtNo);
			ResultSet rs = stmt.executeQuery();
			int skip = (pinfo.getNowPage()-1)*pinfo.getListCount();
			for(int i=0; i<skip; i++) {
				rs.next(); 
			}
			for(int i=0; i<pinfo.getListCount()&&rs.next();i++) {
				MyTourVO vo = new MyTourVO();
				vo.setTdNo(rs.getInt("tdno"));
				vo.setNo(rs.getInt("tno"));
				vo.setMtNo(rs.getInt("mtno"));
				vo.setName(rs.getString("name"));
				vo.setImg1(rs.getString("img"));
				vo.setAddress(rs.getString("addr"));
				vo.setTheme1(rs.getString("theme"));
				vo.setX(rs.getString("x"));
				vo.setY(rs.getString("y"));
				vo.setArea(rs.getString("area"));
				vo.setStart(rs.getString("tdstart"));
				vo.setEnd(rs.getString("tdend"));
				list.add(vo);
			}
			db.close(rs);
		} catch (SQLException e) {
			System.out.println("���� ���� �󼼺��� ���ǹ� ���� ����="+e);
		}
		db.close(stmt);
		return list;
	}
	//���ϱ⿡�� ������ �����ֱ� �Լ�
	public ArrayList selectMyTour(int mNo, PageUtil pinfo) {
		String sql = MyTourSql.getSQL(MyTourSql.SELECT_TOURLIST);
		System.out.println("sql="+sql+','+mNo);
		PreparedStatement stmt = db.getSTMT(con, sql);
		ArrayList list = new ArrayList();
		try {
			stmt.setInt(1, mNo);
			ResultSet rs = stmt.executeQuery();
			int skip = (pinfo.getNowPage()-1)*pinfo.getListCount();
			for(int i=0; i<skip; i++) {
				rs.next(); 
			}
			for(int i=0; i<pinfo.getListCount()&&rs.next();i++) {
				MyTourVO vo = new MyTourVO();
				vo.setNo(rs.getInt("no"));
				vo.setName(rs.getString("name"));
				System.out.println("�����ȣ="+rs.getInt("no"));
				System.out.println("�����̸�="+rs.getString("name"));
				list.add(vo);
			}
			db.close(rs);
		} catch (Exception e) {
			System.out.println("���� ����Ʈ �ҷ����� ����="+e);
		}
		db.close(stmt);
		return list;
	}
	//�������߰��ϱ� �Լ� 
	public void insertTourList(int mNo,String Name,String start, String end) {
		String sql = MyTourSql.getSQL(MyTourSql.INSERT_TOURNAME);
		System.out.println("�����߰�sql="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		try {
			stmt.setInt(1, mNo);
			stmt.setString(2, Name);
			stmt.setString(3, start);
			stmt.setString(4, end);
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("���� �߰��ϱ� ���� ���� ����="+e);
		}
		db.close(stmt);
	}
	//�� ������ ���ϱ� �Լ�
	public int insertMyPick(int mtNo,int tNo, int mNo,String mtName) {
		//���� ���� �ߴ� ���� ���� ���ο� ���Ͽ� �˾ƺ���
		int kind=0;
		//���� ��쿡 0, �ִ� ��쿡�� 1
		String sql = MyTourSql.getSQL(MyTourSql.SELECT_MYPICK);
		System.out.println("������ ��� ���� �˻� ���ǹ� ="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		int change = 0; //���ϱ� ��Ͽ��� Ȯ�ν����ֱ� ���� -> ����Ǿ��ٸ� 1, �ƴ϶�� 0
		try {
			stmt.setInt(1, mtNo);
			stmt.setInt(2, mNo);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				if(tNo==rs.getInt("tno")) {
					kind=1;     //�̹���
					db.close(rs);
					System.out.println("kind="+kind);
				}
				else{
					kind=0;
					db.close(rs);
				}
			}
		} catch (Exception e) {
			System.out.println("���ϱ� ��� ���� �ҷ����� ���� ="+e);
		}

		if(kind==0) {
			String sql1= MyTourSql.getSQL(MyTourSql.INSERT_MYPICK);
			PreparedStatement stmt1 = db.getSTMT(con, sql1);			
			System.out.println("������ ��� ���ǹ� ="+sql1);
			try {
				System.out.println("tNo="+tNo);
				System.out.println("mtNo="+mtNo);
				stmt1.setInt(1, tNo);
				stmt1.setInt(2, mtNo);
				stmt1.setInt(3, mtNo);
				stmt1.setInt(4, mNo);
				stmt1.setInt(5, mtNo);
				stmt1.setInt(6, mNo);
				change=stmt1.executeUpdate();
				db.close(stmt1);
				System.out.println("try���� change="+change);
			} catch (Exception e) {
				System.out.println("������ ����ϱ� ���� ���� ����="+e);
			}
		}
		else {
			change=0;
		}
		db.close(stmt);
		return change;
	}
	//���� ���� ����Ʈ�� �̸��� ��¥ ������ �����ֱ� ->����¡ ó��(���ฮ��Ʈ���� �����ֱ�)
	public ArrayList selectMyTourNameDate(PageUtil pinfo, int mNo) {
		String sql = MyTourSql.getSQL(MyTourSql.SELECT_MYTOURTOTALNAMEDATE);
		System.out.println("���� ����,��¥ ��� ��ȸ�ϱ� ���ǹ� ="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		//������ ��������� -> �� ȭ�鿡 6������ �ѱ��� 5�ʱ��� ǥ��
		ArrayList list = new ArrayList();
		try {
			stmt.setInt(1, mNo);
			//���� ����Ʈ �˻� ���� ��� ���� �� ��� �Խù� ���ϵǾ���
			ResultSet rs = stmt.executeQuery();
			//�ʿ��� ������ ������ �信�� ���� -> ���� �������� �����͵� ������ �������Ͱ� �ִ� ������ ������
			int skip = (pinfo.getNowPage()-1)*pinfo.getListCount();
			for(int i=0; i<skip; i++) {
				rs.next(); 
			}
			for(int i=0; i<pinfo.getListCount()&&rs.next();i++) {
				MyTourVO vo = new MyTourVO();
				vo.setNo(rs.getInt("no"));
				vo.setName(rs.getString("name"));
				vo.setStart(rs.getString("mtstart"));
				vo.setEnd(rs.getString("mtend"));
				//vo�� list�� �־��ֱ�
				list.add(vo);
			}
			db.close(rs);
		} catch (Exception e) {
			System.out.println("���ฮ��Ʈ �ҷ����� ����="+e);
		}
		db.close(stmt);
		return list;
	}
	//���� �������� �� ������ �˻�
	public int selectMyListTotalCount(int mNo) {
		String sql = MyTourSql.getSQL(MyTourSql.SELECT_MYTOURTOTALCOUNT);
		System.out.println("���� �� �����ϸ���Ʈ �˻� ���ǹ�="+sql);
		int totalCount=0;
		PreparedStatement stmt = db.getSTMT(con,sql);
		try {
			stmt.setInt(1, mNo);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			totalCount=rs.getInt("cnt");
			System.out.println("totalCount"+totalCount);
			db.close(rs);
		} catch (Exception e) {
			System.out.println("���� �� �����ϸ���Ʈ �� �ҷ����� ����="+e);
		}
		db.close(stmt);
		return totalCount;
	}
	//���� ���� ���� ���ϱ�
	public ArrayList selectMyTourDetailTotalCount(int mNo) {
		String sql = MyTourSql.getSQL(MyTourSql.SELECT_MTNO); //�����ȣ ���ϱ�
		System.out.println("�����ȣ���ϱ� ="+sql);
		PreparedStatement stmt = db.getSTMT(con,sql);
		int mtNo=0;
		ArrayList list = new ArrayList();
		try {
			stmt.setInt(1, mNo);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				mtNo = rs.getInt("no");
				String sql1 = MyTourSql.getSQL(MyTourSql.SELECT_MYTOURDETAILTOTALCOUNT);//���� ������ ���� ���ϱ�
				PreparedStatement stmt1 = db.getSTMT(con, sql1);
				stmt1.setInt(1, mtNo);
				ResultSet rs1 = stmt1.executeQuery();
				while(rs1.next()) {
					MyTourVO vo = new MyTourVO();
					vo.setCount(rs1.getInt("cnt"));
					vo.setMtNo(rs1.getInt("mtNo"));
					list.add(vo);
				}
				db.close(rs1);
				db.close(stmt1);
			}
			db.close(rs);
		} catch (Exception e) {
			System.out.println("�� ������ ���� ���ϱ� ����="+e);
		}
		db.close(stmt);
		return list;
	}
	//���� ���� ����Ʈ�� ���� ��������
	public  ArrayList selectMyTourImg(int mNo) {
		String sql = MyTourSql.getSQL(MyTourSql.SELECT_MTNO); //�����ȣ ���ϱ�
		PreparedStatement stmt = db.getSTMT(con,sql);
		int mtNo=0;
		ArrayList list = new ArrayList();
		try {
			stmt.setInt(1, mNo);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				mtNo = rs.getInt("no");
				String sql1 = MyTourSql.getSQL(MyTourSql.SELECT_MYTOURIMG);//���� �̹����� ù��° �˻�
				System.out.println("���� �̹����� ù��° �̹��� ã�Ƴ��� sql="+sql1);
				PreparedStatement stmt1 = db.getSTMT(con, sql1);
				stmt1.setInt(1, mtNo);
				ResultSet rs1 = stmt1.executeQuery();
				while(rs1.next()) {
					MyTourVO vo = new MyTourVO();
					vo.setNo(rs1.getInt("rownum")); //������ȣ
					vo.setMtNo(rs1.getInt("no")); //�����ȣ
					vo.setTNo(rs1.getInt("tNo")); //�󼼿�������ȣ
					vo.setImg1(rs1.getString("img"));//�̹�����
					System.out.println(rs1.getInt("rownum"));
					System.out.println(rs1.getInt("no"));
					System.out.println(rs1.getInt("tNo"));
					System.out.println(rs1.getString("img"));
					list.add(vo);
				}
				db.close(rs1);
				db.close(stmt1);
			}
			db.close(rs);
		} catch (Exception e) {
			System.out.println("���� �̹����� ù��° �̹��� ã�Ƴ��� ���ǹ� ���� ����="+e);
		}
		db.close(stmt);
		return list;
	}
	//���� ���� �󼼺��� ��� �����ֱ�
	public ArrayList selectMyTourDetail(int mtNo) {
		String sql= MyTourSql.getSQL(MyTourSql.SELECT_MYTOURDETAIL);
		System.out.println("���� ���� �󼼺��� ��� ���ǹ�="+sql);
		PreparedStatement stmt = db.getSTMT(con, sql);
		ArrayList list = new ArrayList();
		try {
			stmt.setInt(1, mtNo);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				MyTourVO vo = new MyTourVO();
				vo.setTdNo(rs.getInt("tdno"));
				vo.setTNo(rs.getInt("tno"));
				vo.setMtNo(rs.getInt("mtno"));
				vo.setName(rs.getString("name"));
				vo.setImg1(rs.getString("img"));
				vo.setAddress(rs.getString("addr"));
				vo.setTheme1(rs.getString("theme"));
				vo.setX(rs.getString("x"));
				vo.setArea(rs.getString("area"));
				list.add(vo);
			}
			db.close(rs);
		} catch (Exception e) {
			System.out.println("���� ���� �� ��� �����ֱ� ����="+e);
		}
		db.close(con);
		return list;
	}
	//������ ó���� ���� �� ������ ����Ʈ �� ���� ���ϱ�
	public int selectMyListDetailTotalCount(int mtNo) {
		String sql = MyTourSql.getSQL(MyTourSql.SELECT_MYTOURDETAILTOTALCOUNT);
		System.out.println("����  �󼼿����� �� ��ϸ���Ʈ ���� �˻� ���ǹ�="+sql);
		int totalCount=0;
		PreparedStatement stmt = db.getSTMT(con,sql);
		try {
			stmt.setInt(1,mtNo);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				totalCount=rs.getInt("cnt");
				System.out.println(rs.getInt("cnt"));
			}else {
				totalCount=0;
			}
			db.close(rs);
		} catch (Exception e) {
			System.out.println("���� �� ������ ����Ʈ �� ���� �ҷ����� ����="+e);
		}
		db.close(stmt);
		return totalCount;
	}
	//Ŀ�ؼ��� �ݾ��� �Լ�
	public void close() {
		db.close(con);
	}
}
