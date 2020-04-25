package com.web.hello.model.tables;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Staff {
	private int id;
	private String name;
	private String cardnum;
	private String yudxm;
	private long yuddate;
	private int amount;

	
	public Staff() {
		name="";
		
		yudxm="";
		
	}

	
	public String getYudDateStr() {
		if(yuddate>0) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			return dateFormat.format(new Date(yuddate));
		}
		return "";
	}
	public void setYudDate(String yuddate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.yuddate = dateFormat.parse(yuddate).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.yuddate =System.currentTimeMillis();
		}
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


	public String getCardnum() {
		return cardnum;
	}


	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}


	public String getYudxm() {
		return yudxm;
	}


	public void setYudxm(String yudxm) {
		this.yudxm = yudxm;
	}


	public long getYuddate() {
		return yuddate;
	}


	public void setYuddate(long yuddate) {
		this.yuddate = yuddate;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
