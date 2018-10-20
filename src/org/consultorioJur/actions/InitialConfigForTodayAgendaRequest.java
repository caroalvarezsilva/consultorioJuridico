package org.consultorioJur.actions;

import java.util.*;

import org.openxava.actions.*;
import org.openxava.tab.*;


public class InitialConfigForTodayAgendaRequest extends BaseAction {

	@Override
	public void execute() throws Exception {
	
		Tab tab = (Tab) getContext().get("ConsultorioJuridico", "TodayAgendaRequest", "xava_tab");

		tab.setConditionValue("date", new Date());
		tab.setFilterVisible(false);
		
	
	}


}
