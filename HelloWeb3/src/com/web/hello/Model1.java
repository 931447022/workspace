package com.web.hello;

public class Model1 {
	private String a="";
	private String b="";
	private String s="";
	private String c="";

	private String error="";

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public void caculate() {
		if(!"".equals(a) && !"".equals(b) && !"".equals(s)){
			try {
				if("add".equals(s)) {
					c=String.valueOf(Integer.parseInt(a)+Integer.parseInt(b));
				}else if ("sub".equals(s)) {
					c=String.valueOf(Integer.parseInt(a)-Integer.parseInt(b));
				}else {
					error="s必须是+或者-";
				}
			} catch (Exception e) {
				error="参数解析异常："+e.getMessage();
			}
		}else {
			error="参数不完整，必须有 a，b，s";
		}
	}
	public String getResult() {
		return a+s+b+"="+c;
	}
}
