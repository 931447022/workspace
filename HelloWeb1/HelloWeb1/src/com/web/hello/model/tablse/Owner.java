package com.web.hello.model.tablse;

public class Owner {
	private int Id;
	private String Name;
	private int Age;
	private String Datetime;
	private int Pcount;
	private String Hname;
	private String Amount;
	private String Rhouse;

	public Owner() {
			Name="";
			Datetime="";
			Hname="";
			Amount="";
		}
		

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getDatetime() {
		return Datetime;
	}

	public void setDatetime(String datetime) {
		Datetime = datetime;
	}

	public int getPcount() {
		return Pcount;
	}

	public void setPcount(int pcount) {
		Pcount = pcount;
	}

	public String getHname() {
		return Hname;
	}

	public void setHname(String hname) {
		Hname = hname;
	}

	public String getAmount() {
		return Amount;
	}

	public void setAmount(String amount) {
		Amount = amount;
	}


	public String getRhouse() {
		return Rhouse;
	}


	public void setRhouse(String rhouse) {
		Rhouse = rhouse;
	}
	
}
