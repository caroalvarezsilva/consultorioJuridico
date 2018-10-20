package org.consultorioJur.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Embeddable
public class Address {

	@Column(length = 50)
	private String street;

	@NoModify
	@NoCreate
	@ManyToOne(optional = true)
	@DescriptionsList
	private Department department;
	
	@NoModify
	@NoCreate
	@ManyToOne(optional = true)
	@DescriptionsList(
			 depends="this.department",
			 condition="${department.name} = ?" 
			)
	private Neighborhood neighborhood;


	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Neighborhood getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(Neighborhood neighborhood) {
		this.neighborhood = neighborhood;
	}
}
