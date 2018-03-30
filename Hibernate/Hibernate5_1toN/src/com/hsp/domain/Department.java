package com.hsp.domain;

import java.util.HashSet;
import java.util.Set;

public class Department implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	//����һ��set���� ��Ӧ���ѧ��  ���ֳ�one2many
	private Set<Students> students = new HashSet(0);
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Students> getStudents() {
		return students;
	}
	public void setStudents(Set<Students> students) {
		this.students = students;
	}

}
