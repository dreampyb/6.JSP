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
	//request.setCharacterEncoding("UTF-8");
	String name= request.getParameter("name") ;// 이름 저장
	String id= request.getParameter("id") ;		// ID 저장
	application.setAttribute("name", name);
	application.setAttribute("id", id);
	%>
	<center><h3>[영역과 속성 테스트]</h3>
	<b>"<%=name %></b>님 안녕하세요."<br>
	<b><%=name %></b>님의 id는 <b><%=id %></b>입니다
	</center>
<form action="AttributeTest3.jsp">
<table border="1" width="300" align="center">
	<tr>
		<th colspan="2">session 영역에 저장할 내용들</th>
	</tr>
	<tr>
		<td>email주소</td>
		<td><input type="email" name="email" ></td>
	</tr>
	<tr>
		<td>집주소</td>
		<td><input type="text" name="address"></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input name="telnumber" type="text" ></td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="submit" value="전송" style="width:290px">
		</td>
	</tr>
</table>
</form>
</body>
</html>