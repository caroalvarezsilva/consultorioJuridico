package org.consultorioJur.model;

import javax.persistence.*;
import org.consultorioJur.actions.*;
import org.openxava.annotations.*;
import org.openxava.model.*;

@Entity
@View(members="Busqueda por documento [documentId,documentType;"
		+"name, lastName;"
		+ "age;"
		+ "salary;"
		+ "address;"
		+ "phone,mobile;"
		+ "email;"
		+ "sex];"
		)
public class ConsultantPerson extends Person {
	
	
	@Column(length = 30)
	@Required
	private int age;
	
	@Embedded
	private Address address;

	@Column(length = 30)
	String email;
	
	@Column(length = 10)
	private int salary;
	
	@Editor("ValidValuesVerticalRadioButton")
	@Enumerated(EnumType.STRING)
	private Sex sex;

	public enum Sex {
		MALE, FEMALE
	};

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
