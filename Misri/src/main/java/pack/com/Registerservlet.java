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
 * Servlet implementation class Registerservlet
 */
@WebServlet("/Registerservlet")
public class Registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registerservlet() {
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
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		String age=request.getParameter("age");
		String no=request.getParameter("no");
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		String accept=request.getParameter("accept");
		String course=request.getParameter("course");
		PrintWriter pw = response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://128.66.203.247/imsc7it132","imsc7it132","sumo@123");
			
			if(accept.equals("checked")) {
				PreparedStatement pst=con.prepareStatement("INSERT INTO register(name,email,password,age,no,gender,address,course) VALUES(?,?,?,?,?,?,?,?)");
				pst.setString(1, name);
				pst.setString(2, email);
				pst.setString(3, pass);
				pst.setString(4, age);
				pst.setString(5, no);
				pst.setString(6, gender);
				pst.setString(7, address);
				pst.setString(8, course);
				
				int rs=pst.executeUpdate();
				if(rs>0) {
					System.out.println("Name : "+name);
					System.out.println("Email : "+email);
					System.out.println("Age : "+age);
					System.out.println("No : "+no);
					System.out.println("Gender : "+gender);
					System.out.println("Address : "+address);
					System.out.println("Course : "+course);
					
					response.sendRedirect("success.jsp");
					//pw.println("Name : "+name);
					//pw.println("Email : "+email);
					//pw.println("Age : "+age);
					//pw.println("No : "+no);
					//pw.println("Gender : "+gender);
					//pw.println("Address : "+address);
					//pw.println("Course : "+course);
				}
				else {
					response.sendRedirect("error.jsp");
					throw new Exception("Something Went Wrong");
				}
			}
			else {
				System.out.println("You haven't accepted our terms");
			}
				
				
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
