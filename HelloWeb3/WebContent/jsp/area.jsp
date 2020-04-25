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
   String s = request.getParameter("radius");
   if(s==null)
	       s = "0";
   r = Double.parseDouble(s);
%>
<form action="area.jsp" method="post">
请输入圆的半径：
<input type="text" name="radius" size="5"/>
<input type="submit" value="提交" />
</form>
半径为<%= r %>的圆的面积为：<%=area(r)%>
<%! 
double r = 0;             // 声明一个变量r
double area(double r) { // 声明求圆面积的方法
return r * r * Math.PI;
} 
%> 

</body>
</html>