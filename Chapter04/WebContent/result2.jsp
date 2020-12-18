<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String id = request.getParameter("id");
	String password = request.getParameter("pass"); // pass는 name값
	%>
	<%
	if(id.equals("admin") && password.equals("1234")){
	%>
		관리자님 오셨군요~
	<% 	}else{%>
		"누구냐 넌"
	<% }%>

</body>
</html>