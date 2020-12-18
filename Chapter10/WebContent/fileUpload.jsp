<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
	String uploadPath=request.getRealPath("/upload");//upload라는 폴더에 파일을 올린다.
    int size=1024*1024*10;        //byte단위 10Mbyte
	System.out.println(uploadPath);
	MultipartRequest multi =new MultipartRequest(
			request,uploadPath,size,"UTF-8", new DefaultFileRenamePolicy());
	
	String name=multi.getParameter("name");
	String subject=multi.getParameter("subject");
	
	Enumeration files=multi.getFileNames();//파일타입의 입력상자 이름(name)읽기
	String file1=(String)files.nextElement();//첫번째 파일상자 이름읽기
	String file2=(String)files.nextElement();// 두번째 파일 상자 이름읽기
	
	String filename1=multi.getFilesystemName(file1);// 첫번째 파일이 실제로 저장된 이름 읽기
	String filename2=multi.getFilesystemName(file2);// 두번째  파일이 실제로 저장된 이름 읽기
	
	String origfilename1=multi.getOriginalFileName(file1);//업로드시의 첫번째 파일이름 읽기
	String origfilename2=multi.getOriginalFileName(file2);//업로드시의 두번째 파일이름 읽기
%>	
	실제 업로드 경로<%=uploadPath %>
	<hr>
	1번 파일 상자 name: <%=file1 %><br>
	2번 파일 상자 name: <%=file2 %><br>
	<hr>
	1번 파일이름이 저장된 이름: <%=filename1 %><br>
	2번 파일이름이 저장된 이름:<%=filename2 %><br>
	<hr>
	1번 파일의 원래 이름: <%=origfilename1 %><br>
	2번 파일의 원래 이름: <%=origfilename2 %><br>
	<hr>
	다운로드 테스트
	<a href="upload/<%=filename1 %>"><%=origfilename1 %></a><br>
	<a href="upload/<%=filename2 %>"><%=origfilename2 %></a>
<%--<a href="/upload/<%=filename2 %>"><%=origfilename2 %>로 하면 /로 시작하므로 절대경로로서 모든 경로를 다 써줘야 한다. --%>
	
	
	
</body>
</html>