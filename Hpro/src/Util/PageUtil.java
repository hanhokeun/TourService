package Util;

public class PageUtil {

	private int nowPage; //현재페이지
	private int totalCount; //총 게시물 개수
	private int listCount; //한 페이지에 나타날 게시물 개수
	private int pageCount; //한 페이지에 나타날 페이지 이동 개수
	private int totalPage; //총페이지수
	private int startPage; //화면에 표시할 시작 페이지수
	private int endPage; //화면에 표시할 마지막 페이지수
	
	
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
		//총 페이지수 구하기 함수
		totalPage = (totalCount%listCount==0)?(totalCount/listCount):(totalCount/listCount+1);
	}
	public void calcStartPage() {
		//한 화면당 보여줄 페이지의 시작번호
		int pageGroup = (nowPage%pageCount==0)?(nowPage/pageCount):(nowPage/pageCount+1);
		startPage=(pageGroup-1)*pageCount+1;
	}
	public void calcEndPage() {
		//한 화면당 보여줄 페이지의 종료번호
		endPage=startPage+pageCount-1;
		if(endPage>=totalPage) { //종료번호가 총페이지수보다 클 경우
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

