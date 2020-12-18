<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="session_main.jsp">
	<table border="1" align="center" style width="300" height="200" >
		<tr >
			<th colspan="2"  >LOGIN </th>

		</tr>
		<tr>
			<td><p align="center"><b>아이디</b></p></td>
			<td><p align="center"><input type="text" id="id" name="id"></p></td>
		</tr>
		<tr>
			<td><p align="center"><b>비밀번호</b></p></td>
			<td><p align="center"><input type="password" id="pw" name="pw"></p> </td>
		</tr>
		<tr>
			<td><p align="center">
			<input type="submit" value="로그인" style="width: 80px; "></p> </td>
			<td><p align="center">
			<input type="reset" value="다시 작성" style="width: 160px; color: Maroon" width="200"></p> </td>
		</tr>
	</table>
</form>
</body>
</html>