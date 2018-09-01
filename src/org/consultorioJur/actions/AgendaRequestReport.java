package org.consultorioJur.actions;

import java.text.*;
import java.util.*;

import javax.persistence.*;

import org.consultorioJur.model.*;
import org.consultorioJur.model.Person.*;
import org.openxava.actions.*;
import org.openxava.jpa.*;

import net.sf.jasperreports.engine.*;

public class AgendaRequestReport extends JasperReportBaseAction {

	
	
	private AgendaRequest agendaRequest;


	@Override
	protected JRDataSource getDataSource() throws Exception {
		// TODO Auto-generated method stub
		return new JREmptyDataSource();
	}

	@Override
	protected String getJRXML() throws Exception {
		// TODO Auto-generated method stub
		return "AgendaRequest.jrxml";
	}

	@Override
	protected Map getParameters() throws Exception {
	//	AgendaRequest agendaRequest  = XPersistence.getManager().find(AgendaRequest.class,	 getView().getValues()); // TODO Auto-generated method stub

		
		//traigo la agenda la persona y el grupo de atencion
		String folderNumber =getView().getValueString("folderNumber");
		String sql = "SELECT ar FROM AgendaRequest ar WHERE folderNumber = :folderNumber";
		Query query = XPersistence.getManager().createQuery(sql);
		query.setParameter("folderNumber", folderNumber);
		AgendaRequest agendaRequest = (AgendaRequest) query.getSingleResult();
	    
		//AgendaRequest agendaRequest = XPersistence.getManager().findByFolderName(AgendaRequest.class, id); 
		GroupLawCenter glc = agendaRequest.getGroupLawCenter();
		Person person = agendaRequest.getPerson();
		String personName = person.getName();
		personName = personName.concat(" ");
		personName = personName.concat(person.getLastName());

		Map parameters = new HashMap();				
		parameters.put("agendaRequestId",folderNumber);
		parameters.put("personName", personName);
		parameters.put("group", (String)glc.getName());
		parameters.put("place", (String)glc.getPlace());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String date  = dateFormat.format(agendaRequest.getDate());
	
		parameters.put("day", date);
		
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
