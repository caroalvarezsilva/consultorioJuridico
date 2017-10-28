package org.consultorioJur.model;


import javax.persistence.*;

import org.openxava.annotations.*;


@Entity
public class CaseFile {
	
	@Id
	@Hidden
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer caseFileId;
	
	@Embedded
	private CourtCaseFile courtCaseFile;
	


	@NoModify
	@NoCreate
	@OneToOne
	private AgendaRequest agendaRequest;
	
	@Embedded
	private Archived archived;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@DescriptionsList
	@NoModify
	@NoCreate
	private TypeOfManagment typeOfManagment;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@DescriptionsList
	@NoModify
	@NoCreate
	private TypeOfTrial typeOfTrial;

	public Integer getCaseFileId() {
		return caseFileId;
	}

	public void setCaseFileId(Integer caseFileId) {
		this.caseFileId = caseFileId;
	}

	public AgendaRequest getAgendaRequest() {
		return agendaRequest;
	}

	public void setAgendaRequest(AgendaRequest agendaRequest) {
		this.agendaRequest = agendaRequest;
	}

	public TypeOfManagment getTypeOfManagment() {
		return typeOfManagment;
	}

	public void setTypeOfManagment(TypeOfManagment typeOfManagment) {
		this.typeOfManagment = typeOfManagment;
	}

	public TypeOfTrial getTypeOfTrial() {
		return typeOfTrial;
	}

	public void setTypeOfTrial(TypeOfTrial typeOfTrial) {
		this.typeOfTrial = typeOfTrial;
	}

	public Archived getArchived() {
		return archived;
	}

	public void setArchived(Archived archived) {
		this.archived = archived;
	}

	public CourtCaseFile getCourtCaseFile() {
		return courtCaseFile;
	}

	public void setCourtCaseFile(CourtCaseFile courtCaseFile) {
		this.courtCaseFile = courtCaseFile;
	}

}
