package org.consultorioJur.model;

import java.io.*;
import java.util.*;

import javax.persistence.*;

import org.consultorioJur.actions.*;
import org.openxava.annotations.*;

/**
 * @author caralvarez
 *
 */
@Entity
@Views({ @View(members = "Fecha [day,date,groupLawCenter ];" + "agendaRequestId;" + "person;"
		+ "visitReason;" + "problem;"),
		@View(name = "Simple", members = "Codigo Expediente [agendaRequestId ];" + "person;" + "visitReason;" + "problem;") })
public class AgendaRequest {

	@Id
	@Column(length = 15)
	private String agendaRequestId;

	@Column(length = 30)
	@Required
	private Date date;

	@NoModify
	@NoCreate
	@ManyToOne
	@DescriptionsList(descriptionProperties = "name,day,startTime,endTime", depends = "day", condition = "day= ?")
	private GroupLawCenter groupLawCenter;

	@NoModify
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

	public String getAgendaRequestId() {
		return agendaRequestId;
	}

	public void setAgendaRequestId(String agendaRequestId) {
		this.agendaRequestId = agendaRequestId;
	}

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

}
