package org.consultorioJur.model;

import java.io.*;
import java.util.*;

import javax.persistence.*;

import org.consultorioJur.actions.*;
import org.consultorioJur.calculators.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
/**
 * @author caralvarez
 *
 */
@Entity
@Views({ @View(members = "Fecha [day,date,groupLawCenter ];"  + "folderNumber, visitDate;" + "person;" + "visitReason;"
		+ "problem;"),
		@View(name = "Simple", members = "Codigo Expediente [folderNumber ];" + "person;" + "visitReason;"
				+ "problem;") })
public class AgendaRequest {


	@Id
	@Hidden
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int agendaRequestId;
	

	@Column(length = 10)
	@ReadOnly
	@DefaultValueCalculator(CalculateStringDate.class) // Current date
	private String visitDate;


	@Column(unique = true, length = 15)
	@Required
	private String folderNumber;

	@Column(length = 30)
	@Required
	private Date date;

	@NoModify
	@NoCreate
	@ManyToOne
	@DescriptionsList(descriptionProperties = "name,day,startTime,endTime", depends = "day", condition = "day= ?")
	private GroupLawCenter groupLawCenter;

	
	@ManyToOne
	@OnChangeSearch(OnChangeSearchPersonAction.class)
	private Person person;

	@NoModify
	@NoCreate
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@DescriptionsList(descriptionProperties = "reason")
	private VisitReason visitReason;

	@NoModify
	@NoCreate
	@OneToOne

	private CaseFile caseFile;

	public CaseFile getCaseFile() {
		return caseFile;
	}

	public void setCaseFile(CaseFile caseFile) {
		this.caseFile = caseFile;
	}

	private String problem;

	public GroupLawCenter getGroupLawCenter() {
		return groupLawCenter;
	}

	public void setGroupLawCenter(GroupLawCenter groupLawCenter) {
		this.groupLawCenter = groupLawCenter;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public VisitReason getVisitReason() {
		return visitReason;
	}

	public void setVisitReason(VisitReason visitReason) {
		this.visitReason = visitReason;
	}
	@Column(length = 350)
	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	@Depends("date")
	@LabelFormat(LabelFormatType.NO_LABEL)
	@Stereotype("LABEL")
	public String getDay() {
		if (date == null)
			return "";
		String day = "";
		switch (date.getDay()) {
		case 0:
			day = "Domingo";
			break;
		case 1:
			day = "Lunes";
			break;
		case 2:
			day = "Martes";
			break;
		case 3:
			day = "Miercoles";
			break;
		case 4:
			day = "Jueves";
			break;
		case 5:
			day = "Viernes";
			break;
		case 6:
			day = "Sabado";
		}
		return day;

	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public int getAgendaRequestId() {
		return agendaRequestId;
	}

	public void setAgendaRequestId(int agendaRequestId) {
		this.agendaRequestId = agendaRequestId;
	}

	public String getFolderNumber() {
		return folderNumber;
	}

	public void setFolderNumber(String folderNumber) {
		this.folderNumber = folderNumber;
	}
	
	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

}
