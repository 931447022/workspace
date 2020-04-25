package com.web.hello.model;

import java.util.ArrayList;

import com.web.hello.model.tablse.Owner;

public class OwnerListModel {
	private String Rhouse;
	private String keyword;
	private ArrayList<Owner> OwnerList;
	private ArrayList<String> RhouseList;
	private Page page;
	
	public OwnerListModel() {
		Rhouse="";
		keyword="";
		OwnerList=new ArrayList<>();
		page=new Page();
		
	}

	public String getRhouse() {
		return Rhouse;
	}

	public void setRhouse(String rhouse) {
		Rhouse = rhouse;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public ArrayList<Owner> getOwnerList() {
		return OwnerList;
	}

	public void setOwnerList(ArrayList<Owner> ownerList) {
		OwnerList = ownerList;
	}

	public ArrayList<String> getRhouseList() {
		return RhouseList;
	}

	public void setRhouseList(ArrayList<String> rhouseList) {
		RhouseList = rhouseList;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}


