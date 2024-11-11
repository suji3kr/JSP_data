<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>

<html>
<head>

<title>최하단</title>
</head>
<body>
	<%
	Date date = new Date();
	
	%>
	
	<hr/>
	include지시자의 Bottom부분 입니다.<p/>
	<%=date.toLocaleString()%>

</body>
</html>