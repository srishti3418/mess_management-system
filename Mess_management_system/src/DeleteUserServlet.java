

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
	
		//getting input values from jsp page
		String uid = request.getParameter("uid");

		Connection con = null;
		String url = "jdbc:postgresql://localhost:5432/mess"; //PostgreSQL URL and followed by the database name
 		String username = "srishtisuman"; //PostgreSQL username
 		String pass = "123"; //PostgreSQL password
		
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(url, username, pass); //attempting to connect to PostgreSQL database
 		System.out.println("Printing connection object "+con);
 		int r1=0,r2=0;
 		
 		if (uid.charAt(0)=='R')
 		{
 			PreparedStatement st1 = con.prepareStatement("delete from resident where id=?");
 	 		st1.setString(1, uid);
 	 		r1=st1.executeUpdate();
 	 		PreparedStatement st2 = con.prepareStatement("delete from login where username=?");
 	 		st2.setString(1, uid);
 	 		r2=st2.executeUpdate();
 		}
 		else if (uid.charAt(0)=='S')
 		{
 			PreparedStatement st1 = con.prepareStatement("delete from staff where id=?");
 	 		st1.setString(1, uid);
 	 		r1=st1.executeUpdate();
 	 		PreparedStatement st2 = con.prepareStatement("delete from login where username=?");
 	 		st2.setString(1, uid);
 	 		r2=st2.executeUpdate();
 		}
 		else
 		{
 			PreparedStatement st1 = con.prepareStatement("delete from admin where id=?");
 	 		st1.setString(1, uid);
 	 		r1=st1.executeUpdate();
 	 		PreparedStatement st2 = con.prepareStatement("delete from login where username=?");
 	 		st2.setString(1, uid);
 	 		r2=st2.executeUpdate();
 		}
 		
 		if (r1>0 && r2>0)
 		{
			RequestDispatcher rd = request.getRequestDispatcher("Deleted.jsp");
			rd.forward(request, response);
 		}

		}
		 catch (Exception e) 
 		{
 			e.printStackTrace();
 		}
	}

}
