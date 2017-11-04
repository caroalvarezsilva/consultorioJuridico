package org.consultorioJur.model;

import javax.persistence.*;

import org.openxava.annotations.*;


@View(members="Archivo[file,causeToFile];")
@Embeddable
public class Archived {
	
	@Column(length = 50)
	private String file;
	
	@NoModify
	@NoCreate
	@ManyToOne(optional = true)
	@DescriptionsList
	private CauseToFile causeToFile;

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public CauseToFile getCauseToFile() {
		return causeToFile;
	}

	public void setCauseToFile(CauseToFile causeToFile) {
		this.causeToFile = causeToFile;
	}
	
	

}
