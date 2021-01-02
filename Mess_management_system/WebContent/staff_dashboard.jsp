<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
h1{
	text-align: center;
  	color: #4CAF50;
  	font-family: 'Roboto', sans-serif;	
}
h4{
	text-align: left;
  	color: #4CAF50;
  	font-family: 'Roboto', sans-serif;	
}
#dashboard {
  position: absolute;
  top: 120px;
  width: 250px;
  height: 320px;
  background: #FFF;
  border-radius: 2px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
}

.leftcolumn{
  position: absolute;
  top: 0;
  left: 0;
  box-sizing: border-box;
  padding: 10px;
  width: 150opx;
}

input[type="submit"] {
  
  width: 230px;
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
</style>
<meta charset="ISO-8859-1">
<title>Mess Management System</title>
</head>
<body style="background-image: url('1-05082.jpg'); background-size: cover;">
<h1>Mess Management System</h1>
<h4>Logged in as Staff Member</h4>
<div id="dashboard">
  <div class="leftcolumn">
  <form action = "pd_staffServlet">
    <input type="submit" value="Personal details"></form>
    <form action = "menuServlet">
    <input type="submit" value="Menu"></form>
    <form action = "StaffRpServlet">
    <input type="submit" value="Report"></form>
    <form action = "NetSalaryServlet">
    <input type="submit" value="Net Salary Payment"></form>
    <form action = "complaintServlet">
    <input type="submit" value="Complaints"></form>
    <form action = "complaintStatusServlet">
    <input type="submit" value="Complaint Status"></form>
  </div>
</div>
</body>
</html>