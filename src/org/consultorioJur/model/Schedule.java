package org.consultorioJur.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Schedule {

	@Id
	@Hidden
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int scheduleId;

	@Column(length = 30)
	@Required
	private String day;

	@Column(length = 30)
	@Required
	private String startTime;

	@Column(length = 30)
	@Required
	private String endTime;

	@OneToMany(mappedBy = "schedule")
	private Collection<GroupLawCenterSchedule> groupLawCenterSchedules;

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

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Collection<GroupLawCenterSchedule> getGroupLawCenterSchedules() {
		return groupLawCenterSchedules;
	}

	public void setGroupLawCenterSchedules(Collection<GroupLawCenterSchedule> groupLawCenterSchedules) {
		this.groupLawCenterSchedules = groupLawCenterSchedules;
	}

}
