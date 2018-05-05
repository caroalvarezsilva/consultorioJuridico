package org.consultorioJur.actions;

import java.text.DateFormat;
import java.util.*;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.consultorioJur.model.*;
import org.consultorioJur.model.Person.*;
import org.openxava.actions.IChainAction;
import org.openxava.actions.JasperReportBaseAction;
import org.openxava.jpa.*;
import org.openxava.model.MapFacade;
import org.openxava.util.Messages;
import org.openxava.validators.ValidationException;




public class AgendaRequestReport extends JasperReportBaseAction  {

	
	
	private AgendaRequest agendaRequest;


	@Override
	protected JRDataSource getDataSource() throws Exception {
		// TODO Auto-generated method stub
		return new JREmptyDataSource();
	}

	@Override
	protected String getJRXML() throws Exception {
		// TODO Auto-generated method stub
		return "/Users/caralvarez/Personal/Facultad/Proyecto/AgendaRequest.jrxml";
	}

	@Override
	protected Map getParameters() throws Exception {
	//	AgendaRequest agendaRequest  = XPersistence.getManager().find(AgendaRequest.class,	 getView().getValues()); // TODO Auto-generated method stub

		
		//traigo la agenda la persona y el grupo de atencion
		String id =getView().getValueString("agendaRequestId");
		AgendaRequest agendaRequest = XPersistence.getManager().find(AgendaRequest.class, id); 
		GroupLawCenter glc = agendaRequest.getGroupLawCenter();
		Person person = agendaRequest.getPerson();
		String personName = person.getName();
		personName = personName.concat(" ");
		personName = personName.concat(person.getLastName());

		Map parameters = new HashMap();				
		parameters.put("agendaRequestId",id);
		parameters.put("personName", personName);
		parameters.put("group", (String)glc.getName());
		parameters.put("place", (String)glc.getPlace());
		parameters.put("day", (String)glc.getDay());
		
		String hourst = glc.getStartTime();
		hourst = hourst.concat(" a ");
		hourst = hourst.concat(glc.getEndTime());
		
		
		parameters.put("hourst", hourst);
		Sex sex = person.getSex(); 
		String s;
		if (sex == null)
		 	s = "";
		else {
			s = person.getSex().toString() ;
			if (s== "MALE")
			s = "Masculino" ;
			else
				s="Femenino";
		}
		
		parameters.put("sex", s);
		parameters.put("age", person.getAge());
		
		Address address = person.getAddress();
		String a = ""; 
		Department dep = address.getDepartment();
		if (dep != null)
			a= a.concat(address.getDepartment().getName());
			
		a= a.concat(" ");
		a= a.concat(address.getNeighborhood());
		a= a.concat(" ");
		a= a.concat(address.getStreet());
		
		parameters.put("address", a);
		parameters.put("salary", person.getSalary());
		
		DocumentType dt = person.getDocumentType();
		String d = "";
		if (dt != null)
			 d= person.getDocumentType().getName();
		d = d.concat(" ");
		d = d.concat(person.getDocumentId());
		parameters.put("document", d);
		parameters.put("phone", person.getPhone());
		parameters.put("mobile", person.getMobile());
		parameters.put("motive", agendaRequest.getVisitReason().getReason());
		parameters.put("email", person.getEmail());
		parameters.put("problem", (agendaRequest.getProblem()!=null)?agendaRequest.getProblem():"");

		
		
		//parameters.put("number",agendaRequest.getAgendaRequestId());

		return parameters;
	}

}
