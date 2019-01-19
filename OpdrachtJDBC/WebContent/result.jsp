<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.ArrayList" %>
<%@ page import="jdbc.JDBCconnection" %>
<jsp:useBean id="student" class="student.Student" scope="session" />
<jsp:setProperty property="*" name="student"/>

<%
JDBCconnection connection = null;
ArrayList<String> students = null;

try{
	String firstname = student.getFirstname();
	String lastname = student.getLastname();
	int grade = student.getGrade();
	System.out.println(firstname);
	System.out.println(lastname);
	System.out.println(grade);
	
	connection = JDBCconnection.getJDBCconnection();
	connection.openConnection("students", "root", "MySqlPass");
	String insertSQL = "INSERT INTO GRADES(lastname, firstname, grade) " +
		"VALUES('" + lastname + "','" + firstname + "'," + grade + ");";
	System.out.println(insertSQL);
	connection.executeInsert(insertSQL);
	
	String selectSQL = "SELECT * FROM GRADES ORDER BY lastname;";
	students = connection.selectAll(selectSQL);
} 
catch(Exception e) {
	System.out.println(e);
}
finally {
	connection.closeConnection();
}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result</title>
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