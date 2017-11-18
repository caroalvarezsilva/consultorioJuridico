package org.consultorioJur.model;

import java.io.*;
import java.util.*;

import javax.persistence.*;

import org.consultorioJur.actions.*;
import org.openxava.annotations.*;

@Entity
@Views({
	 @View(members = "Fecha [day,myDate,groupLawCenter ];"  +"Codigo Expediente [agendaRequestId ];" + "person;" + "visitReason"),
	 @View(name="Simple", members ="Codigo Expediente [agendaRequestId ];"+"person;" + "visitReason")
	 })
public class AgendaRequest {

	@Id
	@Column(length=15)
	private String agendaRequestId;
		
	@Column(length = 30)
	@Required
	private Date myDate;

    @NoModify @NoCreate @ManyToOne
    @DescriptionsList(depends = "day", condition="${groupId} in (SELECT a.groupLawCenter.groupId FROM GroupLawCenterSchedule a WHERE a.schedule.day = ?)"
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


	public Date getMyDate() {
		return myDate;
	}

	public void setMyDate(Date myDate) {
		this.myDate = myDate;
	}
	
	

	@Depends("myDate")
	@LabelFormat(LabelFormatType.NO_LABEL) 
    @Stereotype("LABEL")
    public String getDay() { 
    		System.out.println("Function getDay");
        if (myDate == null) return "";
        String day = new java.text.SimpleDateFormat("EEEE").format(myDate);
        System.out.println("day: " + day);
        return day;
		
    }

}
