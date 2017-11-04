package org.consultorioJur.model;

import javax.persistence.*;

@Entity
public class TypeOfTrial {
	@Id
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}




}
