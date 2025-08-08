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
@WebServlet("/reset")
public class Reset extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAO sdao=new StudentDAOImpl();
		PrintWriter out=resp.getWriter();
		Student s=sdao.getStudent(Long.parseLong(req.getParameter("phone")),req.getParameter("mail"));
		if(s!=null) {
			if(req.getParameter("password").equals(req.getParameter("confirmPassword"))) {
				s.setPassword(req.getParameter("password"));
				boolean res=sdao.updateStudent(s);
				if(res) {
					out.println("<h1>Password updated successfully</h1>");
				}
				else {
					out.println("<h1>Failed to update the password</h1>");
				}
					
				}
			else {
				out.println("<h1>Password mismatched</h1>");
			}
		}
		else {
			out.println("<h1>Student not founded</h1>");
		}
		}

}
