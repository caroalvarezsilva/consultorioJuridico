package org.consultorioJur.model;

import javax.persistence.*;

import org.openxava.annotations.*;


@Embeddable
@View(members="docNumber;"
		+"type;"
		
		)
public class Document {
	
	
	@ManyToOne
	@DescriptionsList
	private DocumentType type;
	
	@Id
	@Column(length = 30)
	String docNumber;

	public DocumentType getType() {
		return type;
	}

	public void setType(DocumentType type) {
		this.type = type;
	}

	public String getDocNumber() {
		return docNumber;
	}

	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}
	
}
