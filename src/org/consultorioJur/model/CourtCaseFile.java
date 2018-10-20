package org.consultorioJur.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;


@View(members="Expediente[courtFile,court;"
		+ " courtdate;"
		+"subject, typeOfTrial;"
		+ "descriptionFile];"
		)

@Embeddable
public class CourtCaseFile {
	

	@Column(length = 50)
	private String courtFile;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@DescriptionsList
	@NoModify
	@NoCreate
	
	private Court court;
	@Embedded
	

	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@DescriptionsList
	@NoModify
	@NoCreate
	private TypeOfTrial typeOfTrial;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@DescriptionsList
	@NoModify
	@NoCreate
	private Subject subject;
	
	@Column(length = 30)
	private Date courtdate;
	
	@Column(length = 150)
	private String descriptionFile;

	public String getCourtFile() {
		return courtFile;
	}

	public void setCourtFile(String courtFile) {
		this.courtFile = courtFile;
	}

	public Court getCourt() {
		return court;
	}

	public void setCourt(Court court) {
		this.court = court;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Date getCourtdate() {
		return courtdate;
	}

	public void setCourtdate(Date courtdate) {
		this.courtdate = courtdate;
	}

	public String getDescriptionFile() {
		return descriptionFile;
	}

	public void setDescriptionFile(String descriptionFile) {
		this.descriptionFile = descriptionFile;
	}
	

	public TypeOfTrial getTypeOfTrial() {
		return typeOfTrial;
	}

	public void setTypeOfTrial(TypeOfTrial typeOfTrial) {
		this.typeOfTrial = typeOfTrial;
	}

}
