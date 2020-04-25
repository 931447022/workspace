package com.web.hello.model.tables;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Staff {
	private int id;
	private String name;
	private String code;
	private int gender;
	private int birthyear;
	private String depart;
	private String resume;
	private long enrolldate;
	
	public Staff() {
		name="";
		code="";
		depart="";
		resume="";
	}

	public String getGenstr() {
		if(gender==0)
			return "女";
		else
			return "男";
	}
	public String getEnrolldateStr() {
		if(enrolldate>0) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			return dateFormat.format(new Date(enrolldate));
		}
		return "";
	}
	public void setEnrolldate(String enrolldate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.enrolldate = dateFormat.parse(enrolldate).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.enrolldate =System.currentTimeMillis();
		}
	}
	public int getAge() {
		Calendar calendar=Calendar.getInstance();
		return calendar.get(Calendar.YEAR)-birthyear;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getBirthyear() {
		return birthyear;
	}
	public void setBirthyear(int birthyear) {
		this.birthyear = birthyear;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public long getEnrolldate() {
		return enrolldate;
	}
	public void setEnrolldate(long enrolldate) {
		this.enrolldate = enrolldate;
	}
}
