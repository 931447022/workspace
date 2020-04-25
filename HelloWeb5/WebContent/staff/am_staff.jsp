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
			out.println("新增员工信息");
		else
			out.println("修改员工信息");
		%>
</h1>
<form action="save.do" method="post">
<table align="center">
	<tr>
		<td>部门</td>
		<td> 
			<select name="depart">
		<option value="">--选择部门--</option>
		<% for(String depart:model2){ %>
			<option <%=depart.equals(model.getDepart())?"selected":"" %>> <%=depart %></option>
		<%} %>
	</select>
		</td>
	</tr>
	<tr>
		<td>姓名</td><td> <input type="text" name="name" value="<%=model.getName() %>"></td>
	</tr>
	<tr>
		<td>工号</td><td> <input type="text" name="code" value="<%=model.getCode() %>"></td>
	</tr>
	<tr>
		<td>性别</td>
		<td> 
			<input type="radio" name="gender" value="1" <%=model.getGender()==1?"checked":"" %> >男
			<input type="radio" name="gender" value="0" <%=model.getGender()==0?"checked":"" %> >女
		</td>
	</tr>
	<tr>
		<td>出生年份</td><td> <input type="text" name="birthyear" value="<%=model.getBirthyear()==0?"":model.getBirthyear() %>"></td>
	</tr>
	<tr>
		<td>简历</td><td> <textarea name="resume" cols="30" rows="5" ><%=model.getResume()==null?"":model.getResume() %> </textarea></td>
	</tr>
	<tr>
		<td>入职日期</td><td> <input type="date" name="enrolldate" value="<%=model.getEnrolldateStr() %>"></td>
	</tr>
	<tr>
		<td><input type="hidden" name="id" value="<%=model.getId() %>"></td>
		<td> <input type="submit" value="提交"></td>
	</tr>
</table>
</form>
</body>
</html>