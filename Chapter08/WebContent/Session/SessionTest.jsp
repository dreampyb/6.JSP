<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Session Test</title>
</head>
<% String value=(String)session.getAttribute("name");
	if(value==null) value="세션값이 없습니다";
 %>
<body>
<h2>세션 테스트</h2>
	<input type="button" name="name" , value="세션값 저장" onclick="location.href='SessionSet.jsp'">
	<input type="button" name="name" , value="세션값 삭제" onclick="location.href='SessionDel.jsp'">
	<input type="button" name="name" , value="세션 초기화" onclick="location.href='Session_invalidate.jsp'">
	<br><br>

<%-- <h3><%=session.getAttribute("name")%></h3> --%>
 <b>결과값 : </b>" <%=value %> "  
</body>
</html>