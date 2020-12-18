<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
디스패쳐(dispatcher)방식으로 보낼 때<br>
페이지밸뷰는= <%=pageContext.getAttribute("pageScope") %><br>
리퀘스트밸뷰는=<%=request.getAttribute("requestScope") %>
</body>
</html>