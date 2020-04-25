<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<% int sum=0;
String question1 = request.getParameter("quest1");
String question2 = request.getParameter("quest2");
String[] question3= request.getParameterValues("quest3");
String question4 = new String(request.getParameter("quest4").getBytes("Iso8859-1"));
try {
if(question1.equals("1")) {
				sum += 25;
				}
			if(question2.equals("3")) {
				 sum += 25;
				}
			if(question3.length == 2&& question3[0].equals("1") && question3[1].equals("3")) {
				sum +=25;
			}
			if(question4.equals("HttpServlet")) {
				sum +=25;
				
			}
			out.println("你的成绩"+sum+"分");
			}catch(Exception e)
        {
      	  out.println("0");
        }%>	
</body>
</html>