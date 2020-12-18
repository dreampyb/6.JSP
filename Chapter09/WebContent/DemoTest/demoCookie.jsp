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
	Cookie[] demoes = request.getCookies();
	String byun=" 최근 계산 결과가 없습니다";
	if(demoes !=null){
		for(Cookie temp:demoes){
			if(temp.getName().equals("sum")){
				byun="가장 최근에 계산된 결과값은 "+
				temp.getValue()+"입니다.";
			}
		}
	}
	%>
</body>
</html>