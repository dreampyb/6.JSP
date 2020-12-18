<%@page import="vo.BoardBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>글목록 화면입니다.</h2>  <a href="boardWriteForm.bo">게시글 쓰기</a> <br>
<%	
ArrayList<BoardBean> boardList= (ArrayList<BoardBean>)request.getAttribute("articleList");
for(BoardBean temp :boardList)	{ %>
	<%=temp.getBoard_num()%> &nbsp;  &nbsp;  &nbsp;
	<a href=boardDetail.bo?board_num=<%=temp.getBoard_num()%>><%=temp.getBoard_subject()%></a> &nbsp;  &nbsp;  &nbsp;
	<%=temp.getBoard_name()%> &nbsp;  &nbsp;  &nbsp;
	<%=temp.getBoard_date()%> &nbsp;  &nbsp;  &nbsp;
	<%=temp.getBoard_readcount()%> <br>
<% }%>
<br>
<form action="searchPro.bo" method="get">
<select name="select">
	<option value="subject">제목</option>
	<option value="content">내용</option>
	<option value="user">작성자</option>
</select>
<input type="text" name="sname"> <input type="submit" value="전송">
</form>

</body>
</html>



