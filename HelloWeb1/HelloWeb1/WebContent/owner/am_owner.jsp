<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.hello.model.tablse.Owner" %>
<%
	Owner model=(Owner)request.getAttribute("model");
	if(model==null)
		model=new Owner();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">业主信息</h1>
<form action="save.do"method="post">
<table align="center">
<tr>
<td></td><td><input type="hidden" name="id" value=<%=model.getId()==0?0:model.getId() %>></td>
</tr>
<tr>
<td>姓名</td><td><input type="text" name="name"value=<%=model.getName() %>></td>
</tr>
<tr>
<td>年龄</td><td><input type="text" name="age"value=<%=model.getAge()==0?"":model.getAge() %>></td>
</tr>
<tr>
<td>入住时间</td><td><input type="text" name="datetime"value=<%=model.getDatetime() %>></td>
<tr>
<td>居住人数</td><td><input type="text" name="pcount"value=<%=model.getPcount()==0?"":model.getPcount()%>></td>
</tr>
<tr>
<td>房屋编号</td><td><input type="text" name="hname"value=<%=model.getHname()%>></td>
</tr>
<tr>
<td>待缴费用</td><td><input type="text" name="amount"value=<%=model.getAmount() %>></td>
</tr>
<tr>
<td></td><td><input type="submit" value="提交"></td>
</tr>
</table>
</form>
</body>
</html>