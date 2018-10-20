package org.consultorioJur.model;


import javax.persistence.*;

import org.consultorioJur.actions.*;
import org.openxava.annotations.*;
import org.openxava.model.*;

@Entity
@View(members="Búsqueda por documento [documentId,documentType;"
		+"name, lastName;"
		+ "age;"
		+ "salary;"
		+ "address;"
		+ "phone,mobile;"
		+ "email;"
		+ "sex];"
		)
public class Person {
	
	@Column(length = 30)
	@Required
	private String name;
	
	@Column(length = 30)
	@Required
	private String lastName;
	

	@Column(length = 30)
	@Required
	private int age;
	
	@Id
	@Column(length = 10)
	private String documentId;
	
	@ManyToOne
	@DescriptionsList
	@NoModify
	@NoCreate
	private DocumentType documentType;
	
	@Embedded
	private Address address;
	
	@Column(length = 30)
	String phone; 

	@Column(length = 30)
	String mobile;

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

	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public DocumentType getDocumentType() {
		return documentType;
	}
	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
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
