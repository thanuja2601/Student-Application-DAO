package in.pentagon.studentapp.index;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Password {
	public static void reset(Student s) {
		Scanner sc=new Scanner(System.in);
		StudentDAO sdao=new StudentDAOImpl();
		
			System.out.println("Set the new password");
			String pass=sc.next();
			
			System.out.println(" confirm the password");
			String confirm=sc.next();
			
			if(pass.equals(confirm)) {
				s.setPassword(pass);
				boolean update=sdao.updateStudent(s);
				if(update) {
					System.out.println("Password Updated Successfully--------Your New Password is\"+s.getPassword());");
				}
				else {
					System.out.println("Failed to update password..please try again ");
				}
			}
			else {
				System.out.println("password mismatched");
			}
		}
	public static void forgot() {
		Scanner sc=new Scanner(System.in);
		Student s=null;
		StudentDAO sdao=new StudentDAOImpl();
		
		System.out.println("Enter the mail id");
		String mail=sc.next();
		
		System.out.println("Enter the phone number");
		Long phone=sc.nextLong();
		
		s=sdao.getStudent(phone,mail);
		
		if(s!=null) {
			System.out.println("Enter the new password");
			String pass=sc.next();
			System.out.println("Confirm Password");
			String confirm=sc.next();
			
			if(pass.equals(confirm))
			{
				s.setPassword(pass);
				 
				 boolean update = sdao.updateStudent(s);
				
				if(update)
					
				{
					System.out.println("Password Updated SuccessFully ------- Your New Passowrd is " + s.getPassword());
				}
				else
				{
					System.out.println("Failed to update password. Please try again.");
				}
			}
			else {
				System.out.println("Passwords do not match. Try again.");
			}
			
		}
		else {
			System.out.println("No account found with given phone and mail. Try Again.");
		}
	}
}