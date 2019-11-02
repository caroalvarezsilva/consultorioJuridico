package org.consultorioJur.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class CaseFileNotes {

	@Id
	@Hidden
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long caseFileNotesId;

	@Embedded
	private Notes note;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "caseFileId")
	private CaseFile caseFile;


	public long getCaseFileNotesId() {
		return caseFileNotesId;
	}

	public void setCaseFileNotesId(long caseFileNotesId) {
		this.caseFileNotesId = caseFileNotesId;
	}

	public Notes getNote() {
		return note;
	}

	public void setNote(Notes note) {
		this.note = note;
	}

	public CaseFile getCaseFile() {
		return caseFile;
	}

	public void setCaseFile(CaseFile caseFile) {
		this.caseFile = caseFile;
	}

}
