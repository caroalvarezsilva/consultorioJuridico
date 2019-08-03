package org.consultorioJur.actions;

import java.util.*;
import org.openxava.actions.*;


public class CaseFileAddStudent extends SaveAction {

	@Override
	public void execute() throws Exception {
		Map values = getView().getValues();
		super.execute();
		addActions("Collections.SaveElementInCollectionAction");
	
	}
}