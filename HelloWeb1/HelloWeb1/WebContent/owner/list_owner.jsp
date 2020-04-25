<%@page import="com.web.hello.model.OwnerListModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.hello.model.tablse.Owner" %>
<%@ page import="java.util.ArrayList" %>
<%
    OwnerListModel model=(OwnerListModel)request.getAttribute("model");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script >
function add(){
	window.location.href="am_owner.jsp";
}
function modify(id){
	window.location.href="pream.do?id="+id;
}
function del(id){
	if(!confirm('确实删除吗？'))
		return;
	window.location.href="del.do?id="+id;
}
</script>
</head>
<body align="center">
<h1>业主信息列表</h1>
<form action="" method="post">
	楼栋：<input type="text" onchange="search()">
		<option value="">--选择楼栋--</option>
		<%for(String rhouse:model.getRhouseList()){ %>
		<option> <%=rhouse%></option>
	<%} %>
	</select>
	关键字：<input type="text" name="keyword" value="<%=model.getKeyword()  %>" >
	<input type="submit" value="查询">
	<button type="button"onclick="add()">添加业主信息 </button>
	
</form>
<p>
<table width="90%" border="1" align="center">
	<tr>
		<th>序号</th>
		<th>姓名</th>
		<th>年龄</th>
		<th>入住时间</th>
		<th>居住人数</th>
		<th>房屋编号</th>
		<th>待缴费用</th>
		<th>楼栋</th>
		<th>操作</th>
	</tr>
	<% for(Owner owner:model.getOwnerList()){ %>
	<tr>
		<td align="center"><%=owner.getId()%></td>
		<td align="center"><%=owner.getName()%></td>
		<td align="center"><%=owner.getAge()%></td>
		<td align="center"><%=owner.getDatetime()%></td>
		<td align="center"><%=owner.getPcount()%></td>
		<td align="center"><%=owner.getHname()%></td>
		<td align="center"><%=owner.getAmount()%></td>
		<td align="center"><%=owner.getRhouse()%></td>	
		<td><button onclick="modify(<%=owner.getId()%>)">修改</button>
			<button onclick="del(<%=owner.getId()%>)">删除</button> 
		</td>
	</tr>
	<%} %>
</table>

</body>
</html>