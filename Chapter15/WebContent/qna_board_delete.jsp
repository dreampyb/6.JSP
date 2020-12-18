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
//String str_num=request.getParameter("num");
String str_num=(String)request.getAttribute("brddelnum");
%>
<form action="boardDeletePro.board?num=<%=str_num%>" method="post">
글비밀번호: <input type="password" name="input_pass">
		<input type="submit" name="삭제">
		<input type="button" name="돌아가기" onClick="javascript:history.go(-1)">
</form>

</body>
</html>