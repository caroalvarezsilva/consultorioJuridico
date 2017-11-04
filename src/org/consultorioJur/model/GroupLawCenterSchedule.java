package org.consultorioJur.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@IdClass(GroupLawCenterScheduleId.class)
public class GroupLawCenterSchedule {
	
	@Id
	@Hidden
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int groupLawCenterScheduleId;
	
 	@Id
    @ManyToOne
    @JoinColumn(name="groupId")
    private GroupLawCenter groupLawCenter;
    
 	@Id
    @ManyToOne
    @JoinColumn(name="scheduleId")
    private Schedule schedule;

	public GroupLawCenter getGroupLawCenter() {
		return groupLawCenter;
	}

	public void setGroupLawCenter(GroupLawCenter groupLawCenter) {
		this.groupLawCenter = groupLawCenter;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public int getGroupLawCenterScheduleId() {
		return groupLawCenterScheduleId;
	}

	public void setGroupLawCenterScheduleId(int groupLawCenterScheduleId) {
		this.groupLawCenterScheduleId = groupLawCenterScheduleId;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}


	 	

}
