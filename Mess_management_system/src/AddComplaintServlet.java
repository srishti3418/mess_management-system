

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
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class AddComplaintServlet
 */
@WebServlet("/AddComplaintServlet")
public class AddComplaintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComplaintServlet() {
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
		HttpSession session = request.getSession();
		String resid_id = (String) session.getAttribute("resi_id");
		//getting input values from jsp page
		String nam = request.getParameter("nam");
		String com = request.getParameter("com");


		Connection con = null;
		String url = "jdbc:postgresql://localhost:5432/mess"; //PostgreSQL URL and followed by the database name
 		String username = "srishtisuman"; //PostgreSQL username
 		String pass = "123"; //PostgreSQL password
		
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(url, username, pass); //attempting to connect to PostgreSQL database
 		System.out.println("Printing connection object "+con);

 		PreparedStatement stmt = con.prepareStatement("insert into complaint values(?,?,?)");
 		stmt.setString(1, resid_id);
 		stmt.setString(2, nam);
 		stmt.setString(3, com);
 		int result=stmt.executeUpdate();
 		
 		if (result>0)
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
