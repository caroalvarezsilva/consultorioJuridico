package org.consultorioJur.calculators;

import org.openxava.calculators.*;

public class GroupLawCenterCalculator implements ICalculator {

	private String dateDay;
	@Override
	public Object calculate() throws Exception {
		String day = dateDay;
		System.out.println("dat"+day);
		return null;
	}
	public String getDateDay() {
		return dateDay;
	}
	public void setDateDay(String dateDay) {
		this.dateDay = dateDay;
	}
	
	
}