package com.teachers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher {
	@Id
	@Column(name="ID", nullable=false)
	private int teacherID;
	@Column(name="teacher_name", nullable=false)
	private String teacherName;
	private int age;
	
	public Teacher()
	{
		
	}

	public Teacher(String teacherName, int age) {
		super();
		this.teacherName = teacherName;
		this.age = age;
	}

	public int getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
		
	}

	@Override
	public String toString() {
		return "Teacher [teacherID=" + teacherID + ", teacherName=" + teacherName + ", age=" + age + "]";
	}
	
	

}
