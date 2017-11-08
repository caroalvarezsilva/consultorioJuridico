package org.consultorioJur.actions;

import org.openxava.actions.*;
import org.openxava.jpa.XPersistence;
import java.util.*;

import org.openxava.actions.*;
import org.openxava.util.*;

import java.util.*;

import org.consultorioJur.model.*;
import org.openxava.jpa.*;

public class CreateCaseFile extends ViewBaseAction {

	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub

		getView().getAllValues().getClass();
		if (!Is.emptyString(getView().getValueString("caseFile"))) {
			String file = getView().getValueString("caseFile");
			addMessage("Ya existe un expediente creado para esta Agenda" + file);
		} else {
			Integer id = getView().getValueInt("agendaRequestId");
			AgendaRequest agendaRequest = XPersistence.getManager().find(AgendaRequest.class, id);
			CaseFile casefile = new CaseFile();
			casefile.setAgendaRequest(agendaRequest);
			XPersistence.getManager().persist(casefile);
			addMessage("Se creo el expediente");
		}

	}

}
