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
<style>
h1{
	text-align: center;
  	color: #4CAF50;
  	font-family: 'Roboto', sans-serif;	
}
h2{
	text-align: center;
  	color: #4CAF50;
  	font-family: 'Roboto', sans-serif;	
}
#dashboard {
  position: absolute;
  top: 120px;
  width: 310px;
  height: 600px;
  padding: 10px;
  background: #FFF;
  border-radius: 2px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
}
#admin{
	position: absolute;
	top: 120px;
	left: 350px;
	right: 50px;
	padding: 10px;
  	background: #FFF;
  	border-radius: 2px;
  	text-align: center;
  	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
}

.leftcolumn{
  position: absolute;
  top: 0;
  left: 0;
  box-sizing: border-box;
  width: 150opx;
}

input[type="submit"] {
  
  width: 300px;
  height: 50px;
  border-radius: 2px;
  font-family: 'Roboto', sans-serif;
  font-weight: 500;
  border: none;
  background: #FFF;
  color: #4CAF50;
  border-bottom: 2px solid #4CAF50;
  text-transform: uppercase;
  transition: 0.1s ease;
  cursor: pointer;
}

input[type="submit"]:hover,
input[type="submit"]:focus {
  opacity: 0.8;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
  transition: 0.1s ease;
}
table { 
	font-family: arial, sans-serif; 
	border-collapse: collapse; 
	width: 100%;
}
td, th{
	border: 1px solid #dddddd; 
	text-align: center; 
	padding: 8px; 
}
tr:nth-child(odd) {
	background-color: rgba(80, 175, 82, 0.25);
}
</style>
<title>Admin Page</title>
</head>
<body style="background-image: url('1-05082.jpg'); background-size: cover;">
<h1>Mess Management System</h1>
<div id = "dashboard">
<form action="Resident_att_update.jsp">
    <input type="submit" value="Update Attendance for RESIDENTS" />
</form>
<form action="Staff_att_update.jsp">
    <input type="submit" value="Update Attendance for STAFFS" />
</form>
<form action="MessBill.jsp">
    <input type="submit" value="Net Mess Bill" />
</form>
<form action="ResidentRefundServlet" method="post">
    <input type="submit" value="Handle refunds" />
</form>
<form action="SeeComplaints.jsp">
    <input type="submit" value="View to Resolve the Complaints" />
</form>
<form action="AddResident.jsp">
    <input type="submit" value="Add a Resident" />
</form>
<form action="AddStaff.jsp">
    <input type="submit" value="Add a Staff member" />
</form>
<form action="AddAdmin.jsp">
    <input type="submit" value="Add an Admin" />
</form>
<form action="netsalarystaffmembers.jsp">
    <input type="submit" value="net salary of staffmembers" />
</form>
<form action="menuUpdate.jsp">
    <input type="submit" value="Update Menu" />
</form>
<form action="DeleteUser.jsp">
    <input type="submit" value="Delete a user" />
</form>
<form action="Change.jsp">
    <input type="submit" value="Change Password" />
</form></div>
<div id = 'admin'><h2>Net salary of staff members</h2>

<%
try {
	
	Connection con = null;
	String url = "jdbc:postgresql://localhost:5432/mess"; //PostgreSQL URL and followed by the database name
		String username = "srishtisuman"; //PostgreSQL username
		String pass = "123"; //PostgreSQL password
	
	Class.forName("org.postgresql.Driver");
	con = DriverManager.getConnection(url, username, pass);
	System.out.println("Printing connection object "+con);
	
	int cst = 20;
	PreparedStatement stmt = con.prepareStatement(" select s_id,(salary_paid-cost) as netSalary from paid natural join ( select s_id,nm*(?) as cost from(select s_id,sum(meals_eaten) as nm from staff_att group by s_id) as exp) as temp;");
	stmt.setInt(1,cst);
	ResultSet rs = stmt.executeQuery();
	
%>

<table>

<tr>

<th>Staff ID</th>
<th>Net Salary</th>

</tr>


<%

while (rs.next()) {

%>

<tr>

<td><%=rs.getString(1)%></td>
<td><%=rs.getInt(2)%></td>

</tr>

<% } %>

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
</div></body>
</html>