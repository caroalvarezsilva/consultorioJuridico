package org.consultorioJur.model;

import java.io.*;

import javax.persistence.*;

@Embeddable
public class GroupLawCenterScheduleId implements Serializable{

    
    private Long groupLawCenter;

  
    private Long schedule;


	public Long getGroupLawCenter() {
		return groupLawCenter;
	}


	public void setGroupLawCenter(Long groupLawCenter) {
		this.groupLawCenter = groupLawCenter;
	}


	public Long getSchedule() {
		return schedule;
	}


	public void setSchedule(Long schedule) {
		this.schedule = schedule;
	}
    
    
}
