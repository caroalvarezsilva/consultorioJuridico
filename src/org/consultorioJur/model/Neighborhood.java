package org.consultorioJur.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Tab(properties="name")
public class Neighborhood {
	
	@Id
	@Hidden
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	String name;
	
	@ManyToOne( fetch=FetchType.LAZY, optional=false) 
	@NoCreate 
	@DescriptionsList
	Department department;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
