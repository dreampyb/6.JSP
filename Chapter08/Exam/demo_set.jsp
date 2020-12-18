<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="loginprint.jsp" method="get">

	<table border="1" align="center" width="250">
		<tr>
			<th height="30" colspan="2"><b>[회원가입 ]</b></th>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr >
			<td >ID</td>
			<td><input type="text" name="id"></td>
		</tr >
		<tr>
			<td >PW</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td align="center" colspan="2"><b><br><input type="submit" value="가입" 
			style width="200"></b><br><br></td>
		</tr>
	</table>

</form>
</body>
</html>