<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Template Test</title>

</head>
<body>
<% String pagefile= request.getParameter("page");
	if(pagefile==null){
		pagefile="bestitem";
	}
	// pagefile+ =".jsp";
%>
	<table border="1" width="800">
		<tr>
			<td colspan="2" align="center">TABLE MASTER</td>
		</tr>
		<tr>
			<td align="center"><jsp:include page="top.jsp"/></td>
			<td rowspan="2"><jsp:include page='<%=pagefile+".jsp" %>'/></td>
		</tr>
		<tr>
			<td  width="100"><jsp:include page="left.jsp"/></td>

		</tr>
		<tr >
			<td colspan="2"><jsp:include page="bottom.jsp"/></td>
		</tr>
	</table>
</body>
</html>