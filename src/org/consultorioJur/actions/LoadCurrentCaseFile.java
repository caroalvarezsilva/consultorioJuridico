package org.consultorioJur.actions;

import java.util.*;

import javax.inject.*;

import org.consultorioJur.model.*;
import org.openxava.actions.*;
import org.openxava.jpa.*;

public class LoadCurrentCaseFile extends SearchByViewKeyAction { // Para llenar la vista a partir de la clave
	@Inject 
	private Map caseFileKey; // Para coger el valor del objeto de sesi�n
	// invoicing_currentInvoiceKey, llenado en el m�dulo Order
	public void execute() throws Exception {
	getView().setValues(caseFileKey); // Pone la clave en la vista
	
	super.execute(); // Llena toda la vista a partir de los campos clave
	}

}
