<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>输入客户信息</title>
</head>
<body>
<h4>输入客户信息</h4>
<form action = "/hello3/CustomerServlet" method = "post">
 <table>
  <tr><td>客户名：</td> <td><input type="text" name="custName" ></td></tr>
  <tr><td>邮件地址：</td><td><input type="text" name="email"></td></tr>      
  <tr><td>电话：</td><td><input type="text" name="phone" ></td></tr>
  <tr><td><input type="submit" value="确定" ></td>
      <td><input type="reset" value="重置" ></td>
  </tr>
</table>
</form>

</body>
</html>