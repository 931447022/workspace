<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!  
int count = 0;  
public void jspInit(){  // 覆盖jspInit()
	     System.out.println("jspInt...");
  }
  public void jspDestroy(){  // 覆盖jspDestroy()
	     System.out.println("jspDestroy...");
  }
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%
    
  count++;%>
覆盖jspInit()和jspDestroy()！<br>
该页面被访问<%=count%>次。
hello！
</body>
</html>