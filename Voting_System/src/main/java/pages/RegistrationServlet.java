package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImp;

@WebServlet("/register")

public class RegistrationServlet extends HttpServlet{

	private UserDaoImp userDao;
	@Override
	public void init() throws ServletException 
	{
		try {
			userDao=new UserDaoImp();
		} catch (SQLException e) {
			throw new ServletException("Error occured in Init",e);
		}
		
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String first_name=req.getParameter("fem");
		String last_name=req.getParameter("lem");
		Date dob=Date.valueOf(req.getParameter("dob"));
		String email=req.getParameter("em");
		String password=req.getParameter("pass");
		
		try(PrintWriter pw=resp.getWriter()) 
		{
			String op=userDao.registerUser(first_name, last_name, email, password, dob);
			pw.print("<h3>"+op+"<h3>");
		} catch (SQLException e) {
			
			throw new ServletException("Error occured in Init",e);
		}
		
	}
	
	
	
}
