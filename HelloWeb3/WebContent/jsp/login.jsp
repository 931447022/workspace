<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String name=request.getParameter("username");
    if(name!=null){
   		session.setAttribute("Login_User",name);
   		response.sendRedirect("demof.jsp");
    }
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="login.jsp" method="post">
   <table>
   <tr><td>帐&nbsp;&nbsp;号：</td>
       <td><input type="text" name="username"/></td>
   </tr>
   <tr><td>密&nbsp;&nbsp;码：</td>
        <td><input type="password" name="password"/></td>
   <tr><td><input type="submit" value="登录"/></td>
       <td><input type="reset" value="取消"/></td>
   </tr>
   </table>
</form>
</body>
</html>