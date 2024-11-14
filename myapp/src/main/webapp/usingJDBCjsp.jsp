<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*, java.util.*" %>
<%
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    String id = "",
           pwd = "",
           name = "",
           num1 = "",
           num2 = "",
           email = "",
           phone = "",
           zipcode = "",
           address = "",
           job = "";
    
    int counter = 0;
    
    try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "dbuser", "12345");
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM tblRegister");
    } catch (SQLException sqlException) {
        System.out.println("SQL Exception: " + sqlException.getMessage());
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./css/style.css" rel="stylesheet" type="text/css">
<title>JSP에서 DATABASE연동</title>
</head>
<body bgcolor="#FFFFCC">
    <h1>JSP 스크립트에서 DB연동 예제</h1>
    <h3>회원정보</h3>
    <table bordercolor="#000ff" border="1">
        <tr>
            <td><strong>ID</strong></td>
            <td><strong>PWD</strong></td>
            <td><strong>NAME</strong></td>
            <td><strong>NUM1</strong></td>
            <td><strong>NUM2</strong></td>
            <td><strong>EMAIL</strong></td>
            <td><strong>PHONE</strong></td>
            <td><strong>ZIPCODE/ADDRESS</strong></td>
            <td><strong>JOB</strong></td>
        </tr>
        <%
            if (rs != null) {
                while (rs.next()) {
                    id = rs.getString("id");
                    pwd = rs.getString("pwd");
                    name = rs.getString("name");
                    num1 = rs.getString("num1");
                    num2 = rs.getString("num2");
                    email = rs.getString("email");
                    phone = rs.getString("phone");
                    zipcode = rs.getString("zipcode");
                    address = rs.getString("address");
                    job = rs.getString("job");
        %>
        <tr>
            <td><%=id%></td>
            <td><%=pwd%></td>
            <td><%=name%></td>
            <td><%=num1%></td>
            <td><%=num2%></td>
            <td><%=email%></td>
            <td><%=phone%></td>
            <td><%=zipcode%>/<%=address%></td>
            <td><%=job%></td>
        </tr>
        <%
                counter++;
                }
            }
        %>
    </table>
    <br/>
    Total records: <%= counter %>
    <%
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    %>
</body>
</html>
