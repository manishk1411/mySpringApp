package com.man.test.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.man.test.dbConfig.DBConfiguration;
import com.man.test.model.Student;
import com.man.test.model.StudentDetail;

public class StudentRepository {

	DBConfiguration dbConfiguration;

	public StudentRepository() {
		dbConfiguration = new DBConfiguration();
	}

	public void addNewStudents(final List<Student> students) {
		try {
			Connection dbConnection = dbConfiguration.getDBConnection();
			PreparedStatement stmt = null;
			for (Student student : students) {
				stmt = dbConnection.prepareStatement("insert into Student values(?,?,?,?,?)");
				stmt.setLong(1, student.getStudentId());
				stmt.setString(2, student.getStudentDetail().getFirstName());
				stmt.setString(3, student.getStudentDetail().getLastName());
				stmt.setString(4, student.getStudentDetail().getAddress());
				stmt.setString(5, student.getStudentDetail().getEmailId());
				stmt.addBatch();
			}
			stmt.executeBatch();
			dbConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Student searchStudentByID(final long studentID) {
		Student student = null;
		try {
			PreparedStatement stmt = null;
			Connection dbConnection = dbConfiguration.getDBConnection();
			stmt = dbConnection.prepareStatement("select * from Student where student_id=" + studentID);
			StudentDetail studentDetail = new StudentDetail();
			long studID = 0;
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				studID = resultSet.getLong("student_id");
				studentDetail.setFirstName(resultSet.getString("first_name"));
				studentDetail.setLastName(resultSet.getString("last_name"));
				studentDetail.setAddress(resultSet.getString("address"));
				studentDetail.setEmailId(resultSet.getString("email"));
			}
			student = new Student(studID, studentDetail);
			dbConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	public List<Student> retreiveAllStudents() {
		DBConfiguration dbConfiguration = new DBConfiguration();
		String sql = "SELECT * FROM Student";
		List<Student> studentList = new ArrayList<>();
		try (Connection conn = (Connection) dbConfiguration.getDBConnection();
				PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			System.out.println("Bingo!!! Printing all Records from DB!!!");
			long stuid;
			StudentDetail a;
			Student b;
			int count=0;
			while (rs.next()) {
				count++;
				a= new StudentDetail();
				stuid = rs.getLong(1);
				a.setFirstName(rs.getString(2));
				a.setLastName(rs.getString(3));
				a.setAddress(rs.getString(4));
				a.setEmailId(rs.getString(5));
				b= new Student(stuid, a);
				studentList.add(b);
			}
			int x = studentList.size();
			
			System.out.println("Printing record yaayy !!!" + studentList);
			
			System.out.println("count is"+ count);
			
			System.out.println("");
			
			for (int i = 0; i < x; i++)
				System.out.println("aaa" + studentList.get(i));

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Arggghhh!!! Record cannot be found!!!");

		}
		return studentList;
	}

}
