package cn.system.domain;

public class PageSelect {
	//总页数
	private Long pageSize;
	//总记录数
	private Long recordSize;
	
	
	//查询开始位置
	private Long start;
	//每页显示记录数
	private Long pageRecord;
	//跳转页面
	private Long goPage;
	
	public PageSelect() {
		this.pageRecord = 3l;
		
		this.goPage = 1l;
		this.start = (this.goPage - 1) * this.pageRecord;
		
		this.pageSize = (this.recordSize+this.pageRecord-1) / this.pageRecord;
	}
		


	public Long getPageSize() {
		return pageSize;
	}
	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}	
	
	
	public Long getStart() {
		return start;
	}
	public void setStart(Long start) {
		this.start = start;
	}
	public Long getPageRecord() {
		return pageRecord;
	}
	public void setPageRecord(Long pageRecord) {
		this.pageRecord = pageRecord;
	}
	public Long getGoPage() {
		return goPage;
	}
	public void setGoPage(Long goPage) {
		this.goPage = goPage;
	}
	
	
}	
