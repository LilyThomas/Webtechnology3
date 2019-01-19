<%@page import="upper.ToUpperProxy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Up yours.</title>
</head>
<body>

<form action="index.jsp" method="POST"/>
	<input type="text" name="txt">
	<input type="submit" value="Submit"/>
</form>
	
<%
	String txt = "";
	String result = "";
	
	try{
		txt = request.getParameter("txt");
		ToUpperProxy proxy = new ToUpperProxy();
		result = proxy.toUpper(txt);
		
	} catch(Exception e){
		System.out.println(e);
	}
%>
<br/><br/>
<p>Result: <%=result%></p>
</body>
</html>