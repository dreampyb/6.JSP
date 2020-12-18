<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body><table border="1" width="300"align="center"><tr><td>
	<center><br>
	이름:  <%=application.getAttribute("name")%><br><br>
	아이디: <%=application.getAttribute("id") %><br><br>
	이메일: <%=session.getAttribute("email") %><br><br>
	주소 :  <%=session.getAttribute("addr") %><br><br>
	전화번호 :<%=session.getAttribute("tel") %><br><br>
<!-- 	()안에는 "name"으로 -->
	</center></td></tr></table>
</body></html>