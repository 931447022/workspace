<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
   Calendar calendar = Calendar.getInstance();
   int year = calendar.get(Calendar.YEAR);
   int month = calendar.get(Calendar.MONTH);
   int date = calendar.get(Calendar.DATE);
   int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
   %>
        日期：<%= year %>年<%= month+1 %>月<%= date %>日，
       星期
   <%
   switch(dayofweek){
   case Calendar.SUNDAY:
         out.print("天");
       break;
   case Calendar.MONDAY:
       out.print("一");
       break;
   case Calendar.TUESDAY:
      out.print("二");
       break;
   case Calendar.WEDNESDAY:
       out.print("三");
       break;
   case Calendar.THURSDAY:
       out.print("四");
       break;
   case Calendar.FRIDAY:
       out.print("五");
       break;
   case Calendar.SATURDAY:
       out.print("六");
       break;
  }
   %>
</body>
</html>