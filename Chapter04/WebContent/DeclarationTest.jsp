<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%! // 선언문
	String checkStr(){
		if(str==null) return "no";
		else return "ok";
	}
	%>
	<%! 
	String str ="JSP 스터디";
	%>
	<%
	// 스크립틀릿(Scriptet)
	int sum=0;
	for(int i=0; i<=100; i++){
		sum+=i;
	}
	System.out.print("결과값은"+sum);
	%>
	<%=sum%>	<br>
	<%=checkStr() %><br>
	<%= sum+2000 %>
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>