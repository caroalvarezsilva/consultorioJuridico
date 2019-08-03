package org.consultorioJur.model;

import java.util.*;
import javax.persistence.*;

import org.consultorioJur.actions.*;
import org.openxava.annotations.*;

@Entity
public class Student {
	
	@Column(length = 10)
	@Id
	private int id;
	
	
	@Column(length = 64)
	private String nombre;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
