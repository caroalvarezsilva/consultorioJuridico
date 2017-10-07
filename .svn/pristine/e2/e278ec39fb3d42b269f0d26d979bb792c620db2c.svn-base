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

	@Column(length = 30)
	private String neighborhood;

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

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

}
