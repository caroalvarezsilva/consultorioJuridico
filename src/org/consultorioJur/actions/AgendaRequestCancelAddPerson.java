package org.consultorioJur.actions;

import java.util.*;
import org.openxava.actions.*;


public class AgendaRequestCancelAddPerson extends CancelDialogAction {

	@Override
	public void execute() throws Exception {
		
		super.execute();
		setView(getView().getParent());
		getView().setModelName("AgendaRequest");
		
	}
}
