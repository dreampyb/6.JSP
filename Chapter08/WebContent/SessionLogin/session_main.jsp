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
	String name = request.getParameter("name");
	String location = request.getParameter("location");
	session.setAttribute("dreampyb", id);
// 로그인 성공시
%>	
  <table border="1" align="center" width="200" height="150">
  	<tr>
  		<th colspan="2"><b>"<%=request.getParameter("id")%>"</b>님 <br>어서오세요.</th>
  	</tr>
  	<tr>
  		<td><b>아이디</b></td>
  		<td><%=request.getParameter("id")%>
  		</td>
  	</tr>
  	<tr>
  		<td><b>접속지역</b></td>
  		<td><%=request.getParameter("location") %>
  		</td>
  	</tr>
  	
  </table><br>
  <center><a href= "logout.jsp">로그인 화면으로</a></center>
  <center><a href= "https://blog.naver.com/dreampyb">메인화면으로 가기</a></center>
<!-- 	<a href="session_main2.jsp" >로그인 확인</a> -->

</body>
</html>

