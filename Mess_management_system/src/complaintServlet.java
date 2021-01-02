
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.text.ParseException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class complaintServlet extends HttpServlet{


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		ServletContext context=getServletContext();  
 		String id=(String)context.getAttribute("ID");
 		System.out.println(id);
		
		PrintWriter out = response.getWriter();
		try {
			out.println("<!DOCTYPE html>\n" + 
					"<html>\n" + 
					"<head>\n" + 
					"<meta charset=\"ISO-8859-1\">\n" + 
					"<style>\n" + 
					"body {\n" + 
					"  font-size: 16px;\n" + 
					"  color: #4CAF50;\n" + 
					"  font-family: 'Roboto', sans-serif;\n" + 
					"  font-weight: 300;\n" + 
					"  text-allign: center;\n" + 
					"}\r\n" + 
					"#complaint-box {\n" + 
					"  position: relative;\n" + 
					"  margin: 80px 350px 50px 100px;\n" + 
					"  padding: 40px;\n" + 
					"  width: 500px;\n" + 
					"  height: 100px;\n" + 
					"  background: #FFF;\n" + 
					"  border-radius: 2px;\n" + 
					"  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);\n" + 
					"}\n" + 
					"\n" + 
					"input[type=\"text\"]{\n" + 
					"  display: block;\n" + 
					"  box-sizing: border-box;\n" + 
					"  margin-bottom: 20px;\n" + 
					"  padding: 4px;\n" + 
					"  width: 500px;\n" + 
					"  height: 32px;\n" + 
					"  border: none;\n" + 
					"  border-bottom: 1px solid #4CAF50;\n" + 
					"  font-family: 'Roboto', sans-serif;\n" + 
					"  font-weight: 400;\n" + 
					"  font-size: 15px;\n" + 
					"  transition: 0.2s ease;\n" + 
					"}\n" + 
					"\n" + 
					"input[type=\"text\"]:focus{\n" + 
					"  border-bottom: 2px solid #16a085;\n" + 
					"  color: #16a085;\n" + 
					"  transition: 0.2s ease;\n" + 
					"}\n" + 
					"\n" + 
					"input[type=\"submit\"] {\n" + 
					"  margin-top: 10px;\n" + 
					"  width: 120px;\n" + 
					"  height: 32px;\n" + 
					"  background: #4CAF50;\n" + 
					"  border: none;\n" + 
					"  border-radius: 2px;\n" + 
					"  color: #FFF;\n" + 
					"  font-family: 'Roboto', sans-serif;\n" + 
					"  font-weight: 500;\n" + 
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
					"}\n" + 
					"\n" + 
					"input[type=\"submit\"]:active {\n" + 
					"  opacity: 1;\n" + 
					"  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.4);\n" + 
					"  transition: 0.1s ease;\n" + 
					"}\n" + 
					"</style>\n" + 
					"<title>Mess Management System</title>\n" + 
					"</head>\n" + 
					"<body style=\"background-image: url('1-05082.jpg'); background-size: cover;\">\n" + 
					"<h1>Mess Management System</h1>\n" + 
					"<div id=\"complaint-box\">\n" + 
					"  <form action=\"registercomplaintServlet\" method = \"get\">\n" + 
					"    <label>Complaint</label>\n" + 
					"    <input type = \"text\" name = \"complaints\" Placeholder = \"Write your complaint here\" required>\n" + 
					"    <input type = \"submit\" value = \"Submit\">\n" + 
					"  </form>\n" + 
					"</div>\n" + 
					"</body>\n" + 
					"</html>");
		}finally {
			out.close();
		}
	}
}

