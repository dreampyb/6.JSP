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
	String cookie = request.getHeader("cookie");//쿠키를 확인
	String lang="KOR";
	if(cookie!=null){					// 쿠기가 있다면?
		Cookie[] c= request.getCookies();// 쿠키를 가져온다
		for(Cookie temp:c){				// 쿠키를 하나씩 확인한다.
			if(temp.getName().equals("lang")){ //쿠기중 lang이란 이름의 쿠키가 있는지 확인
				 lang=temp.getValue();  //그 쿠키값을 읽어온다.
		}
	}
}
%>
<%if(lang.equals("KOR")){%>
<h3>안녕하세요. 이것은 쿠키 예제입니다.</h3>
<%}else{%>
<h2>"Hello, Learn Korean language!"</h2>
<%}%>
<form action="cookie_test2.jsp" method="get">
 	<p align="center">
 	<input type="radio" name="lang" value="KOR"
 	<%if(lang.equals("KOR")){ %>
 	checked    <% } %>
 	>한국어 페이지 보기<br>
 	<input type="radio" name="lang" value="ENG"
 	<%if(!lang.equals("KOR")){%>
 		checked  <%}%>
 	>영어 페이지 보기<br>
 	<input  type="submit" value="설정"><br>
 쿠키값은 :	<%=cookie %>
</p></form>
 </body>
</html>