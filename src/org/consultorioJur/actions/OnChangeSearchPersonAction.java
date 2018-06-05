package org.consultorioJur.actions;

import org.openxava.actions.*;

public class OnChangeSearchPersonAction extends OnChangeSearchAction {

	public void execute() throws Exception {
		super.execute();
		if (!getErrors().isEmpty()) {
			getErrors().removeAll();
			showDialog();
			getView().setModelName("Person");
			addActions("AgendaRequestModalPerson.cancel", "AgendaRequestModalPerson.add");

		}

	}

}
