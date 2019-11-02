package org.consultorioJur.actions;

import java.util.*;

import javax.inject.*;

import org.openxava.actions.*;
import org.openxava.util.*;
import org.openxava.view.*;

public class NewNotes extends CreateNewElementInCollectionAction {
		
	@Override
	public void execute() throws Exception {
		super.execute();
		Map values = getView().getSubview("notes").getSubview("note").getValues();
		String user =  Users.getCurrent();
		values.put("user",user);
		getView().getSubview("notes").getSubview("note").addValues(values);
	}

}
