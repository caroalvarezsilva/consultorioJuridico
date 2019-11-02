package org.consultorioJur.model;

import java.util.*;
import javax.persistence.*;

import org.consultorioJur.actions.*;
import org.openxava.annotations.*;

@Embeddable
public class StudentCJ {
	

	@Column(length = 10)
	@OnChange(OnChangeLookInFderDB.class)
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
