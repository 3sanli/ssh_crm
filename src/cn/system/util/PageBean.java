package cn.system.util;

import java.util.List;

public class PageBean {
	//总页数
	private Integer pageSize;
	//总记录数
	private Integer recordSize;
	
	
	//查询开始页面
	private Integer currentPage;
	//每页显示记录数
	private Integer pageRecord;
	
	//查询结果集
	private List list;
	
	

	public PageBean() {
		
	}

	public PageBean(Integer recordSize, Integer currentPage, Integer pageRecord) {
		this.recordSize = recordSize;
				
		this.currentPage = currentPage;
		//若没指定当前页面则为默认值1
		if(this.currentPage == null) {
			this.currentPage = 1;
		}
		
		this.pageRecord = pageRecord;
		//若没指定每页显示记录数，则默认值为3
		if(this.pageRecord == null) {
			this.pageRecord = 3;
		}
		
		//根据总记录数和每页显示记录数生成总页数
		this.pageSize = (this.recordSize + this.pageRecord-1)/this.pageRecord;
		
		if(this.currentPage<1) {
			this.currentPage = 1;
		}
		else if(this.currentPage > this.pageSize) {
			this.currentPage = this.pageSize;
		}
		
	}

	public Integer getStart() {
		return (this.currentPage-1)*this.pageRecord;
	}
	
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getRecordSize() {
		return recordSize;
	}

	public void setRecordSize(Integer recordSize) {
		this.recordSize = recordSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageRecord() {
		return pageRecord;
	}

	public void setPageRecord(Integer pageRecord) {
		this.pageRecord = pageRecord;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	
	
	
}	
