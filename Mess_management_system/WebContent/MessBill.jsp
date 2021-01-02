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
<%@ page import="java.util.*" %>
 
<html>
<head>
<title>Missed Meals</title>
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
	left: 600px;
	right: 300px;
	color: #4CAF50;
	padding: 10px;
  	background: #FFF;
  	border-radius: 2px;
  	font-size: 20px;
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
table{
	font-family: arial, sans-serif;
	width: 100%;
}\n
td{ 
	border: 1px solid #dddddd;
	text-align: center; 
	padding: 8px;
}
table, th, td {
  border: 1px solid black;
  padding: 15px;
  text-align: left;
}
</style>
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
<%

try {
	
	Connection con = null;
	String url = "jdbc:postgresql://localhost:5432/mess"; //PostgreSQL URL and followed by the database name
		String username = "srishtisuman"; //PostgreSQL username
		String password = "123"; //PostgreSQL password
	
	Class.forName("org.postgresql.Driver");
	con = DriverManager.getConnection(url, username, password);
	System.out.println("Printing connection object "+con);
	
	PreparedStatement st1 = con.prepareStatement("select amount_paid from resident_payment_details");
	ResultSet rs1 = st1.executeQuery();
	int netRes = 0;
	int netSta = 0;
	int rp=0,rm=0;
	while (rs1.next())
	{
		rp=rp+rs1.getInt(1);
	}
	
	PreparedStatement st2 = con.prepareStatement("select refund_amount from refund");
	ResultSet rs2 = st2.executeQuery();
	while (rs2.next())
	{
		rm=rm+rs2.getInt(1);
	}
	
	netRes = rp-rm;
	
	int sp=0,sm=0,q=20;
	
	PreparedStatement st3 = con.prepareStatement("select salary_paid from paid");
	ResultSet rs3 = st3.executeQuery();
	while (rs3.next())
	{
		sp=sp+rs3.getInt(1);
	}
	
	PreparedStatement st4 = con.prepareStatement("select nm*(?) as cost from(select s_id,sum(meals_eaten) as nm from staff_att group by s_id) as exp;");
	st4.setInt(1,q);
	ResultSet rs4 = st4.executeQuery();
	while (rs4.next())
	{
		sm=sm+rs4.getInt(1);
	}
	
	netSta = sp-sm;
	
	int netMessBill = 0;
	netMessBill = netRes - netSta;
	
	/*PreparedStatement st = con.prepareStatement("insert into MessBill(netSalaryPaid,netPaymentGot,netMessBill) values(?,?,?)");
	st.setInt(1,netSta);
	st.setInt(2,netRes);
	st.setInt(3,netMessBill);
	int r = st.executeUpdate();*/

%>

Net Mess Bill = <%=netMessBill %><br>Net Salary Paid = <%=netSta %><br>Net Payment paid by Residents = <%=netRes %>
<%
rs1.close();
st1.close();
con.close();
} 
catch (Exception ex) 
{
System.out.println("Unable to connect to database.");
}
%>

</div>
</body>
</html>