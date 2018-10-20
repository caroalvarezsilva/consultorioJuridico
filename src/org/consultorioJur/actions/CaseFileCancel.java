package org.consultorioJur.actions;

import org.openxava.actions.*;

public class CaseFileCancel  extends CancelAction implements IChangeModuleAction {
	
	public String getNextModule() {
		return PREVIOUS_MODULE; 
	}

	public boolean hasReinitNextModule() {
		return false; 
	}
}