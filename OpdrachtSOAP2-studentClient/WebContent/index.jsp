<%@page import="list.ListStudentsProxy"%>
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
		ListStudentsProxy proxy = new ListStudentsProxy();
		String[] result = proxy.selectAll();

%>

<h2>Grade List</h2>
<table>
<tr>
	<td><b>Last name</b></td>
	<td><b>First name</b></td>
	<td><b>Grade</b></td>
</tr>
<%
	for(String s: result) {
		String[] fields = s.split(";");

		out.println("<tr><td>" + fields[0] + "</td>" + "<td>" + fields[1] + "</td>" + "<td>" + fields[2] + "</td></tr>");
	}

%>
</table>
</body>
</html>