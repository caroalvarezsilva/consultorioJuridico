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

//	public String getApellido() {
//		return apellido;
//	}
//
//	public void setApellido(String apellido) {
//		this.apellido = apellido;
//	}
//
//	public String getDominio() {
//		return dominio;
//	}
//
//	public void setDominio(String dominio) {
//		this.dominio = dominio;
//	}
//
//	public String getCelular() {
//		return celular;
//	}
//
//	public void setCelular(String celular) {
//		this.celular = celular;
//	}
//
//	public String getDireccion() {
//		return direccion;
//	}
//
//	public void setDireccion(String direccion) {
//		this.direccion = direccion;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public boolean isEmail_validado() {
//		return email_validado;
//	}
//
//	public void setEmail_validado(boolean email_validado) {
//		this.email_validado = email_validado;
//	}
//
//	public String getEmail_token() {
//		return email_token;
//	}
//
//	public void setEmail_token(String email_token) {
//		this.email_token = email_token;
//	}
	
	
	
	
	
}
