<%@page import="vo.BoardBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 내용 상세보기</title>
</head>
<body>
<%
BoardBean bb = (BoardBean)request.getAttribute("abc");
// BoardDetailAction 27행에서 BoardBean속성을 불러오느라  만들었던 'name'
%>
<h2>(<%=bb.getBoard_num() %>)번글 내용 상세보기</h2>
제목: <%=bb.getBoard_subject() %> <br>
첨부파일: <%=bb.getBoard_file() %> <br>
내용:  <%=bb.getBoard_content() %> <br>

<a href=#>답변</a>&nbsp;
<a href=#>수정</a>&nbsp; 
<a href="boardDeleteForm.board?delete_num=<%=bb.getBoard_num() %>">삭제</a>
&nbsp; <!--  controller의 boardDeleteForm의 delete_num -->
<a href=#>목록</a>
</body>
</html>