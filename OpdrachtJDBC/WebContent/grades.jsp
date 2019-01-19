<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="jdbc.JDBCconnection" %>
<%@ page import="java.util.ArrayList" %>

<% 
JDBCconnection connection = null;
ArrayList<String> students = null;

try {
	
	connection = JDBCconnection.getJDBCconnection();
	connection.openConnection("Students", "root", "MySqlPass");
	
	String selectSQL = "SELECT * FROM GRADES;";
	students = connection.selectAll(selectSQL);
}
catch(Exception e) {
	System.out.println("error: " + e);
}
finally {
	connection.closeConnection();
}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List students</title>
</head>
<body>
<br/><br/>
<h2>Grade List</h2>
<table>
<tr>
	<td><b>Last name</b></td>
	<td><b>First name</b></td>
	<td><b>Grade</b></td>
</tr>
<%
	for(String s: students) {
		String[] fields = s.split(";");

		out.println("<tr><td>" + fields[0] + "</td>" + "<td>" + fields[1] + "</td>" + "<td>" + fields[2] + "</td></tr>");
	}

%>
</table>
</body>
</html>