package authenticate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogInServelet
 */
@WebServlet("/loginServelet")
public class LogInServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogInServelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("name");
		@SuppressWarnings("unused")
		String pass = request.getParameter("password");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/online", "root", "qwerty123");
			
			String sql = "select * from online.registeruser where name = ?";
			PreparedStatement statment = con.prepareStatement(sql);
			statment.setString(1, uname);
			ResultSet rs = statment.executeQuery();
			if( rs.next()) {
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(10);
				session.setAttribute("uname", uname);
				RequestDispatcher rd = request.getRequestDispatcher("/welcome.jsp");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
				rd.forward(request, response);
			}
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/*	if(uname.equals("phani") && password.equals("rajat")) {
			RequestDispatcher rd = request.getRequestDispatcher("/welcome.jsp");
			rd.forward(request, response);
		}*/
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

	}
