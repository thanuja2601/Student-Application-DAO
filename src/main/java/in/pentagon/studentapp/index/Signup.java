package in.pentagon.studentapp.index;

import java.util.Scanner;
import in.pentagon.studentapp.dto.Student;
import in.pentagon.studentapp.dao.*;

public class Signup {
	public static void signup(){
		Scanner sc=new Scanner(System.in);
		//Engine e=new Petrol()
		//Payment p=new Credit();
		StudentDAO sdao=new StudentDAOImpl(); //creating implementation object of StudentDAO Interface
		//creation of POJO class object

				Student s=new Student();
				System.out.println("<--Student Signup--->");
				System.out.println("Enter the name");
				
				//string name=sc.next();
				//s.setName(name);
	
				s.setName(sc.next());
				System.out.println("Enter the phone");
				s.setPhone(sc.nextLong());
				System.out.println("Enter the mail");
				s.setMail(sc.next());
				System.out.println("Enter the branch");
				s.setBranch(sc.next());
				System.out.println("Enter the loc");
				s.setLoc(sc.next());
				System.out.println("Enter the password");
				String password=sc.next();
				System.out.println("Confirm the password");
				String confirmPassword=sc.next();
				
				//validating password and confirm password
				
				if(password.equals(confirmPassword)) {
					s.setPassword(confirmPassword);
					boolean res=sdao.insertStudent(s);
					if(res) {
						System.out.println("Data added Successfully!");
					}
					else {
						System.out.println("Failed to create account");
					}
				}
				else {
					System.out.println("Password mismatch");
				}
			}

}
