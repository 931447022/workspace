package com.web.hello.model.tables;

import java.util.ArrayList;

import com.web.hello.model.tables.Staff;

public class StaffListModel {
	private String cardnum;
	private String keyword;
	private ArrayList<Staff> staffList;
	private ArrayList<String> cardnumList;
	private Page page;
	public StaffListModel() {
		cardnum="";
		keyword="";
		staffList=new ArrayList<>();
		page=new Page();
	}

	public String getCardnum() {
		return cardnum;
	}

	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public ArrayList<Staff> getStaffList() {
		return staffList;
	}

	public void setStaffList(ArrayList<Staff> staffList) {
		this.staffList = staffList;
	}

	public ArrayList<String> getCardnumList() {
		return cardnumList;
	}

	public void setCardnumList(ArrayList<String> cardnumList) {
		this.cardnumList = cardnumList;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	
}
