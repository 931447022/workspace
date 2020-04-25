<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.hello.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>用户注册信息</h3>
<% User user=(User)request.getAttribute("user");

%>
<p>姓名是<%=user.getName() %>
<p>年龄是<%=user.getAge() %>
<p>性别是<%=user.getSex() %>
<p>兴趣是<% for(String h:user.getHobbies())
	out.print(h+" ");%>
<p>学历是<%=user.getEducation() %>
<p>邮箱是<%=user.getEmail() %>
</body>
</html>