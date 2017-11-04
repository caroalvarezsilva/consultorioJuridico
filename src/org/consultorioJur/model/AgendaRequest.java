package org.consultorioJur.model;

import java.util.*;

import javax.persistence.*;

import org.consultorioJur.actions.*;
import org.openxava.annotations.*;

@Entity
@View(members = "date, groupLawCenter;" + "person;" + "visitReason;")
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
	@DescriptionsList(
			 condition="groupId in (SELECT a.groupLawCenter.groupId FROM GroupLawCenterSchedule a   WHERE a.schedule.day = 'Martes')"
			)
	private GroupLawCenter groupLawCenter;

	@NoModify
	@NoCreate
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

}
