<%@page import="vo.BoardBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><글목록 화면></head><br>
<body>
글목록 화면 입니다.<br>
<a href="boardWriteForm.board">게시글 쓰기<a><br>
<% 
ArrayList<BoardBean> boardList= (ArrayList<BoardBean>)request.getAttribute("articleList");
// BoardListAction클래스에 페이지 세팅시 

for(BoardBean temp : boardList){
	// boardList는 상위 BoardFrontController안의 boardList를 꺼내온 것 %>
	<%=temp.getBoard_num()%> &nbsp;  &nbsp;  &nbsp;
	<a href=boardDetail.board?board_num=<%=temp.getBoard_num()%>>
	<%=temp.getBoard_subject()%></a>
	 &nbsp;  &nbsp;  &nbsp;
	<%=temp.getBoard_name()%> &nbsp;  &nbsp;  &nbsp;
	<%=temp.getBoard_subject()%> &nbsp;  &nbsp;  &nbsp;
	<%=temp.getBoard_date()%> &nbsp;  &nbsp;  &nbsp;
	<%=temp.getBoard_readcount()%><br>
<%}
%><br>
<form action ="seachProcess.board" method="get">
<select name=sname>
	<option  value="board_name">작성자</option>
	<option  value="board_date">작성일</option>
	<option  value="board_subject">제목</option>
</select>
검색명: <input type="text" name="search"><input type="submit" value="전송">
</form>
</body>
</html>