package com.man.test.model;

public class Student {
	private long studentId;
	private StudentDetail studentDetail;
	
	
	public Student(long studentId, StudentDetail studentDetail) {
		// TODO Auto-generated constructor stub
		this.studentId=studentId;
		this.studentDetail=studentDetail;
	}


	public long getStudentId() {
		return studentId;
	}


	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}


	public StudentDetail getStudentDetail() {
		return studentDetail;
	}


	public void setStudentDetail(StudentDetail studentDetail) {
		this.studentDetail = studentDetail;
	}


	@Override
	public String toString() {
		return "student [studentId=" + studentId + ", studentDetail=" + studentDetail + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentDetail == null) ? 0 : studentDetail.hashCode());
		result = prime * result + (int) (studentId ^ (studentId >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (studentDetail == null) {
			if (other.studentDetail != null)
				return false;
		} else if (!studentDetail.equals(other.studentDetail))
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}
	
	
}
