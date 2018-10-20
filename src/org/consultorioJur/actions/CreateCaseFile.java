package org.consultorioJur.actions;

import org.openxava.actions.*;
import  org.openxava.jpa.XPersistence;
import java.util.*;

import javax.inject.*;
import javax.persistence.*;

import org.openxava.actions.*;
import org.openxava.util.*;
 
import java.util.*;

import org.consultorioJur.model.*;
import org.openxava.jpa.*;

public class CreateCaseFile  extends ViewBaseAction implements IChangeModuleAction{

	@Inject
	@Named("caseFileKey")
	private Map caseFileKey;
	
	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		getView().getAllValues().getClass();

	    String folderNumber = getView().getValueString("folderNumber");
	    String sql = "SELECT ar FROM AgendaRequest ar WHERE folderNumber = :folderNumber";
		Query query = XPersistence.getManager().createQuery(sql);
		query.setParameter("folderNumber", folderNumber);
		AgendaRequest agendaRequest = (AgendaRequest) query.getSingleResult();
	 
		if (agendaRequest.getCaseFile() != null) {
			//addMessage("Ya existe un expediente asociado a esta Agenda");
			caseFileKey = toKey(agendaRequest.getCaseFile());
			return;
		} else {
			CaseFile caseFile = new CaseFile();
			caseFile.setCaseFileId(null);
			caseFile.setAgendaRequest(agendaRequest);
			XPersistence.getManager().persist(caseFile);
			caseFileKey = toKey(caseFile);
			agendaRequest.setCaseFile(caseFile);
			addMessage("Se creó el expediente");
		}
		setNextMode(LIST);
	}

	// en el objeto de sesi�n invoicing_ currentInvoiceKey
	private Map toKey(CaseFile caseFile) { // Extrae la clave de la factura en formato mapa
		Map key = new HashMap();
		key.put("caseFileId",caseFile.getCaseFileId());
		return key;
	}
	
	@Override
	public String getNextModule() {
		// TODO Auto-generated method stub
		return "CaseFileModule";
	}

	@Override
	public boolean hasReinitNextModule() {
		// TODO Auto-generated method stub
		return true;
	}
}

