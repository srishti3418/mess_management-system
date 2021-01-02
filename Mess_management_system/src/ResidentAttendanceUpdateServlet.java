

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResidentAttendanceUpdateServlet
 */
@WebServlet("/ResidentAttendanceUpdateServlet")
public class ResidentAttendanceUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResidentAttendanceUpdateServlet() {
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
		String dat = request.getParameter("dat");
		String bre = request.getParameter("bre");
		String lun = request.getParameter("lun");
		String sna = request.getParameter("sna");
		String din = request.getParameter("din");
		int nms = Integer.parseInt(request.getParameter("nms"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date da = sdf.parse(dat);
		


		Connection con = null;
 		String url = "jdbc:postgresql://localhost:5432/mess"; //PostgreSQL URL and followed by the database name
 		String username = "srishtisuman"; //PostgreSQL username
 		String pass = "123"; //PostgreSQL password
		
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(url, username, pass); //attempting to connect to PostgreSQL database
 		System.out.println("Printing connection object "+con);

 		PreparedStatement stmt = con.prepareStatement("insert into resident_att values(?,?,?,?,?,?,?)");
 		stmt.setString(1, rid);
 		stmt.setDate(2, new java.sql.Date(da.getTime()));
 		stmt.setString(3, bre);
 		stmt.setString(4, lun);
 		stmt.setString(5, sna);
 		stmt.setString(6, din);
 		stmt.setInt(7, nms);
 		
 		int result=stmt.executeUpdate();
 		
 		if (result>0)
 		{
			RequestDispatcher rd = request.getRequestDispatcher("Updated.jsp");
			rd.forward(request, response);
 		}

		}
		 catch (Exception e) 
 		{
 			e.printStackTrace();
 		}
	}

}
