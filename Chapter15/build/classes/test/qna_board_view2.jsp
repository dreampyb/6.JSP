<%@page import="vo.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% BoardBean ccc = (BoardBean)request.getAttribute("bbb");

%>
<h2>글 내용 상세보기</h2>
제목: <%=ccc.getBoard_subject() %> <br>
첨부파일: <%=ccc.getBoard_file() %> <br>
내용:  <%=ccc.getBoard_content() %> <br>

<a href=#>답변</a><a href=#>수정</a><a href=#>삭제</a><a href=#>목록</a>

</body>
</html>