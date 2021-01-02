

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
 * Servlet implementation class menupServlet
 */
@WebServlet("/menupServlet")
public class menupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public menupServlet() {
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
		String da = request.getParameter("da");
		String b = request.getParameter("b");
		String l = request.getParameter("l");
		String s = request.getParameter("s");
		String d = request.getParameter("d");
		int cpm = Integer.parseInt(request.getParameter("cpm"));
		int index=0;

		String[] arr = {"Sunday","Monday", "Tuesday", "Wednesday", "Thursday","Friday","Saturday"};
		for (int i = 0;i<arr.length;i++)
		{
			if (arr[i].equalsIgnoreCase(da))
			{
				System.out.println("entered");
				index = i;
				break;
			}
		}
		Connection con = null;
		String url = "jdbc:postgresql://localhost:5432/mess"; //PostgreSQL URL and followed by the database name
 		String username = "srishtisuman"; //PostgreSQL username
 		String pass = "123"; //PostgreSQL password
		
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(url, username, pass); //attempting to connect to PostgreSQL database
 		System.out.println("Printing connection object "+con);

 		PreparedStatement stmt = con.prepareStatement("update menu set breakfast=?,lunch=?,snacks=?,dinner=?,costpermeal=? where day=?");
 		stmt.setString(1, b);
 		stmt.setString(2, l);
 		stmt.setString(3, s);
 		stmt.setString(4, d);
 		stmt.setInt(5, cpm);
 		stmt.setInt(6, index);
 		int result=stmt.executeUpdate();
 		
 		if (result>0)
 		{
			RequestDispatcher rd = request.getRequestDispatcher("menuup.jsp");
			rd.forward(request, response);
 		}

		}
		 catch (Exception e) 
 		{
 			e.printStackTrace();
 		}
	}

}
