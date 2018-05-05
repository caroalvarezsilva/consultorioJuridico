package org.consultorioJur.actions;

import org.openxava.actions.*;

public class CaseFileEdition extends SaveAction // Acci�n est�ndar de OpenXava para grabar el contenido de la vista
	implements IChangeModuleAction // Para navegaci�n entre m�dulos
	
	
	{
	public String getNextModule() {
	return PREVIOUS_MODULE; // Vuelve al m�dulo que llam�, Order en este caso
	}
	public boolean hasReinitNextModule() {
	return false; // No queremos inicializar el m�dulo Order
	}
	}
