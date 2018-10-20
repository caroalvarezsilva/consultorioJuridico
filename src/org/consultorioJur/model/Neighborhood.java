package org.consultorioJur.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Neighborhood {
	
	@Id
	String name;
	
	@ManyToOne( fetch=FetchType.LAZY, optional=false) 
	@NoCreate 
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
	
	
}
