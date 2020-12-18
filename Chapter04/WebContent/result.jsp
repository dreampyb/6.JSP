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
	String num1=request.getParameter("n1");
	String num2=request.getParameter("n2");
	int n1 = Integer.parseInt(num1);
	int n2 = Integer.parseInt(num2);
	int n3 = n1 % n2;
	%>
	<%=n1%>을 <%=n2 %>로 나눈값은<br>
	<b><%=n3 %></b>입니다.

</body>
</html>