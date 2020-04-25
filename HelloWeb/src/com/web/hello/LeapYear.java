package com.web.hello;

public class LeapYear {
	int year;
	String result;
	private String error="";
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public LeapYear() {
		super();
	}
	public LeapYear(int year) {
		super();
		this.year = year;
		if(year%4==0 && year%100!=0 || year%400==0)
			result=year+"年时闰年";
		else 
			result=year+"年不是闰年";
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
}
