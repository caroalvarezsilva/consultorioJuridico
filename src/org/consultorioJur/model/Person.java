package org.consultorioJur.model;

import javax.persistence.*;

import org.consultorioJur.actions.*;
import org.openxava.annotations.*;
import org.openxava.model.*;

@Entity

public class Person {

	@Id
	@Column(length = 10)
	private String documentId;

	@Column(length = 30)
	@Required
	private String name;

	@Column(length = 30)
	@Required
	private String lastName;

	@ManyToOne
	@DescriptionsList
	@NoModify
	@NoCreate
	private DocumentType documentType;

	@Column(length = 30)
	String phone;

	@Column(length = 30)
	String mobile;

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
}
