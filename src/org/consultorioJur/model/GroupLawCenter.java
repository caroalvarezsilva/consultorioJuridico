package org.consultorioJur.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@View(members = "name,place")
public class GroupLawCenter {

	@Id
	@Hidden
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int groupId;

	@Column(length = 30)
	@Required
	private String name;

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(length = 30)
	@Required
	private String place;

	@OneToMany
	private List<AgendaRequest> agendaRequests;

	@Column(length = 30)
	@Required
	private String day;

	@Column(length = 30)
	@Required
	private String startTime;

	@Column(length = 30)
	@Required
	private String endTime;

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@ManyToOne
	private Teacher teacher;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public List<AgendaRequest> getAgendaRequests() {
		return agendaRequests;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public void setAgendaRequests(List<AgendaRequest> agendaRequests) {
		this.agendaRequests = agendaRequests;
	}

}
