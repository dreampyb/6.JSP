<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Enumeration" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.loginFormArea{
	text-align:center;
	width: 250px;
	margin: auto;
	border: 1px solid green;
	}
h1 { text-align:center;}
h1,#commandcell{text-align:bottom;}
</style>
</head>
<body>


<section class="loginFormArea" style="width: 600px; height:auto">
<h2>Request 예제입니다.</h2>
이름 : <%=request.getParameter("name") %><br>
성별 : <%--  <%=request.getParameter("gender") %> --%>

<% if(request.getParameter("gender").equals("male")){ %>
남자
<%}else{ %>
여자
<%} %><br>
취미 : <% String[] hobby =request.getParameterValues("hobby");
//for(int i=0; i<hobby.length; i++) {
	for(String str:hobby){
%>
<%=//hobby[i]
		str%> &nbsp; &nbsp;
<%} %>
<br>좋아하는 음식은 :
<%	String num=request.getParameter("no");
	if(num.equals("1")){
		%>	한식
	<% }else if(num.equals("2")){ %>
		중식
	<% }else if(num.equals("3")){%>
		양식
	<% }else if(num.equals("4")){%>
		일식
	<% }else{%>
		뷔폐
	<% }%>
</section>

<br> <h3><center>[Header] </center></h3>
<% Enumeration e=request.getHeaderNames(); //요청객체에서 헤더드르이 이름을 읽는다.
while(e.hasMoreElements()){ //더이상 헤더의 이름이 없으면
	String headerName=(String)e.nextElement();
	String headerValue=request.getHeader(headerName);
	//읽어온 헤더이름으로 헤더값을 가져온다.
	%><br><br>
	<b><%=headerName%></b> &nbsp; &nbsp;
<%-- 	<%=headerValue%> --%>  <br>
	<%=request.getHeader(headerName) %>
<%	//System.out.println(headerName +"   ");
	//System.out.println(headerValue );
}
%><br>
<% if(request.getHeader("user-agent").equals("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.111 Safari/537.36"))
{%> <br><b>result</b> : 이클립스 내부 브라우져입니다.
<% }else{%>
이클립스 내부 브라우져가 아닙니다.
<% }%>	
<br>

</body>
</html>