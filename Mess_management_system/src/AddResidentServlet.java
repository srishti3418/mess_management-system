

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
 * Servlet implementation class AddResidentServlet
 */
@WebServlet("/AddResidentServlet")
public class AddResidentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddResidentServlet() {
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
		String rid = request.getParameter("rid");
		String mobileno = request.getParameter("mobileno");
		String emailid = request.getParameter("emailid");
		String accno = request.getParameter("accno");
		int roomno = Integer.parseInt(request.getParameter("roomno"));
		String fullname = request.getParameter("fullname");
		String p = request.getParameter("p");


		Connection con = null;
		String url = "jdbc:postgresql://localhost:5432/mess"; //PostgreSQL URL and followed by the database name
 		String username = "srishtisuman"; //PostgreSQL username
 		String pass = "123"; //PostgreSQL password
		
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(url, username, pass); //attempting to connect to PostgreSQL database
 		System.out.println("Printing connection object "+con);

 		PreparedStatement stmt = con.prepareStatement("insert into resident values(?,?,?,?,?,?)");
 		stmt.setString(1, rid);
 		stmt.setString(2, mobileno);
 		stmt.setString(3, emailid);
 		stmt.setString(4, accno);
 		stmt.setInt(5, roomno);
 		stmt.setString(6, fullname);
 		int result=stmt.executeUpdate();
 		
 		PreparedStatement stm = con.prepareStatement("insert into login values(?,?)");
 		stm.setString(1, rid);
 		stm.setString(2, p);
 		int r2 = stm.executeUpdate();
 		
 		if (result>0 && r2>0)
 		{
			RequestDispatcher rd = request.getRequestDispatcher("Added.jsp");
			rd.forward(request, response);
 		}

		}
		 catch (Exception e) 
 		{
 			e.printStackTrace();
 		}
	}

}
