package org.consultorioJur.calculators;

import java.util.*;

import org.openxava.calculators.*;

public class CalculateStringDate implements ICalculator {
		
	private static final long serialVersionUID = 6179191486673044493L;
		@Override
		public Object calculate() throws Exception {
			// TODO Auto-generated method stub
			Calendar cal = Calendar.getInstance();
			cal.setTime( new java.util.Date() );
			String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
			String day   = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
			String year   = String.valueOf(cal.get(Calendar.YEAR));
			String date = day.concat("/").concat(month).concat("/").concat(year);
			return date;
		
		}

}
