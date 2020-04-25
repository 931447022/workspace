<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>用户名注册</h3>
<p> 姓名是<%=new String(request.getParameter("name").getBytes("ISO8859-1"),"UTF-8") %>
<p> 性别是<%=request.getParameter("sex") %>
<p> 兴趣是<%
String[] hobbies=request.getParameterValues("hobby");
for(int i=0;i<hobbies.length;i++) {
        out.println(hobbies[i]);
}
%>
<p> 学历是<%=request.getParameter("education")%>
<p> 邮件地址是<%=request.getParameter("email") %>
</body>
</html>