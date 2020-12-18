<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%session.setMaxInactiveInterval(10); %>
<!-- ()안의 시간이 지나면 true로 리턴한다 -->

	<table border=1 width=800 height=300  align=center >
		<tr >
			<td>신규세션:</td>
			<td> <%=session.isNew() %></td>
			<td>새로운 세션이면TRUE, 기존세션이면 false를 리턴한다 </td>
		</tr>
		<tr>
			<td>생성시간:</td>
			<td> <%=session.getCreationTime() %></td>
			<td>1970년1월1일부터 해당세션 생성순간까지를 밀리초로 계산하여  long형으로리턴</td>
		</tr>
		<tr>
			<td>최종접속시간:</td>
			<td><%=session.getLastAccessedTime() %></td>
			<td>epoch로부터 해당세션에 마지막으로 접근된 시간까지의 경과 시간을 밀리초로 long형으로 리턴</td>
		</tr>
		<tr>
			<td>세션ID:</td>
			<td> <%=session.getId() %></td>
			<td>해당세션의 세션id를 <b>문자열로</b> 리턴<br>
			세션id는 session 객체생성시에 웹컨터이너에 의해 자동으로 할당된다.</td>
		</tr>
	</table>
</body>
</html>