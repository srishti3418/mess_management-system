import java.io.IOException;
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
@WebServlet("/BackServlet")
public class BackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
	
		//getting input values from jsp page
			ServletContext context=getServletContext();  
	 		String id=(String)context.getAttribute("ID");
	 		System.out.println(id);
		

		
		//Checks if insert is successful.If yes,then redirects to Result.jsp page 
			char s2=id.charAt(0);
			if(s2=='R') {
			RequestDispatcher rd = request.getRequestDispatcher("R_dashboard.jsp");
			rd.forward(request, response);
			}
			else if(s2=='A') {
				RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
				rd.forward(request, response);
			}
			else if(s2=='S') {
				RequestDispatcher rd = request.getRequestDispatcher("staff_dashboard.jsp");
				rd.forward(request, response);
			}

		}
		 catch (Exception e) 
 		{
 			e.printStackTrace();
 		}

	
	}


}


