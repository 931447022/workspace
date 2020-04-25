<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.hello.LeapYear" %>
<%
	LeapYear ly=null;
try {
	int year=Integer.parseInt(request.getParameter("a"));
	ly = new LeapYear(year);
	} 
catch(Exception e) {
	ly=new LeapYear();
	if(request.getParameter("a")!=null){
		String error="输入信息有误！不是合法年份";
		ly.setError(error);
	}
	
	}
String a=request.getParameter("a");
if(a==null)
	a="";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="year2.jsp" method="post">
请输入年份：<input type="text" name="a" value=<%=a %>>
<input type="submit" value="闰年判断">
</form>
<p>
<%=ly.getResult() %>
</p>
<p style="color:red"><%=ly.getError() %></p>
</body>
</html>