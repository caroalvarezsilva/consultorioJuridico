package org.consultorioJur.actions;

import java.util.*;
import org.openxava.actions.*;


public class CaseFileAddStudent extends SaveAction {

	@Override
	public void execute() throws Exception {
		Map values = getView().getValues();
		super.execute();	
//		getMessages().remove("entity_created");
//		closeDialog();
//		setView(getView().getParent());
//		getView().setModelName("AgendaRequest");
		
		addActions("Collections.SaveElementInCollectionAction");
		//getView().setValue("person", values);
	
	}
}