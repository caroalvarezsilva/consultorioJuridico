package org.consultorioJur.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Teacher {
	
	@Id
	@Hidden
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacherId;

	@Column(length = 30)
	@Required
	private String name;
	
	@ManyToMany
	  @JoinTable(
	      name="TeacherGroupLawCenter",
	      joinColumns=@JoinColumn(name="teacherId", referencedColumnName="teacherId"),
	      inverseJoinColumns=@JoinColumn(name="groupId", referencedColumnName="groupId"))
	private List<GroupLawCenter> groupLawCenters;

	public List<GroupLawCenter> getGroupLawCenters() {
		return groupLawCenters;
	}

	public void setGroupLawCenters(List<GroupLawCenter> groupLawCenters) {
		this.groupLawCenters = groupLawCenters;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
