package org.consultorioJur.actions;

import org.openxava.actions.*;
import org.openxava.tab.*;


public class InitialConfigForAgendaRequest extends BaseAction {

	@Override
	public void execute() throws Exception {
		Tab tab = (Tab) getContext().get("ConsultorioJuridico", "AgendaRequest", "xava_tab");
		tab.setFilterVisible(true);
	}


}
