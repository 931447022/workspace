package com.web.hello.model;

public class Page {
	private int currentPage=1;
	private int pagesize=10;
	private int totalRecords=0;
	private int totalpage=0;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int page) {
		this.currentPage = page;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int total) {
		this.totalRecords = total;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
}
