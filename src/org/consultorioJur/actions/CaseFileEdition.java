package org.consultorioJur.actions;

import org.openxava.actions.*;

public class CaseFileEdition extends SaveAction implements IChangeModuleAction {
	
	public String getNextModule() {
		return PREVIOUS_MODULE; 
	}

	public boolean hasReinitNextModule() {
		return false; 
	}
}
