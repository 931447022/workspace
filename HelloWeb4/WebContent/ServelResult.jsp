<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! int[] result={0,0,0,0,0,0}; %>
<% 
	String s=request.getParameter("s");
	if(s.equals("0"))
	{
		result[0]++;
		result[5]++;
	}
	if(s.equals("1"))
	{
		result[1]++;
		result[5]++;
	}
	if(s.equals("2"))
	{
		result[2]++;
		result[5]++;
	}
	if(s.equals("3"))
	{
		result[3]++;
		result[5]++;
	}
	if(s.equals("4"))
	{
		result[4]++;
		result[5]++;
	}
	
    DecimalFormat df=new DecimalFormat("0.00%");
    String b0="",b1="",b2="",b3="",b4="";
	if(result[5]!=0){
        float num = (float) result[0]/result[5];
        b0 = df.format(num);
     }
	if(result[5]!=0){
        float num = (float) result[1]/result[5];
        b1 = df.format(num);
     }
	if(result[5]!=0){
        float num = (float) result[2]/result[5];
        b2 = df.format(num);
     }
	if(result[5]!=0){
        float num = (float) result[3]/result[5];
        b3 = df.format(num);
     }
	if(result[5]!=0){
        float num = (float) result[4]/result[5];
        b4 = df.format(num);
     }
%>

<h3>春晚满意度调查结果</h3>
非常好:<%=result[0] %>人,百分比:<%=b0 %></br>
较好:<%=result[1] %>人,百分比:<%=b1 %></br>
一般:<%=result[2] %>人,百分比:<%=b2 %></br>
较差:<%=result[3] %>人,百分比:<%=b3 %></br>
非常差:<%=result[4] %>人,百分比:<%=b4 %></br>
<h3>共有<%=result[5] %>人投票</h3>
</body>
</html>