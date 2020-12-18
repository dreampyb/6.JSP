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
	int n1=Integer.parseInt(request.getParameter("n1"));
	int n2=Integer.parseInt(request.getParameter("n2"));
	int n3=Integer.parseInt(request.getParameter("n3"));
	int sum = n1+n2+n3;
	
	Cookie demo = new Cookie("sum",Integer.toString(sum));
	response.addCookie(demo);
%>

	<table border="1" align="center">
		<tr>
			<th>세가지 숫자의 합을 구하는 식</th>
		</tr>
		<tr>
			<td>
			NUM1: <input type="number" name="n1" value=<%=request.getParameter("n1") %>><br>
			NUM2: <input type="number" name="n2" value=<%=request.getParameter("n2") %>><br>
			NUM3: <input type="number" name="n3" value=<%=request.getParameter("n3") %>><br>
			<p align="center">
			<input type="submit" value="계산">
			</p>
		</tr>
		<tr>
 			<td>결과값은: <%--<%=n1 %>+<%=n2%>+<%=n3%>의 합은 <%=sum %>  --%>
			<%=sum %>
			</td>
		</tr>
	</table>
</body>
</html>