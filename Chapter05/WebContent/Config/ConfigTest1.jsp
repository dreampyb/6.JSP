<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Config내에 값들을 읽어오기 위해서 이름-값으로 이루어졌기 때문에 먼저 이름을 찾는다<br>
<%
Enumeration e=config.getInitParameterNames();
//Enumeration를 타자치지 말고 찾아써야 import가 된다.
	while(e.hasMoreElements()){
	String pName=(String)e.nextElement();%>
		<%=pName %>:<br>
	// String value=config.getInitParameter(pName);<br>
		<%=config.getInitParameter(pName)%>
	<% }
%>
</body>
</html>