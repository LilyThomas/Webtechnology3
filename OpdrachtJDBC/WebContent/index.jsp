<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Grade a student</title>
</head>
<body>

<form method="POST" action="result.jsp">
	<p>Firstname: <input type="text" name="firstname" size=20></p> <br/>
	<p>Lastname:  <input type="text" name="lastname" size=20></p> <br/>
	<p>Grade:  <input type="number" name="grade" size=3> </p><br/>
	<br/>
	
	<input type="submit" value="Save"> 
</form>

<a href="grades.jsp">List of grades</a>

</body>
</html>