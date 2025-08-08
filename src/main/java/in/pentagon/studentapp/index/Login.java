package in.pentagon.studentapp.index;

import java.util.ArrayList;
import java.util.Scanner;
import in.pentagon.studentapp.dao.*;
import in.pentagon.studentapp.dto.Student;

public class Login {
	public static void login() {
		Scanner sc=new Scanner(System.in);
		int choice=0;
		StudentDAO sdao=new StudentDAOImpl();
		Student a=new Student();
		
		
		System.out.println("<---Login Page---->");
		
		System.out.println("Enter the mail id:");
		String mail=sc.next();
		System.out.println("Enter the password:");
		String pass=sc.next();
		a =sdao.getStudent(mail,pass);
		if(a!=null) {
			System.out.println("Login Successful!Welcome"+a.getName());
			do {
				System.out.println("1.View Data");
				System.out.println("2.Search users");
				System.out.println("3.Update account");
				System.out.println("4.Reset Password");
				System.out.println("5.Back to main menu");
				if(a.getId()==1) {    //admin
					System.out.println("6.View all users");
					System.out.println("7.Delete the user");
				}
			choice =sc.nextInt();
			switch(choice) {
			case 1:System.out.println(a);
			break;
			case 2:System.out.println("Enter Student the name");
				String name=sc.next();
				ArrayList<Student>sl = sdao.getStudent(name);
				
				for(Student s3:sl) {
					System.out.println("Student id:"+s3.getId());
					System.out.println("Student name:"+s3.getName());
					System.out.println("Student branch:"+s3.getBranch());
					System.out.println("Student location:"+s3.getLoc());
					System.out.println("===========");
				}
			break;
			
			case 3:Update.update(a);
			break;
			case 4:Password.reset(a);
			break;
			case 5:System.out.println("Going to back to main menu");
			break;
			case 6:
				System.out.println("view users");
				ArrayList<Student>SL = sdao.getStudent();
				for(Student s:SL) {
					System.out.println(s);
				}
				//view all user logic
			break;
			case 7: //Delete.delete();         //delete user logic
				System.out.println("Enter the students Id you want to delete:");
				Student s=new Student();
				s.setId(sc.nextInt());
				
				boolean res=sdao.deleteStudent(s);
				
				if(res) {
					System.out.println("Student deleted successfully");
				}
				else {
					System.out.println("Failed! to delete ..please enter the valid id");
				}
				
			break;
			
			default:System.out.println("invalid choice!try again");
			}
			}while(choice!=5);
		}
		else {
			System.out.println("Failed to login!");
		}
		
	}

}
