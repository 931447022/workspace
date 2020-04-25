package com.web.hello.model.tables;

import java.util.ArrayList;

import com.web.hello.model.tables.Staff;

public class StaffListModel {
	private String depart;
	private String keyword;
	private ArrayList<Staff> staffList;
	private ArrayList<String> departList;
	private Page page;
	
	public StaffListModel() {
		depart="";
		keyword="";
		staffList=new ArrayList<>();
		page=new Page();
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
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

	public ArrayList<String> getDepartList() {
		return departList;
	}

	public void setDepartList(ArrayList<String> departList) {
		this.departList = departList;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}	
	
	
}
