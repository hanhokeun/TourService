package Util;

public class PageUtil {

	private int nowPage; //����������
	private int totalCount; //�� �Խù� ����
	private int listCount; //�� �������� ��Ÿ�� �Խù� ����
	private int pageCount; //�� �������� ��Ÿ�� ������ �̵� ����
	private int totalPage; //����������
	private int startPage; //ȭ�鿡 ǥ���� ���� ��������
	private int endPage; //ȭ�鿡 ǥ���� ������ ��������
	
	
	public PageUtil(int np,int tc){
		this(np,tc,8,3);
	}
	public PageUtil(int np,int tc, int lc, int pc) {
		this.nowPage=np;
		this.totalCount=tc;
		this.listCount=lc;
		this.pageCount=pc;
		
		calcTotalPage();
		calcStartPage();
		calcEndPage();
	}
	public void calcTotalPage() {
		//�� �������� ���ϱ� �Լ�
		totalPage = (totalCount%listCount==0)?(totalCount/listCount):(totalCount/listCount+1);
	}
	public void calcStartPage() {
		//�� ȭ��� ������ �������� ���۹�ȣ
		int pageGroup = (nowPage%pageCount==0)?(nowPage/pageCount):(nowPage/pageCount+1);
		startPage=(pageGroup-1)*pageCount+1;
	}
	public void calcEndPage() {
		//�� ȭ��� ������ �������� �����ȣ
		endPage=startPage+pageCount-1;
		if(endPage>=totalPage) { //�����ȣ�� �������������� Ŭ ���
			endPage=totalPage;
		}
	}
		public int getNowPage() {
			return nowPage;
		}
		public int getTotalCount() {
			return totalCount;
		}
		public int getListCount() {
			return listCount;
		}
		public int getPageCount() {
			return pageCount;
		}
		public int getTotalPage() {
			return totalPage;
		}
		public int getStartPage() {
			return startPage;
		}
		public int getEndPage() {
			return endPage;
		}
	}

