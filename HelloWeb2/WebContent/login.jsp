<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% String message=(String)session.getAttribute("message");
	if(message==null)
		message="";
	String value1="",value2="",value3=""; 
	Cookie cookie=null;
	Cookie[] cookies=request.getCookies();
	if(cookies!=null) {
		for(int i=0;i<cookies.length;i++) {
			cookie=cookies[i];
			if(cookie.getName().equals("loginname"))
					value1=cookie.getValue();
			if(cookie.getName().equals("password"))
					value2=cookie.getValue();
			if(cookie.getName().equals("check"))
					value3=cookie.getValue();
		}
	}
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p style="color:red">

<%=message %>
</p>
<form action="login.do" method="get">
			账号：<input type="text" name="loginname" values="<%=value1%>">
			<br />
			密码：<input type="password" name="pwd" values="<%=value2%>">
			<br />
			<input type="checkbox" name="check" <%= value3.equals("on")?"checked":""%>/>记住账号
			<br />
			<input type="submit" value="提交">
			<input type="reset" value="重置">
</form>
</body>
</html>