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
	Cookie[] bisket =request.getCookies();
	String c_name="이름없음";
	String c_value="값없음";
	if(bisket==null){
		for(Cookie temp:bisket){  // temp 용법 체크!!
			c_name=temp.getName();
			c_value=temp.getValue();

		}
	}
%>
[쿠키정보 ]<br>
쿠키이름 : <%=c_name %><br>
쿠키 값 : <%=c_value %><br>

<a href="cookie_test1.jsp"> 값 불러 오기 </a>
</body>
</html>