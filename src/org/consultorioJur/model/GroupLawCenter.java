package org.consultorioJur.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@View(members="name,place"  
		)
public class GroupLawCenter {
	
	@Id
	@Hidden
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int groupId;
	
	@Column(length = 30)
	@Required
	private String name;
	
	@Column(length = 30)
	@Required
	private String place; 
	
	@OneToMany
	private List<AgendaRequest> agendaRequests; 
	
//	@ManyToMany
//	  @JoinTable(
//	      name="GroupLawCenterSchedule",
//	      joinColumns=@JoinColumn(name="groupId", referencedColumnName="groupId"),
//	      inverseJoinColumns=@JoinColumn(name="scheduleId", referencedColumnName="scheduleId"))
//	private List<Schedule> schedules;
//	
	@OneToMany(mappedBy = "groupLawCenter")
    private Collection<GroupLawCenterSchedule> groupLawCenterSchedules;
	
	@ManyToMany(mappedBy="groupLawCenters")
	private List<Teacher> teacher;

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
	

//	public List<Schedule> getSchedules() {
//		return schedules;
//	}
//
//	public void setSchedules(List<Schedule> schedules) {
//		this.schedules = schedules;
//	}

	public Collection<GroupLawCenterSchedule> getGroupLawCenterSchedules() {
		return groupLawCenterSchedules;
	}

	public void setGroupLawCenterSchedules(Collection<GroupLawCenterSchedule> groupLawCenterSchedules) {
		this.groupLawCenterSchedules = groupLawCenterSchedules;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public List<Teacher> getTeacher() {
		return teacher;
	}

	public void setTeacher(List<Teacher> teacher) {
		this.teacher = teacher;
	}

	public List<AgendaRequest> getAgendaRequests() {
		return agendaRequests;
	}

	public void setAgendaRequests(List<AgendaRequest> agendaRequests) {
		this.agendaRequests = agendaRequests;
	}

	
	
	
	

}
