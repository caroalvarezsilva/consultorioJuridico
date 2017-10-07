package org.consultorioJur.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class VisitReason {
	
	@Id
	@Hidden
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int visitReasonId;
	
	private String reason;

	
	public int getVisitReasonId() {
		return visitReasonId;
	}

	public void setVisitReasonId(int visitReasonId) {
		this.visitReasonId = visitReasonId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
