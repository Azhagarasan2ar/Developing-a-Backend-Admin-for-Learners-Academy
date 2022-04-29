package com.classesAndStudent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@Column(name="ID", nullable=false)
	private int studId;
	@Column(name="student_name", nullable=false)
	private String studName;
	@Column(name="city")
	private String studCity;
	@Column(name="email_address")
	private String emailAdd;
	@OneToOne
	private Classes classes;
	
	public Student()
	{
		
	}

	public Student(String studName, String studCity,Classes classes) {
		super();
		this.studName = studName;
		this.studCity = studCity;
		this.classes=classes;
	}
	
	

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public String getStudCity() {
		return studCity;
	}

	public void setStudCity(String studCity) {
		this.studCity = studCity;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public String getEmailAdd() {
		return emailAdd;
	}

	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
	}

	
}
