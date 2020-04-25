<%@page import="com.web.hello.Model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<%
	Model model=(Model)request.getAttribute("model");
	if(model==null)
		model=new Model();
	String a=model.getA();
	String b=model.getB();
	String c=model.getC();
	String error=model.getError();
%>
<form action="js.svt" method="get">
	<input type="text" style="width:40px;" name="a" value="<%=a %>"> 
	<select name="s">
	<option value="add" <%= "add".equals(model.getS())?"selected":"" %>>+</option>
	<option value="sub" <%= "sub".equals(model.getS())?"selected":"" %>>-</option>
	<option value="muti" <%= "muti".equals(model.getS())?"selected":"" %>>*</option>
	<option value="divi" <%= "divi".equals(model.getS())?"selected":"" %>>/</option>
	</select>
	<input type="text" style="width:40px;" name="b" value="<%=b %>"> 
	<input type="text" style="width:40px;" name="c" value="<%=c %>">
	<input type="submit" value="提交">
</form>
<p style="color:red"><%=error %></p>

</div>
</body>
</html>