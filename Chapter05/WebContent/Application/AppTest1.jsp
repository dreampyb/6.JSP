<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Application Test</h3>
	<table border=1 width="800" align="center" >
		<tr>
			<td>JSP버젼</td>
			<td><%=application.getMajorVersion() %></td>
		</tr>
		<tr>
			<td>컨테이너 정보</td>
			<td><%=application.getServerInfo() %></td>
		</tr>
		<tr>
			<td>웹 어플리케이션의 실제 파일 시스템경로</td>
			<td><%=application.getRealPath("/") %></td>
		</tr>
	</table>
</body>
</html>