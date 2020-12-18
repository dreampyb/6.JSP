<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%@page import="javax.naming.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--방법1: --%>
 <% String status="실패";
	try{
	Context init = new InitialContext(); //javax.naming
	DataSource ds //javax.sql
	=(DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
	Connection conn=ds.getConnection(); //java.sql
	status="성공";
	}catch(Exception e){
	e.printStackTrace();
	} %> 
	<%=status %>

<%--방법2: --%>
 <% Connection conn = null; 
	try{
	Context init = new InitialContext(); //javax.naming
	DataSource ds //javax.sql
	=(DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
	conn=ds.getConnection();
	out.println("<h3>연결되었습니다</h3>");
	}catch(Exception e){
	out.println("<h3>연결에 실패하였습니다.</h3>");
	e.printStackTrace();
	} %>
</body>
</html>