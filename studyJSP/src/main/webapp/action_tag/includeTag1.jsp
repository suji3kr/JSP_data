<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Include Tag</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String name = "Korea football";
%>
<%=name%>
<h1>Include Tag Example</h1>
<jsp:include page="includeTop1.jsp"/>
include ActionTag의 Body입니다.
</body>
</html>