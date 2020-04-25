<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.hello.model.tables.Staff" %>
<%@ page import="java.util.ArrayList"%>
<%
	Staff model=(Staff)request.getAttribute("model");
	if(model==null)
		model=new Staff();
	ArrayList<String> model2=(ArrayList<String>)request.getAttribute("model2");
	if(model2==null)
		model2=new ArrayList<String>();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">
	<% 	if(model.getId()==0)
			out.println("新增贵宾信息");
		else
			out.println("修改贵宾信息");
		%>
</h1>
<form action="save.do" method="post">
<table align="center">
	<tr>
		<td>贵宾号分区</td>
		<td> 
			<select name="cardnum">
		<option value="">--选择区域--</option>
		<% for(String cardnum:model2){ %>
			<option <%=cardnum.equals(model.getCardnum())?"selected":"" %>> <%=cardnum %></option>
		<%} %>
	</select>
		</td>
	</tr>
	<tr>
		<td>姓名</td><td> <input type="text" name="name" value=<%=model.getName() %>></td>
	</tr>
	<tr>
		<td>预定游玩项目</td><td> <input type="text" name="yudxm" value=<%=model.getYudxm() %>></td>
	</tr>
	<tr>
		<td>卡内充值金额</td><td> <input type="text" name="amount" value=<%=model.getAmount() %>></td>
	</tr>
	<tr>
		<td>预定游玩时间</td><td> <input type="date" name="yuddate" value=<%=model.getYudDateStr() %>></td>
	</tr>
	<tr>
		<td><input type="hidden" name="id" value=<%=model.getId() %>></td>
		<td> <input type="submit" value="提交"></td>
	</tr>
</table>
</form>

</body>
</html>