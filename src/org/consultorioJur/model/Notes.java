package org.consultorioJur.model;

import java.util.*;

import javax.persistence.*;

import org.consultorioJur.calculators.*;
import org.openxava.annotations.*;

@Embeddable
public class Notes {

	//@ReadOnly
	@DefaultValueCalculator(CalculateStringDate.class) // Current date
	private Date date;
	
	//@ReadOnly
	//@Hidden
	//@DefaultValueCalculator(SetNotesUserCalculator.class)
	private String user;
	
	@Column(length=2000)
	@Stereotype("MEMO")
	private String detail;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
