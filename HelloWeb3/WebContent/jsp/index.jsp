<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>站点首页面</title>
<link href="css\layout.css" rel="stylesheet" type="text/css" />

</head>
<body>
     <div id="container">
        <div id="header"><%@ include file="header.jsp"%></div><br><br>
         <div id="topmenu"><%@ include file="topmenu.jsp"%></div><br>
        <div id="mainContent"><br>
            <div id="leftmenu"><%@ include file="leftmenu.jsp"%></div>
            <div id="content"><%@ include file="content.jsp"%></div>
        </div>
        <div id="footer"><%@ include file="footer.jsp"%></div>
     </div>

</body>
</html>