<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ServelResult.jsp" method="get">
<h3>春晚满意度调察</h3>
	<input type="radio" name="s" value=0 checked>非常好
	<input type="radio" name="s" value=1>较好
	<input type="radio" name="s" value=2>一般
	<input type="radio" name="s" value=3>较差
	<input type="radio" name="s" value=4>非常差
<input type="submit" value="提交">
<input type="reset" value="取消">
</form>
</body>
</html>