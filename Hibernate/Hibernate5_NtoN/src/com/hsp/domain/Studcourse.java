package com.hsp.domain;

public class Studcourse implements java.io.Serializable {

	// Fields

	private Integer stucourseid;
	private Course course;
	private Student student;
	private Integer grade;

	// Constructors

	/** default constructor */
	public Studcourse() {
	}

	/** minimal constructor */
	public Studcourse(Integer grade) {
		this.grade = grade;
	}

	/** full constructor */
	public Studcourse(Course course, Student student, Integer grade) {
		this.course = course;
		this.student = student;
		this.grade = grade;
	}

	// Property accessors

	public Integer getStucourseid() {
		return this.stucourseid;
	}

	public void setStucourseid(Integer stucourseid) {
		this.stucourseid = stucourseid;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

}