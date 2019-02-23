package org.consultorioJur.model;

import java.util.*;

import javax.persistence.*;

import org.consultorioJur.actions.*;
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
	@ReferenceView("Simple")
	private AgendaRequest agendaRequest;

	@OneToMany(mappedBy = "caseFile")
	@ElementCollection
	@ListProperties("year, student.id, student.nombre")
	private Set<CaseFileStudent> caseFileStudents = new HashSet<CaseFileStudent>();
	

	public AgendaRequest getAgendaRequest() {
		return agendaRequest;
	}

	public void setAgendaRequest(AgendaRequest agendaRequest) {
		this.agendaRequest = agendaRequest;
	}

	@Embedded
	private Archived archived;

	public Integer getCaseFileId() {
		return caseFileId;
	}

	public void setCaseFileId(Integer caseFileId) {
		this.caseFileId = caseFileId;
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

	public Set<CaseFileStudent> getCaseFileStudents() {
		return caseFileStudents;
	}

	public void setCaseFileStudents(Set<CaseFileStudent> caseFileStudents) {
		this.caseFileStudents = caseFileStudents;
	}
}
