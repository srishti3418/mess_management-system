
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PaymentdtServlet extends HttpServlet{


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		ServletContext context=getServletContext();  
 		String id=(String)context.getAttribute("ID");
 		System.out.println(id);//getting advisor id as input from index.html page
		
		PrintWriter out = response.getWriter();
		Connection conn = null;
		Statement  stmt = null;
		try {
			out.println("<!DOCTYPE html>");//print in the form of HTML code
			out.println("<html>");
			out.println("<head><title>Mess Management System</title><style>\n" + 
					"h1{\n" + 
					"	text-align: center;\n" + 
					"  	color: #4CAF50;\n" + 
					"  	font-family: 'Roboto', sans-serif;	\n" + 
					"}" +
					"#dashboard {\n" + 
					"  position: absolute;\n" + 
					"  top: 120px;\n" + 
					"  width: 250px;\n" + 
					"  height: 320px;\n" + 
					"  background: #FFF;\n" + 
					"  border-radius: 2px;\n" + 
					"  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);\n" + 
					"}\n" + 
					".leftcolumn{\n" + 
					"  position: absolute;\n" + 
					"  top: 0;\n" + 
					"  left: 0;\n" + 
					"  box-sizing: border-box;\n" + 
					"  padding: 10px;\n" + 
					"  width: 150opx;\n" + 
					"}" +
					"input[type=\"submit\"] {\n" + 
					"  \n" + 
					"  width: 230px;\n" + 
					"  height: 50px;\n" + 
					"  border-radius: 2px;\n" + 
					"  font-family: 'Roboto', sans-serif;\n" + 
					"  font-weight: 500;\n" + 
					"  border: none;\n" + 
					"  background: #FFF;\n" + 
					"  color: #4CAF50;\n" + 
					"  border-bottom: 2px solid #4CAF50;\n" + 
					"  text-transform: uppercase;\n" + 
					"  transition: 0.1s ease;\n" + 
					"  cursor: pointer;\n" + 
					"}\n" + 
					"\n" + 
					"input[type=\"submit\"]:hover,\n" + 
					"input[type=\"submit\"]:focus {\n" + 
					"  opacity: 0.8;\n" + 
					"  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);\n" + 
					"  transition: 0.1s ease;\n" + 
					"}" +
					"#table {   position: absolute; top: 120px; left: 280px; right: 50px; margin-bottom: 40px; padding: 10px; background: #FFF; border-radius: 2px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);} " +
					"table {\n" + 
					"  font-family: arial, sans-serif;\n" + 
					"  border-collapse: collapse;\n" + 
					"  width: 100%;\n" + 
					"}\n" + 
					"\n" + 
					"td, th {\n" + 
					"  border: 1px solid #dddddd;\n" + 
					"  text-align: center;\n" + 
					"  padding: 8px;\n" + 
					"}\n" + 
					"\n" + 
					"tr:nth-child(odd) {\n" + 
					"  background-color: rgba(80, 175, 82, 0.25);\n" + 
					"}\n" + 
					"</style></head>");
			out.println("<body style=\"background-image: url('1-05082.jpg'); background-size: cover;\">");
			out.println("<h1>Mess Management System</h1>");
			out.println("<div id=\"dashboard\">\n" + 
					"  <div class=\"leftcolumn\">\n" + 
					"  	<form action = \"pd_residentServlet\">\n" + 
					"    <input type=\"submit\" value=\"Personal details\"></form>\n" + 
					"    <form action = \"menuServlet\">\n" + 
					"    <input type=\"submit\" value=\"Menu\"></form>\n" + 
					"    <form action = \"AttServlet\">\n" + 
					"    <input type=\"submit\" value=\"Report\"></form>\n" + 
					"    <form action = \"PaymentdtServlet\">\n" + 
					"    <input type=\"submit\" value=\"Payment details\"></form>\n" + 
					"    <form action = \"complaintServlet\">\n" + 
					"    <input type=\"submit\" value=\"Complaints\"></form>\n" + 
					"    <form action = \"complaintStatusServlet\">\n" + 
					"    <input type=\"submit\" value=\"Complaints Status\"></form>\n" + 
					"  </div>\n" + 
					"</div>");

			out.println("<div id = 'table'><table>");
			out.println("<tr>");
			out.println("<th>payment_no</th>");
			out.println("<th>r_id</th>");
			out.println("<th>payment_date</th>");
			out.println("<th>amount_paid</th>");
			out.println("</tr>");
			Class.forName("org.postgresql.Driver"); //loading postgres driver //query to get the instructor details with id 
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mess", "srishtisuman", "123");
			Statement statement=conn.createStatement();
	 		ResultSet rs=statement.executeQuery("select * from resident_payment_details");
			while(rs.next()) {
				int c1=rs.getInt("payment_no");
				String s1=rs.getString("r_id");
				java.util.Date date = rs.getDate("payment_date");
				java.sql.Date sqlDate = new java.sql.Date(date.getTime());
				int c3=rs.getInt("amount_paid");
				if(s1.compareTo(id)==0) {
					out.println("<tr>");
					out.println("<td>"+c1+"</td>");
					out.println("<td>"+s1+"</td>");
					out.println("<td>"+sqlDate+"</td>");
					out.println("<td>"+c3+"</td>");
					out.println("</tr>");
					
				}
			}
			out.println("</table></div>");
			out.println("</body></html>");
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			out.close();
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();  // closing connection and statement variables
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}

