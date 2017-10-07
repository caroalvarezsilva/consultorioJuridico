package org.consultorioJur.actions;

import org.openxava.actions.*;

public class OnChangePersonDocumentAction extends OnChangePropertyBaseAction {

	@Override
	public void execute() throws Exception {
		 String value = (String) getNewValue(); // 2
		 if (value == null) return;
		 if (value.startsWith("4564")) {
			 //getView().setcre
			 
		 }
	 }
}
