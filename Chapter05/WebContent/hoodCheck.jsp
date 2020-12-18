<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="hood.jsp" method="get">
		숫자 : <input type="number" name="no" >
		음식 : 한식<input type="checkbox" name="hood" >
			중식<input type="checkbox" name="hood" >
			양식<input type="checkbox" name="hood" >
			일식<input type="checkbox" name="hood" >
			뷔폐<input type="checkbox" name="hood" >
			<input type="submit" value="전송" id="commandcell">
	</form>
</body>
</html>