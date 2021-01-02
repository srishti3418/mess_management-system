

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResidentRefundServlet
 */
@WebServlet("/ResidentRefundServlet")
public class ResidentRefundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResidentRefundServlet() {
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

		Connection con = null;
		int r2=0;
		String url = "jdbc:postgresql://localhost:5432/mess"; //PostgreSQL URL and followed by the database name
 		String username = "srishtisuman"; //PostgreSQL username
 		String pass = "123"; //PostgreSQL password
		
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(url, username, pass); //attempting to connect to PostgreSQL database
 		System.out.println("Printing connection object "+con);

 		PreparedStatement smt = con.prepareStatement("select r_id,sum(meals_skipped) as nskipped from resident_att group by r_id;");
 		ResultSet rs1 = smt.executeQuery();

 		while(rs1.next())
 		{
 			if(rs1.getInt(2) >= 40)
 			{
 				int num = (20)*(rs1.getInt(2));
 				PreparedStatement smt1 = con.prepareStatement("insert into refund(r_id,refund_amount) values(?,?);");
 				smt1.setString(1, rs1.getString(1));
 		 		smt1.setInt(2, num);
 		 		r2 = smt1.executeUpdate();
 			}
 		}
 		if (r2>0)
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
