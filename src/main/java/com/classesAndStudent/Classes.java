package com.classesAndStudent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.subjects.Subject;
import com.teachers.Teacher;

@Entity
@Table(name="class")
public class Classes {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private int classId;
	@Column(name="class_name", nullable=false)
	private String ClassName;
	@ManyToOne
	private Teacher teacher;
	@ManyToOne
	private Subject subject;
	
	public Classes()
	{
		
	}

	public Classes(String className) {
		super();
		ClassName = className;
	}

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		ClassName = className;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	@Override
	public String toString() {
		return "Classes [classId=" + classId + ", ClassName=" + ClassName + ", teacher=" + teacher + ", subject="
				+ subject + "]";
	}
	
	
}
