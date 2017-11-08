package org.consultorioJur.model;

import javax.persistence.*;

@Entity
public class Department {

	@Id
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
