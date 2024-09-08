package pack.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Forgetservlet
 */
@WebServlet("/Forgetservlet")
public class Forgetservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forgetservlet() {
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
		//doGet(request, response);
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		String repass=request.getParameter("repassword");
		PrintWriter pw=response.getWriter();
		
		if(pass.equals(repass)) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://128.66.203.247.imsc7it132","imsc7it132","sumo@123");
				
				PreparedStatement pst=con.prepareStatement("UPDATE register SET password=? From WHERE username=?");
				pst.setString(1, uname);
				pst.setString(2, pass);
				
				int rs=pst.executeUpdate();
				if(rs>0) {
					response.sendRedirect("login.jsp");
				}
				else {
					response.sendRedirect("forget.jsp");
					throw new Exception("Something Wnet Wrong...");
				}
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		else
		{
			System.out.println("Please Enter Both Passwords Same...");
			response.sendRedirect("forget.jsp");
		}
	}

}
