package com.annotation;

@Table("T_STUDENT")
public class Student {

	@Filed(columnName="id",type="int",length=10)
	private int id;
	
	@Filed(columnName="student_name",type="varchar",length=50)
	private String studentName;
	
	@Filed(columnName="age",type="int",length=3)
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + ", age=" + age + "]";
	}
	
}
