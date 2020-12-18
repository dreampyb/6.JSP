<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>

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
	String driver="oracle.jdbc.driver.OracleDriver";
	String status="접속실패";
	try{
	Class.forName(driver);//DB드라이버 로딩
	Connection conn =DriverManager.getConnection(
		"jdbc:oracle:thin:@localhost:1521:XE","aaa","bbb");
	//오라클 DB 연결:  aaa와 bbb는 oracle 에 설정해 놓은 id와 pw
	status="접속성공";
	}catch(Exception e){
		e.printStackTrace();
	}
	%>
	<%=status %>
</body>
</html>