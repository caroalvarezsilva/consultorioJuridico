package org.consultorioJur.model;

import javax.persistence.*;

import org.consultorioJur.actions.*;
import org.openxava.annotations.*;

@Entity 
public class CaseFileStudent {
	
	@Id
	@Hidden
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long caseFileStudentId;
	
	@Embedded
	private StudentCJ student;
	

	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "caseFileId")
    private CaseFile caseFile;

    private String year;
    
	public long getCaseFileStudentId() {
		return caseFileStudentId;
	}

	public void setCaseFileStudentId(long caseFileStudentId) {
		this.caseFileStudentId = caseFileStudentId;
	}

	public StudentCJ getStudent() {
		return student;
	}

	public void setStudent(StudentCJ student) {
		this.student = student;
	}

	public CaseFile getCaseFile() {
		return caseFile;
	}

	public void setCaseFile(CaseFile caseFile) {
		this.caseFile = caseFile;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
    
	
    
}
