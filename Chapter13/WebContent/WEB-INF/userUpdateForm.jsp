<%@page import="java.sql.*"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.*"%>
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
//1.사용자 id를 읽어온다.(세션의 id를 읽어온다.)
String id = (String)session.getAttribute("id");
//2.id를 가지고 db에 접속해 해당정보를 보여준다.(form 형태로)
//2-1. DB에 접속한다.
Connection conn=null;
PreparedStatement pstmt=null;
ResultSet rs=null;
try{
	Context init = new InitialContext();
	DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	conn=ds.getConnection(); 
//2-2. 쿼리를 만들어 수행한다.
	pstmt=conn.prepareStatement("SELECT * FROM AAA.MEMBER WHERE ID=?");
	pstmt.setString(1, id);		//첫번째 물음표에 id값을 넣어라
	rs=pstmt.executeQuery();	//쿼리 실행
	rs.next();	//첫번째 행을 가르친다.
}catch(Exception e){
e.printStackTrace();
}
%>
<!-- 3.수정후 submit 버튼을 누르면 updateProcess.jsp로 이동한다. -->
<!-- 3-1. 가져온 내용을 form을 이용해 출력한다.(value 속성이용) -->
<!-- 3-2. 수정버튼 누를때 updateProcess.jsp 로 해당값들을 가지고(post) 이동한다. -->
<form name="joinForm" action="updateProcess.jsp" method="post">
<table border="1">
	<tr>
		<td colspan="2">회원수정 페이지</td>   
	</tr>
	<tr>
		<td><label for ="id">아이디:</label> </td>   <td><input type="text" name="id" id="id"  value="<%=rs.getString("id") %>"
			readonly	></td>
	</tr>
	<tr>
		<td>비밀번호:</td>   <td><input type="password" name="password" 	
			value="<%=rs.getString("password") %>"></td>
	</tr>
	<tr>
		<td>이름:</td>   <td><input type="text" name="name"
				value="<%=rs.getString("name") %>"></td>
	</tr>
	<tr>
		<td>나이:</td>   <td><input type="number" name="age"
				value="<%=rs.getString("age") %>"></td>
	</tr>
	<tr>
		<td>성별:</td>   <td><input type="radio" name="gender" value="남" 
<% 	if(rs.getString("gender").equals("남")){ %>	checked <% 	} %> >남자
							 <input type="radio" name="gender" value="여"
<% if(rs.getString("gender").equals("여")){ %>	checked <% 	} %>
							 >여자</td>
	</tr>
	<tr>
		<td>이메일 주소:</td>   <td><input type="email" name="email"
		value="<%=rs.getString("email") %>"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="수정">
		                <input type="reset" value="다시작성">  </td>
	</tr>
</table>
</form>



</body>
</html>




