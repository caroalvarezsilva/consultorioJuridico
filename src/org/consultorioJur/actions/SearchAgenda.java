package org.consultorioJur.actions;

import org.consultorioJur.model.*;
import org.openxava.actions.*;
import org.openxava.jpa.*;

public class SearchAgenda extends SearchByViewKeyAction  {

	public void execute() throws Exception {
        super.execute();
        AgendaRequest agendaRequest = XPersistence.getManager().find(AgendaRequest.class, getView().getValue("agendaRequestId"));
        if (agendaRequest.getCaseFile() != null) {
            addActions("AgendaRequest.UpdateCaseFile");
            removeActions("AgendaRequest.CreateCaseFile");
            getMessages().remove("entity_created");
        }
        else {
        		removeActions("AgendaRequest.UpdateCaseFile");
            addActions("AgendaRequest.CreateCaseFile");
          
        }
    }

}
