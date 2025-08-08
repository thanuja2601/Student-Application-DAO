package in.pentagon.studentapp.index;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Update {
	public static void update(Student s) {
		StudentDAO sdao=new StudentDAOImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("<==Update Account==>");
		int choice=0;
		do {
			System.out.println("1.Name");
			System.out.println("2.Phone");
			System.out.println("3.Mail id");
			System.out.println("4.Branch");
			System.out.println("5.Loc");
			System.out.println("6.Back to main menu");
			choice=sc.nextInt();
			switch(choice) {
			case 1:System.out.println("Enter the new name");
			s.setName(sc.next());
			break;
			case 2:System.out.println("Enter the new phone");
			s.setPhone(sc.nextLong());
			break;
			case 3:System.out.println("Enter the new mail");
			s.setMail(sc.next());
			break;
			case 4:System.out.println("Enter the new branch");
			s.setBranch(sc.next());
			break;
			case 5:System.out.println("Enter the new location");
			s.setLoc(sc.next());
			break;
			}
			boolean res=sdao.updateStudent(s);
			if(res) {
				System.out.println("Account Updated successfully");
			}
			else {
				System.out.println("Failed to update Account");
			}
		}
		while(choice!=6);
	}
}
