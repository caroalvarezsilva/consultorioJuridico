package org.consultorioJur.actions;

import org.consultorioJur.model.*;
import org.openxava.actions.*;

import net.sf.jasperreports.engine.*;

import java.text.*;
import java.util.*;

import javax.persistence.*;
import org.consultorioJur.model.Person.*;
import org.openxava.jpa.*;

public class CaseFileReport extends JasperReportBaseAction {

	
	
	private CaseFile caseFile;


	@Override
	protected JRDataSource getDataSource() throws Exception {
		// TODO Auto-generated method stub
		return new JREmptyDataSource();
	}

	@Override
	protected String getJRXML() throws Exception {
		// TODO Auto-generated method stub
		return "CaseFile.jrxml";
	}

	@Override
	protected Map getParameters() throws Exception {
	//	AgendaRequest agendaRequest  = XPersistence.getManager().find(AgendaRequest.class,	 getView().getValues()); // TODO Auto-generated method stub

		
		//traigo la agenda la persona y el grupo de atencion
		Integer caseFileId =(Integer) getView().getValue("caseFileId");
		String sql = "SELECT cf FROM CaseFile cf WHERE caseFileId = :caseFileId";
		Query query = XPersistence.getManager().createQuery(sql);
		query.setParameter("caseFileId", caseFileId);
		CaseFile caseFile = (CaseFile) query.getSingleResult();
	    
		CourtCaseFile cCF = caseFile.getCourtCaseFile();
		String cName = "";
		String cdate = "";
		String cfile = "";
		String dfile = "";
		String csubject = "";
		String ctot = "";

		if (cCF!=null) {
			TypeOfTrial tot=	cCF.getTypeOfTrial();
			if (tot!=null)
				ctot = tot.getName();
			Court court = cCF.getCourt();
			if (court!=null)
				cName = court.getName(); 
			Date courtDate = cCF.getCourtdate();
			if (courtDate!=null) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				cdate  = dateFormat.format(courtDate);
			}

			cfile = cCF.getCourtFile();
			dfile = cCF.getDescriptionFile();
			Subject subject = cCF.getSubject();
			if (subject!=null)
				csubject = subject.getName(); 
		}
		

			
		Map parameters = new HashMap();	
		parameters.put("descriptionFile",dfile);
		parameters.put("file",cfile);
		parameters.put("typeoftrail", ctot);
		parameters.put("courtday" ,cdate);
		parameters.put("subject", csubject);
		parameters.put("court",cName);
		
		AgendaRequest agendaRequest = caseFile.getAgendaRequest();
		//AgendaRequest agendaRequest = XPersistence.getManager().findByFolderName(AgendaRequest.class, id); 
		GroupLawCenter glc = agendaRequest.getGroupLawCenter();

		Person person = agendaRequest.getPerson();
		String personName = "";
		personName = personName.concat(person.getName());
		personName = personName.concat(" ");
		personName = personName.concat(person.getLastName());

			
		parameters.put("agendaRequestId",agendaRequest.getFolderNumber());
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
		if (dep != null)
			a= a.concat(address.getDepartment().getName());
			
		a= a.concat(" ");
		Neighborhood nbh =address.getNeighborhood();
		if (nbh != null)
			a= a.concat(address.getNeighborhood().getName());

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

		
		
		//parameters.put("number",agendaRequest.getAgendaRequestId());

		return parameters;
	}

}
