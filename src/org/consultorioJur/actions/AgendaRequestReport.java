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
	private String folderNumberFromAction;


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
		//folderNumber taken from the view when its in bar menu otherwise in the action save + print
		if (folderNumber == null || folderNumber.isEmpty()) {
			folderNumber = folderNumberFromAction;
		}
		String sql = "SELECT ar FROM AgendaRequest ar WHERE folderNumber = :folderNumber";
		Query query = XPersistence.getManager().createQuery(sql);
		query.setParameter("folderNumber", folderNumber);
		AgendaRequest agendaRequest = (AgendaRequest) query.getSingleResult();
	    
		//AgendaRequest agendaRequest = XPersistence.getManager().findByFolderName(AgendaRequest.class, id); 
		GroupLawCenter glc = agendaRequest.getGroupLawCenter();

		Person person = agendaRequest.getPerson();
		String personName = "";
		personName = personName.concat(person.getName());
		personName = personName.concat(" ");
		personName = personName.concat(person.getLastName());

		Map parameters = new HashMap();				
		parameters.put("agendaRequestId",folderNumber);
		parameters.put("personName", personName);
		String glcName = (String)glc.getName();
		if (glcName == null)
			glcName = "";
		parameters.put("group", glcName);
		
		String glcPlace = (String)glc.getPlace();
		if (glcPlace == null)
			glcPlace = "";
		parameters.put("place", glcPlace);

		
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
		
		Neighborhood nbh =address.getNeighborhood();
		if (nbh != null)
			a= a.concat(address.getNeighborhood().getName()).concat(", ");
		
		if (dep != null)
			a= a.concat(address.getDepartment().getName());
		
		


		String sa = address.getStreet();
		
		parameters.put("address", sa);
		parameters.put("addressB", a);
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

		return parameters;
	}

	public String getFolderNumberFromAction() {
		return folderNumberFromAction;
	}

	public void setFolderNumberFromAction(String folderNumberFromAction) {
		this.folderNumberFromAction = folderNumberFromAction;
	}
	
}
