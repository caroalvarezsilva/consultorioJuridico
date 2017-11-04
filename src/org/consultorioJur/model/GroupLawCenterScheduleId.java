package org.consultorioJur.model;

import java.io.*;

import javax.persistence.*;

@Embeddable
public class GroupLawCenterScheduleId implements Serializable{

    
    private int groupLawCenter;

  
    private int schedule;


	public int getGroupLawCenter() {
		return groupLawCenter;
	}


	public void setGroupLawCenter(int groupLawCenter) {
		this.groupLawCenter = groupLawCenter;
	}


	public int getSchedule() {
		return schedule;
	}


	public void setSchedule(int schedule) {
		this.schedule = schedule;
	}



    
    
}
