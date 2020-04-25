<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
try {
		int year=Integer.parseInt(request.getParameter("a"));
       if(year%4==0 && year%100!=0 || year%400==0) {
        out.println(year+"年是闰年");
          }else {
        	  out.println("清输入正确的年份！");
          }
        	  out.println("<br>");
          }
          catch(Exception e)
          {
        	  out.println("输入年份！");
          }
%>
</body>
</html>