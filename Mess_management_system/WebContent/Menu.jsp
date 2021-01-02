<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.sql.*" %>
<%@ page import="java.io.IOException"%>
<%@ page import="javax.servlet.RequestDispatcher" %>
<%@ page import="javax.servlet.ServletException" %>
<%@ page import="javax.servlet.annotation.WebServlet" %>
<%@ page import="javax.servlet.http.HttpServlet" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.io.*" %>
<html>
<head>
<title>Menu</title>
<style>
h1{
	text-align: center;
  	color: #4CAF50;
  	font-family: 'Roboto', sans-serif;	
}
h4{
	position: absolute;
	top: 100px;
	left: 60px;
	text-align: left;
  	color: #4CAF50;
  	font-family: 'Roboto', sans-serif;	
}
table, th, td {
  border: 1px solid #4CAF50;
  padding: 10px;
  text-align: center;
}
#table {   
	position: absolute; 
	top: 150px; 
	left: 60px; 
	right: auto; 
	margin-bottom: 40px; 
	padding: 10px; background: #FFF; 
	border-radius: 2px; 
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
}

</style>
</head>
<body style="background-image: url('1-05082.jpg'); background-size: cover;">
<h1>Mess Management System</h1>
<h4>Mess menu: </h4>
</div>
<%
try {
	Connection con = null;
	String url = "jdbc:postgresql://localhost:5432/mmsystem";
	String username = "universityDB0022";
	String password = "123456";
	
	Class.forName("org.postgresql.Driver");
	con = DriverManager.getConnection(url, username, password);
	System.out.println("Printing connection object "+con);
	
	String[] arr = {"Sunday","Monday", "Tuesday", "Wednesday", "Thursday","Friday","Saturday"};
	
	PreparedStatement stmt = con.prepareStatement("select day,breakfast,lunch,snacks,dinner from menu");
	ResultSet rs = stmt.executeQuery();
%>
<div id = "table">
<table>

<tr>

<td>Day</td>
<td>Breakfast</td>
<td>Lunch</td>
<td>Snacks</td>
<td>Dinner</td>

</tr>


<%

while (rs.next()) {

%>

<tr>

<td><%=arr[rs.getInt(1)]%></td>
<td><%=rs.getString(2)%></td>
<td><%=rs.getString(3)%></td>
<td><%=rs.getString(4)%></td>
<td><%=rs.getString(5)%></td>

</tr>

<% 
}
%>

<%

rs.close();
stmt.close();
con.close();
} catch (Exception ex) {
	
%>

<font>
<font size="+3" color="red"></b>

<%
out.println("Unable to connect to database.");
}
%>
</font>
</table>
</div>
</body>
</html>