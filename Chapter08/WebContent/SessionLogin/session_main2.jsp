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
	String userid = (String)session.getAttribute("id");
	if(userid==null)
		userid="로그인 해주세요";
%><br>
반갑습니다.<br>
<%=userid %>님 환영합니다.
<center><a href= "https://blog.naver.com/dreampyb">메인화면으로 가기</a></center>
</body>
</html>