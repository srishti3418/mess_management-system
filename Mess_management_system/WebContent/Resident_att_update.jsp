<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
	color: #4CAF50;
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

input[type="text"]{
  display: block;
  box-sizing: border-box;
  margin-bottom: 20px;
  padding: 4px;
  width: 220px;
  height: 32px;
  border: none;
  border-bottom: 1px solid #4CAF50;
  border-left: 1px solid #4CAF50;
  font-family: 'Roboto', sans-serif;
  font-weight: 400;
  font-size: 15px;
  transition: 0.2s ease;
}

input[type="text"]:focus,
input[type="text"]:hover{
  border-bottom: 2px solid #4CAF50;
  border-left: 2px solid #4CAF50;
  color: #4CAF50;
  transition: 0.2s ease;
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
table{
	font-family: arial, sans-serif;
	width: 100%;
}\n
td{ 
	border: 1px solid #dddddd;
	text-align: center; 
	padding: 8px;
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
<div id = 'admin'>
<h4>Resident Attendence</h4>
<form action="ResidentAttendanceUpdateServlet" method="post">
			<table style="with: 50%">
				<tr>
					<td>Resident ID</td>
					<td><input type="text" name="rid" /></td>
				</tr>
				<tr>
					<td>Date</td>
					<td><input type="text" name="dat" /></td>
				</tr>
				<tr>
					<td>Breakfast</td>
					<td><input type="text" name="bre" /></td>
				</tr>
				<tr>
					<td>Lunch</td>
					<td><input type="text" name="lun" /></td>
				</tr>
				<tr>
					<td>Snacks</td>
					<td><input type="text" name="sna" /></td>
				</tr>
				<tr>
					<td>Dinner</td>
					<td><input type="text" name="din" /></td>
				</tr>
				<tr>
					<td>Meals Skipped today</td>
					<td><input type="text" name="nms" /></td>
				</tr>

			</table>
			<input type="submit" value="Submit" /></form>
</body>
</html>