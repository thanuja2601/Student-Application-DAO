package in.pentagon.studentapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.pentagon.studentapp.connection.Connector;
import in.pentagon.studentapp.dto.Student;
//All JDBC logics written here
public class StudentDAOImpl implements StudentDAO{
	//All our JDBC logics will be written over here
	private Connection con;
	
	public StudentDAOImpl() {
		this.con=Connector.requestConnection();
	}

		@Override
		public boolean insertStudent(Student s) {
			// TODO Auto-generated method stub
			PreparedStatement ps=null;
			String query="INSERT INTO STUDENTS VALUES(0,?,?,?,?,?,?,SYSDATE())";
			int i=0;
			
			try {
				ps=con.prepareStatement(query);
				ps.setString(1,s.getName());
				ps.setLong(2,s.getPhone());
				ps.setString(3,s.getMail());
				ps.setString(4,s.getBranch());
				ps.setString(5,s.getLoc());
				ps.setString(6,s.getPassword());
				i=ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i>0) {
				return true;
			}
			else {
				return false;
			}
		}

		@Override
		public boolean updateStudent(Student s) {
			// TODO Auto-generated method stub
			PreparedStatement ps=null;
			String query="UPDATE STUDENTS SET NAME=?,PHONE=?,MAIL=?,BRANCH=?,LOC=?,PASSWORD=?,DATE=SYSDATE() WHERE ID=?";
			int i=0;
			
			try {
				ps=con.prepareStatement(query);
				ps.setString(1,s.getName());
				ps.setLong(2,s.getPhone());
				ps.setString(3,s.getMail());
				ps.setString(4,s.getBranch());
				ps.setString(5,s.getLoc());
				ps.setString(6,s.getPassword());
				ps.setInt(7,s.getId());
				i=ps.executeUpdate();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			if(i>0) {
				return true;
			}
			else {
				return false;
		}
}

		@Override
		public boolean deleteStudent(Student s) {
			// TODO Auto-generated method stub
			
			String query="DELETE FROM STUDENTS WHERE ID=?";
			PreparedStatement ps=null;
			int i=0;
			
			try {
				ps=con.prepareStatement(query);
				ps.setInt(1,s.getId());
				i=ps.executeUpdate();
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i>0) {
				return true;
			}
			else
			{
			return false;
			}
}
		
		@Override
		public Student getStudent(String mail, String password) {
			// TODO Auto-generated method stub
			PreparedStatement ps=null;
			String query="SELECT * FROM STUDENTS WHERE MAIL=? AND PASSWORD=?";
			Student s=null;
			
			try {
				ps=con.prepareStatement(query);
				ps.setString(1,mail);
				ps.setString(2,password);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					s=new Student();
					
					//int id=rs.getInt("id");
					//s.setId(id);
					
					s.setId(rs.getInt("id"));
					s.setName(rs.getString("name"));
					s.setPhone(rs.getLong("phone"));
					s.setMail(rs.getString("mail"));
					s.setBranch(rs.getString("branch"));
					s.setLoc(rs.getString("loc"));
					s.setPassword(rs.getString("password"));
					s.setDate(rs.getString("date"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return s;
		}

		@Override
		public Student getStudent(long phone, String mail) {
			// TODO Auto-generated method stub
			PreparedStatement ps=null;
			String query="SELECT * FROM STUDENTS WHERE PHONE=? AND MAIL=?";
			Student s=null;
			
			try {
				ps=con.prepareStatement(query);
				ps.setLong(1,phone);
				ps.setString(2,mail);

				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					s=new Student();
					//int id=rs.getInt("id");
					//s.setId(id);
					s.setId(rs.getInt("id"));
					s.setName(rs.getString("name"));
					s.setPhone(rs.getLong("phone"));
					s.setMail(rs.getString("mail"));
					s.setBranch(rs.getString("branch"));
					s.setLoc(rs.getString("loc"));
					s.setPassword(rs.getString("password"));
					s.setDate(rs.getString("date"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return s;
		}

		@Override
		public ArrayList<Student> getStudent(String name) {
			// TODO Auto-generated method stub
			ArrayList<Student>sl=new ArrayList<Student>();
			Student s;
			PreparedStatement ps=null;
			String query="SELECT * FROM STUDENTS WHERE NAME=?";
			
			try {
				ps=con.prepareStatement(query);
				ps.setString(1,name);
				
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					s=new Student();
					//rs.getInt("id")
					//s.setId(rs)
					s.setId(rs.getInt("id"));
					s.setName(rs.getString("name"));
					s.setPhone(rs.getLong("phone"));
					s.setMail(rs.getString("mail"));
					s.setBranch(rs.getString("branch"));
					s.setLoc(rs.getString("loc"));
					s.setPassword(rs.getString("password"));
					s.setDate(rs.getString("date"));
					sl.add(s);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sl;
		}

		@Override
		public ArrayList<Student> getStudent() {
			// TODO Auto-generated method stub
			PreparedStatement ps=null;
			ArrayList<Student> SL=new ArrayList<Student>();
			Student s;
			String query="SELECT * FROM STUDENTS";
			try {
				ps=con.prepareStatement(query);
		
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					s=new Student();
					//rs.getInt("id")
					//s.setId(rs)
					s.setId(rs.getInt("id"));
					s.setName(rs.getString("name"));
					s.setPhone(rs.getLong("phone"));
					s.setMail(rs.getString("mail"));
					s.setBranch(rs.getString("branch"));
					s.setLoc(rs.getString("loc"));
					s.setPassword(rs.getString("password"));
					s.setDate(rs.getString("date"));
					SL.add(s);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return SL;
		}
		
	}

