<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.hello.model.tables.StaffListModel" %>
<%@ page import="com.web.hello.model.tables.Staff" %>
<%@ page import="java.util.ArrayList" %>
<%  
	StaffListModel model=(StaffListModel)request.getAttribute("model"); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/hello5/jquery/jquery-3.3.1.min.js"></script>
<script >
function add(){
	window.location.href="pream.do";
}
function modify(id){
	window.location.href="pream.do?id="+id;
}
function del(id){
	window.location.href="del.do?id="+id;
}
function prepage(){
// 	var page=parseInt(document.getElementById("page").getAttribute("value"));
// 	if(page==1)
// 		return;
// 	page--;
// 	document.getElementById("page").setAttribute("value",page);
// 	document.getElementById("form1").submit();
	var page=parseInt($('#page').val());
	if(page==1)
		return;
	page--;
	$('#page').val(page);
	$('#form1').get(0).submit;
}
function nextpage(){
// 	var page=parseInt(document.getElementById("page").getAttribute("value"));
// 	var totalpage=parseInt(document.getElementById("totalpage").getAttribute("value"));
// 	if(page==totalpage)
// 		return;
// 	page++;
// 	document.getElementById("page").setAttribute("value",page);
// 	document.getElementById("form1").submit();
	var page=parseInt($('#page').val());
	var totalpage=parseInt($('#totalpage').val());
	if(page==totalpage)
		return;
	page++;
	$('#page').val(page);
	$('#form1').get(0).submit();
}
function pagego(page){
// 	document.getElementById("page").setAttribute("value",page);
// 	document.getElementById("form1").submit();
	$('#page').val(page);
	$('#form1').get(0).submit();
}
function search(){
// 	document.getElementById("page").setAttribute("value",1);
// 	document.getElementById("form1").submit();
	$('#page').val(1);
	$('#form1').get(0).submit();
}
</script>
</head>
<body align="center">
<h1>员工信息显示</h1>
<form id="form1" action="" method="post">
	部门：
	<select name="depart" onchange="search()">
		<option value="">--选择部门--</option>
		<% for(String depart:model.getDepartList()){ %>
			<option <%=depart.equals(model.getDepart())?"selected":"" %>> <%=depart %></option>
		<%} %>
	</select>
	关键字：<input type="text" name="keyword" value="<%=model.getKeyword() %>">
	每页
	<select name="pagesize" onchange="search()">
		<option value=5 <%=model.getPage().getPagesize()==5?"selected":"" %>>5</option>
		<option value=10 <%=model.getPage().getPagesize()==10?"selected":"" %>>10</option>
		<option value=15 <%=model.getPage().getPagesize()==15?"selected":"" %>>15</option>
		<option value=20 <%=model.getPage().getPagesize()==20?"selected":"" %>>20</option>
	</select>
	条
	<input type="hidden" id="page" name="page" value=<%=model.getPage().getCurrentPage() %>>
	<input type="hidden" id="totalpage" name="totalpage" value=<%=model.getPage().getTotalpage() %>>
	<input type="submit" value="查询">
	<button type="button" onclick="add()">添加员工</button>
</form>
<p>
<table width="90%" border="1" align="center">
	<tr>
		<th>部门</th>
		<th>姓名</th>
		<th>工号</th>
		<th>性别</th>
		<th>年龄</th>
		<th>入职日期</th>
		<th>操作</th>
	</tr>
	<% for(Staff staff:model.getStaffList()){ %>
	<tr>
		<td align="center"><%=staff.getDepart() %></td>
		<td align="center"><%=staff.getName() %></td>
		<td align="center"><%=staff.getCode() %></td>
		<td align="center"><%=staff.getGenstr() %></td>
		<td align="center"><%=staff.getAge() %></td>
		<td align="center"><%=staff.getEnrolldateStr() %></td>
		<td><button onclick="modify(<%=staff.getId() %>)">修改</button >
		    <button onclick="del(<%=staff.getId() %>)">删除</button>
		 </td>
	</tr>
	<%} %>
</table>
<div align="right">
	<button onclick="pagego(1)">首页</button>
	<button onclick="prepage()">上一页</button>
	<%=model.getPage().getCurrentPage() %>/<%=model.getPage().getTotalpage() %>
	<button onclick="nextpage()">下一页</button>
	<button onclick="pagego(<%=model.getPage().getTotalpage()%>)">尾页</button>
</div>
</body>
</html>