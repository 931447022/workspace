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
	var page=parseInt(document.getElementById("page").getAttribute("value"));
	if(page==1)
		return;
	page--;
	document.getElementById("page").setAttribute("value",page);
	document.getElementById("form1").submit();
}
function nextpage(){
	var page=parseInt(document.getElementById("page").getAttribute("value"));
	var totalpage=parseInt(document.getElementById("totalpage").getAttribute("value"));
	if(page==totalpage)
		return;
	page++;
	document.getElementById("page").setAttribute("value",page);
	document.getElementById("form1").submit();
}
function pagego(page){
	document.getElementById("page").setAttribute("value",page);
	document.getElementById("form1").submit();
}
function search(){
	document.getElementById("page").setAttribute("value",1);
	document.getElementById("form1").submit();
}
</script>
</head>
<body align="center">
<h1>贵宾信息显示</h1>
<form id="form1" action="" method="post">
	<select name="cardnum" onchange="search()">
		<option value="">--选择分区贵宾号--</option>
		<% for(String cardnum:model.getCardnumList()){ %>
			<option <%=cardnum.equals(model.getCardnum())?"selected":"" %>> <%=cardnum %></option>
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
	<button type="button" onclick="add()">添加新贵宾</button>
</form>
<p>
<table width="90%" border="1" align="center">
	<tr>
		<th>卡号</th>
		<th>姓名</th>
		<th>预定游玩项目</th>
		<th>预定游玩时间</th>
		<th>卡内金额</th>
		<th>操作</th>
	</tr>
	<% for(Staff staff:model.getStaffList()){ %>
	<tr>
		<td align="center"><%=staff.getCardnum() %></td>
		<td align="center"><%=staff.getName() %></td>
		<td align="center"><%=staff.getYudxm() %></td>
		<td align="center"><%=staff.getYudDateStr()%></td>
		<td align="center"><%=staff.getAmount() %></td>
		<td><button onclick="modify(<%=staff.getId()%>)">修改</button> 
			<button onclick="del(<%=staff.getId()%>)">删除</button> 
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