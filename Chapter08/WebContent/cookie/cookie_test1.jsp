<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%  int expr = 365*24*60*60; // 1년단위 초값의 변수화
	Cookie guaja =new Cookie("c_name", "YBP");
	guaja.setMaxAge(365*24*60*60);// 1초단위이므로 1년 표시
	response.addCookie(guaja);  // guaja값을 가져온다
%>
내가 만든 쿠키이름 : <%=guaja.getName() %><br>
내가 만든 쿠키 값 : <%=guaja.getValue() %><br>
내가 만든 쿠키 유효기간 : <%=guaja.getMaxAge() %><br>
<a href="cookie_test2.jsp"> 쿠키의 값을 불러다오</a>
</body>
</html>