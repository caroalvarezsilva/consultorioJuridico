package org.consultorioJur.actions;

import java.text.*;
import java.util.*;

import javax.persistence.*;

import org.consultorioJur.model.*;
import org.consultorioJur.model.ConsultantPerson.*;
import org.consultorioJur.model.Person.*;
import org.openxava.actions.*;
import org.openxava.jpa.*;

import net.sf.jasperreports.engine.*;

public class AgendaRequestReport extends JasperReportBaseAction {

	private AgendaRequest agendaRequest;
	private String folderNumberFromAction;
	private String visitDateFromAction;
	private Integer agendaRequestIdFromAction;


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

		/* Cuando se quiere imprimir una agenda que ya existia, ya tenemos el agendaRequestId por lo que hacemos la consulta con este id, 
		en el caso de que sea una agenda nueva al no tener todavia ese id se hace la consulta por folder number + visitDate,
		con la migración de datos pasa que existen mas de un foldernumber para distintas agendas */
		String folderNumber;
		Integer agendaRequestId = (getView().getValueInt("agendaRequestId") == 0 )? agendaRequestIdFromAction: getView().getValueInt("agendaRequestId");
		if (agendaRequestId != 0 && agendaRequestId != null) {
			String sql = "SELECT ar FROM AgendaRequest ar WHERE agendaRequestId = :agendaRequestId";
			Query query = XPersistence.getManager().createQuery(sql);
			query.setParameter("agendaRequestId", agendaRequestId);
			agendaRequest = (AgendaRequest) query.getSingleResult();	
			folderNumber = agendaRequest.getFolderNumber();
		} else {
			//hago la consulta por folderNumber, caso de nueva agenda
			String sql = "SELECT ar FROM AgendaRequest ar WHERE folderNumber = :folderNumber AND visitDate =:visitDate";
			Query query = XPersistence.getManager().createQuery(sql);
			folderNumber = folderNumberFromAction;
			String visitDate = visitDateFromAction;
			query.setParameter("folderNumber", folderNumber);
			query.setParameter("visitDate", visitDate);
			agendaRequest = (AgendaRequest) query.getSingleResult();
		}

		GroupLawCenter glc = agendaRequest.getGroupLawCenter();

		ConsultantPerson person = agendaRequest.getPerson();
		String personName = "";
		personName = personName.concat(person.getName());
		personName = personName.concat(" ");
		personName = personName.concat(person.getLastName());

		Map parameters = new HashMap();				
		parameters.put("agendaRequestId",folderNumber);
		parameters.put("personName", personName);

		if (glc != null) {
			String glcName = (String)glc.getName();
			if (glcName == null)
				glcName = "";
			parameters.put("group", glcName);

			String glcPlace = (String)glc.getPlace();
			if (glcPlace == null)
				glcPlace = "";
			parameters.put("place", glcPlace);	


			String hourst = glc.getStartTime();
			hourst = hourst.concat(" a ");
			hourst = hourst.concat(glc.getEndTime());
			parameters.put("hourst", hourst);
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String date  = dateFormat.format(agendaRequest.getDate());

		parameters.put("day", date);

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
		String sa = "";

		if (address != null) {
			sa = address.getStreet();
			Department dep = address.getDepartment();
			Neighborhood nbh =address.getNeighborhood();
			if (nbh != null)
				a= a.concat(address.getNeighborhood().getName()).concat(", ");

			if (dep != null)
				a= a.concat(address.getDepartment().getName());
		}	
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

	public AgendaRequest getAgendaRequest() {
		return agendaRequest;
	}

	public void setAgendaRequest(AgendaRequest agendaRequest) {
		this.agendaRequest = agendaRequest;
	}


	public String getVisitDateFromAction() {
		return visitDateFromAction;
	}

	public void setVisitDateFromAction(String visitDateFromAction) {
		this.visitDateFromAction = visitDateFromAction;
	}

	public Integer getAgendaRequestIdFromAction() {
		return agendaRequestIdFromAction;
	}

	public void setAgendaRequestIdFromAction(Integer agendaRequestIdFromAction) {
		this.agendaRequestIdFromAction = agendaRequestIdFromAction;
	}



}
