<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><h3> [영역과 속성 테스트] </h3></center>
<marquee>"<b><%=(String)application.getAttribute("name") %>"</b>님의 정보가 저장되었습니다.</marquee>
<center><a href="AttributeConfirm.jsp">확인하러 가기</a></center>
<%
session.setAttribute("email", request.getParameter("email"));
session.setAttribute("addr", request.getParameter("address"));
session.setAttribute("tel", request.getParameter("telnumber"));
//session.setAttribute("표시할 것", request.getParameter("name"));
%>
</body>
</html>