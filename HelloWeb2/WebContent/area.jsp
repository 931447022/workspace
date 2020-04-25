<%@page import="com.web.hello.Circle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String message=(String)request.getAttribute("message"); 
String radiaus=request.getParameter("radiaus");
Circle circle=(Circle)request.getAttribute("circle");
if(circle==null) {
circle=new Circle();  
}
String Me=circle.getMessage();
if(circle.getR()==0.0){
Me="";
}
if(message==null)
message="";                               
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="area.do" method="post">

    请输入圆的半径:<input type="text" name="radiaus"> 
    <input type="submit" value="提交">

  </form>
  <p style="color:red">
    <% out.print(message); %>
   </p>
    <p><% out.print(Me);%></p>
</body>
</html>