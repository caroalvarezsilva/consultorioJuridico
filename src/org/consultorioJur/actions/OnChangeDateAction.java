	package org.consultorioJur.actions;

import java.text.*;
import java.util.*;

import org.consultorioJur.model.*;
import org.openxava.actions.*;
import org.openxava.jpa.*;

public class OnChangeDateAction extends OnChangePropertyBaseAction {

	@Override
	public void execute() throws Exception {
		Date date = (Date) getNewValue();
//		String day = getDay(date);
		
//		System.out.println(day);
//		//List<String> list = new ArrayList<String>();
//		//Collection<GroupLawCenter> list2 = XPersistence.getManager()
//          //      .find(Schedule.class,day).getGroups();
//		
//		Collection<GroupLawCenter> list = XPersistence.getManager()
//			    .createQuery(
//			        "from Schedule s where s.day = 'lunes')")  // JPQL query
//			    .getResultList(); 
//		
//		
//		getView().setValue("groupLawCenter",list);
		

	}
	
	public String getDay(Date date) {
//		Calendar cal = Calendar.getInstance();
//	    //cal.setTime(date);
//	    //DateFormat f = new SimpleDateFormat("EEEE");
//	    //return f.format(date);
		return null;
	}
}
