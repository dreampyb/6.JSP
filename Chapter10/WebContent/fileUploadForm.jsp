<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Upload From</title>
<style>
#uploadFormArea{width: 400px; height: "200px"; margin: auto; 
				border: 1px solid green; }
.td_title{
	font-size:xx-larde;
	text-align: center;
	}
input {
text-align: center;
}

p {text-align: center;} /* p를 클래스로 지정하여 p클래스안은 모두 {}으로 구현한다. */
</style></head>

<body>
<section id="uploadFormArea"  >

	<form action="fileUpload.jsp" method="post" enctype="multipart/form-data">
	<center><h2>파일 업로드 폼</h2></center>
	<p><label for ="name">올린사람:</label>
	<input type="text"name="name" id="name"></p>
	<p>제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목 : 
	<input type="text"name="subject" id="subject"></p>
	<p><label for ="filename1"></label>
 	<input type ="file" name="filename1" id="filename1"></p>
	<p><label for ="filename2"></label>
 	<input type ="file" name="filename2" id="filename2"></p>
	<p><input type="submit" name="name" id="submit" ></p>
	</form>
</section>
</body>
</html>