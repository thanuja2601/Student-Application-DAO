package in.pentagon.studentapp.dao;

import java.util.ArrayList;
import in.pentagon.studentapp.dto.Student;

public interface StudentDAO {
	//JDBC Declarations
	public boolean insertStudent(Student s); //signup
	public boolean updateStudent(Student s);
	public boolean deleteStudent(Student s);
	public Student getStudent(String mail,String password); //login
	public Student getStudent(long phone,String mail);  //reset password
	public ArrayList <Student> getStudent(String name); //retrieve the name
	public ArrayList <Student> getStudent();
}
