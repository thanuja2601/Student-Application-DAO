package in.pentagon.studentapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAO sdao=new StudentDAOImpl();
		PrintWriter out=resp.getWriter();
		Student s=sdao.getStudent(req.getParameter("mail"), req.getParameter("password"));
		if(s!=null) {
			out.println("<h1>Login Successfull!</h1>");
		}
		else {
			out.println("<h1>Failed to login!</h1>");
		}
	}
    	
}