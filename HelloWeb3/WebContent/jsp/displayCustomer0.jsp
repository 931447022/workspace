<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.hello.Customer" %>
<% Customer customer=(Customer)session.getAttribute("customer"); %>
<html>
<head> <title>显示客户信息</title></head>
<body>
<h4>客户信息如下</h4>
<table border="1">
<tr>
<td>客户名:</td>
<td><%= customer.getCustName()%></td>
</tr>
<tr>
<td>Email地址:</td>
<td><%= customer.getEmail()%></td>
</tr>
<tr>
<td>电话:</td>
<td><%= customer.getPhone()%></td>
</tr>
</table>
${customer.custName}
${customer.email}
${customer.phone}
</body>
</html>