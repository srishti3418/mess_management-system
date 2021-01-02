<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<h1>Give the id of the user whose complaint has been solved to mark it as RESOLVED!! </h1>
<%
String res_id = (String) session.getAttribute("re_id");
session.setAttribute("resi_id",res_id);
%>
<form action="AddComplaintServlet" method="post">
			<table style="with: 50%">
			
				<tr>
					<td>Name:</td>
					<td><input type="text" name="nam" /></td>
				</tr>
				<tr>
					<td>COMPLAINT:</td>
					<td><input type="text" name="com" /></td>
				</tr>

			</table>
			<input type="submit" value="Submit" /></form>
</body>
</html>