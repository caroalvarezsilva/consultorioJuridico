package org.consultorioJur.model;

import java.util.*;

import javax.persistence.*;

import org.consultorioJur.actions.*;
import org.openxava.annotations.*;

@Entity
@Views({
	@View(members = "day,date,groupLawCenter;" + "person;" + "visitReason"),
	@View(name="Simple", members ="person;" + "visitReason")
})
public class AgendaRequest {

	@Id
	@Hidden
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int agendaRequestId;

	@Column(length = 30)
	@Required
	private Date date;

	@NoModify
	@NoCreate
	@ManyToOne
	@DescriptionsList(depends = "day", condition = "${groupId} in (SELECT a.groupLawCenter.groupId  FROM GroupLawCenterSchedule a WHERE a.schedule.day = ?)")
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

	private String problem;

	@NoModify
	@NoCreate
	@OneToOne
	private CaseFile caseFile;

	public int getAgendaRequestId() {
		return agendaRequestId;
	}

	public void setAgendaRequestId(int agendaRequestId) {
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

	public CaseFile getCaseFile() {
		return caseFile;
	}

	public void setCaseFile(CaseFile caseFile) {
		this.caseFile = caseFile;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Depends("date")
	@LabelFormat(LabelFormatType.NO_LABEL)
	@Stereotype("LABEL")
	public String getDay() {
		if (date == null)
			return "";
		String day = new java.text.SimpleDateFormat("EEEE").format(date);
		return day;

	}

}
