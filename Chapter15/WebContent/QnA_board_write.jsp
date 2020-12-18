<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body><center>Q&A</center>
<form action="boardWritePro.board" method="post">
<table border="1" align="center" width="360">
	<tr>
		<td>글쓴이 </td>
		<td><input type="text" name="board_name" ></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="board_pass" ></td>
	</tr>
	<tr>
		<td>제목</td>
		<td><input type="text" name="board_subject" ></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea name="board_content" ></textarea></td>
	</tr>
	<tr>
		<td>파일 첨부</td>
		<td ><input type="file" name="board_file" value="찾아보기"></td>
	</tr>
</table>
<br><center><input type="submit" name="전송" value="등록">&nbsp;&nbsp;
			<input type="reset" name="reset" value="다시쓰기"></center><br>
</form>
</body>
</html>