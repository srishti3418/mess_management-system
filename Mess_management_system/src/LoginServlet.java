import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;


/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = null, s1 = null;
		try
		{
	
		//getting input values from jsp page
		String usern = request.getParameter("uname");
		String passw = request.getParameter("psw");
		ServletContext context=getServletContext();  
	  	  context.setAttribute("ID",usern);
		
		Connection con = null;
		String url = "jdbc:postgresql://localhost:5432/mess"; //PostgreSQL URL and followed by the database name
 		String username = "srishtisuman"; //PostgreSQL username
 		String pass = "123"; //PostgreSQL password
		
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(url, username, pass); //attempting to connect to PostgreSQL database
 		System.out.println("Printing connection object "+con);
 		
 		Statement statement=con.createStatement();
 		ResultSet rs=statement.executeQuery("select * from login");
 		boolean flag=false;
 		while(rs.next()) {
 			s=rs.getString("username");
 			if(s.compareTo(usern)==0) {
 				s1=rs.getString("password");
 				if(s1.compareTo(passw)==0) {
	 				flag=true;
	 				break;
 				}
 			}
 		}


		PrintWriter out = response.getWriter();

		//Checks if insert is successful.If yes,then redirects to Result.jsp page 
		if(flag==true)
		{
			char s2=s.charAt(0);
			if(s2=='R') {
			RequestDispatcher rd = request.getRequestDispatcher("/R_dashboard.jsp");
			rd.forward(request, response);
			}
			else if(s2=='A') {
				request.setAttribute("a_id",usern);
				RequestDispatcher rd = request.getRequestDispatcher("/Admin.jsp");
				rd.forward(request, response);
			}
			else if(s2=='S') {
				RequestDispatcher rd = request.getRequestDispatcher("staff_dashboard.jsp");
				rd.forward(request, response);
			}
		}
		if(flag == false)
		{
			out.println("<!DOCTYPE html>");//print in the form of HTML code
			out.println("<html>");
			out.println("<head><title>Mess Management System</title><style>\n" + 
					"h1{\n" + 
					"	text-align: center;\n" + 
					"  	color: #4CAF50;\n" + 
					"  	font-family: 'Roboto', sans-serif;	\n" + 
					"}" +
			"</style></head><body style=\"background-image: url('1-05082.jpg'); background-size: cover;\">");
			out.println("<h1>Mess Management Sysytem</h1>");
			out.println("<h1>---Incorrect Credentials---</h1>");
			out.println("<h4><< go back and enter correct credentials</h4></body></html>");
		}

		}
		 catch (Exception e) 
 		{
 			e.printStackTrace();
 		}

	
	}


}


