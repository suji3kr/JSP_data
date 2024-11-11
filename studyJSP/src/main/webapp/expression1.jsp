<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expression Example1</title>
</head>
<body>
<h1>Expression Example1</h1>
<%!

	String name[]= {" ", "java","jsp","android", "structs"};

%>

<table border ="1" width ="200">
<% for(int i =1; i<name.length;i++){%>
	<tr>
	<td><%=i%></td><td><%=name[i]%></td>
	</tr>
<%}%>

</table>
</body>
</html>