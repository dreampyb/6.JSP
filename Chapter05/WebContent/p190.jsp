<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키 , URL/URI 요청방식에  관련된  정보 예제</h1>
	<%--만들표가 11행 2열 --%>
		<%	Cookie[] cookie=request.getCookies();
		if (cookie==null){
		System.out.println("쿠키가 존재하지 않습니다");
	}else{
		for(Cookie temp:cookie){
			System.out.println(temp.getName());// 쿠기의 이름.
			System.out.println(temp.getValue()); //쿠키의 값.
		}
	}
	%>
	
	<table border=1 width="800">
		<tr>
			<th>쿠키이름</th>
			<th>쿠키값</th>
		</tr>
		<tr>
			<td>쿠키정보</td>
			<%	Cookie[] cookie1=request.getCookies();
			
			if (cookie1==null){ %>
				<td>"쿠키가 존재하지 않습니다"</td>
			<%}else{%>
			<td>
			<%	for(Cookie temp:cookie1){%>
			<%=temp.getName()%><br>
			(<%=temp.getValue()%>),
			<%}
			} %>
			</td>
		</tr>
				<tr>
			<td>서버도메인명</td>
			<td>localhost</td>
		</tr>
				<tr>
			<td>서버 포트 번호</td>
			<td><%=request.getServerPort() %></td>
		</tr>
				<tr>
			<td>요청URL</td>
			<td><%=request.getRequestURL() %></td>
		</tr>
				<tr>
			<td>요청URI</td>
			<td>><%=request.getRequestURI() %></td>
		</tr>
				<tr>
			<td>요청 쿼리</td>
			<td><%=request.getQueryString() %></td>
		</tr>
				<tr>
			<td>클라이언트 호스트명</td>
			<td><%=request.getRemoteHost() %></td>
		</tr>
				<tr>
			<td>클라이언트 IP주소</td>
			<td><%=request.getRemoteAddr() %></td>
		</tr>
				<tr>
			<td>프로토콜</td>
			<td><%=request.getProtocol() %></td>
		</tr>
				<tr>
			<td>요청방식</td>
			<td><%=request.getMethod() %></td>
		</tr>
				<tr>
			<td>컨텍스트 경로</td>
			<td><%=request.getContextPath() %></td>
		</tr>
	</table>

</body>
</html>