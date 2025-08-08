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
@WebServlet("/signup")
public class Signup extends HttpServlet{
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student s=new Student();
		StudentDAO sdao=new StudentDAOImpl();
		PrintWriter out=resp.getWriter();
		s.setName(req.getParameter("name"));
		 s.setPhone(Long.parseLong(req.getParameter("phone")));
		 s.setMail(req.getParameter("mail"));
		 s.setBranch(req.getParameter("branch"));
		 s.setLoc(req.getParameter("loc"));
		 if(req.getParameter("password").equals(req.getParameter("confirmPassword"))) {
			 s.setPassword(req.getParameter("password"));
			 boolean res=sdao.insertStudent(s);
			 if(res) {
				 out.println("<h1>Data added successfully!</h1>");
			 }
			 else {
				 out.println("<h1>Failed to signup!</h1>");
			 }
		 }
		 else {
			 out.println("<h1>Password mismatch!</h1");
		 }
		
	}
}
