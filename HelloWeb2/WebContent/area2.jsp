<%@page import="com.web.hello.Circle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Circle circle=null;
    String message="";
    String Me="";
    String r =request.getParameter("radiaus");
    System.out.println(r);
    if(r != null ){
    if(r.length() > 0 && r.matches("^[0.0-9.0]+$")){
    circle=new Circle(Double.parseDouble(r));
    Me=circle.getMessage();
    }else {
       message="您输入的参数有点问题!请重新输入!";
    }
    }else {
     message="";
    }    

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="area2.jsp" method="post">
    请输入圆的半径:<input type="text" name="radiaus"> <input type="submit" value="提交">
  </form> 
  <p style="color:red">
   <%= message %>  
   </p>
  <p><%=Me%></p>
</body>
</html>