package cn.zcib.bean;

import java.util.List;

public class PageBean<T> {

	private List<T> list; //要返回的某一页的记录列表
	private int allRow; //总记录数
	private int totalPage; //总页数
	private int currentPage; //当前页
	private int pageSize; //每页记录数
	private boolean isFirstPage; //是否为第一页  
	private boolean isLastPage; //是否为最后一页
	private boolean hasPreviousPage; //是否有前一页
	private boolean hasNextPage; //是否有下一页

	private int pageBegin; //在页码栏里要打印的首页码
	private int pageEnd; //在页码栏里要打印的末页码
	
	public void init()
	{
		int num = 10;
		int tnum = num/2;
		if(this.totalPage > 10)
		{
			if(this.currentPage > tnum && this.currentPage < this.totalPage-tnum)
			{
				this.pageBegin = this.currentPage - (tnum-1);
				this.pageEnd = this.currentPage+tnum<this.totalPage ? this.currentPage+tnum : this.totalPage;
			}
			else if(this.currentPage > tnum && this.currentPage >= this.totalPage-tnum)
			{
				this.pageBegin = this.totalPage-(tnum*2-1);
				this.pageEnd = this.totalPage;
			}
			else
			{
				this.pageBegin = 1;
				this.pageEnd = (tnum*2);
			}
		}
		else
		{
			this.pageBegin = 1;
			this.pageEnd = this.totalPage;
		}
		System.out.println(this.pageBegin + "-" + this.pageEnd);
	}
	/** 
	  * 计算总页数,静态方法,供外部直接通过类名调用
	  * @parampageSize每页记录数
	  * @paramallRow总记录数
	  * @return总页数
	  */
	public static int countTotalPage(final int pageSize,final int allRow)
	{
		int totalPage = allRow % pageSize == 0 ? allRow/pageSize : allRow/pageSize+1;
		return totalPage;
	}
	/** 
	  * 计算当前页开始记录 
	  * @parampageSize每页记录数
	  * @paramcurrentPage当前第几页
	  * @return当前页开始记录号
	  */
	public static int countOffset(final int pageSize,final int currentPage)
	{
		final int offset = pageSize * (currentPage-1);
		return offset;
	}
	/**
	  * 计算当前页,若为0或者请求的URL中没有"?page=",则用1代替  
	  * @param page  传入的参数(可能为空,即0,则返回1) 
	  * @return当前页
	  */
	public static int countCurrentPage(int page)
	{
		final int curPage = (page==0?1:page);
		return curPage;
	}
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getAllRow() {
		return allRow;
	}
	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public boolean isFirstPage() {
		return isFirstPage;
	}
	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}
	public boolean isLastPage() {
		return isLastPage;
	}
	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}
	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}
	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}
	public boolean isHasNextPage() {
		return hasNextPage;
	}
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	public int getPageBegin() {
		return pageBegin;
	}
	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}
	public int getPageEnd() {
		return pageEnd;
	}
	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}
	
}
