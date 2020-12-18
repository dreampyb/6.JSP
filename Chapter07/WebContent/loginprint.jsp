<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="250" align="center">
	<tr>
		<td> 이름</td>
		<td><%=request.getParameter("name") %></td>
	</tr>
	<tr>
		<td>ID</td>
		<td><%=request.getParameter("id")%></td>
	</tr>
		<tr>
		<td>PW</td>
		<td><%=request.getParameter("password")%></td>
	</tr>
		<tr>
		<td>주소</td>
		<td><%=request.getParameter("address") %></td>
	</tr>
		<tr>
		<td>TEL</td>
		<td><%=request.getParameter("tel") %></td>
	</tr>
</table>
</body>
</html>