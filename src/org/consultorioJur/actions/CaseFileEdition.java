package org.consultorioJur.actions;

import org.openxava.actions.*;

public class CaseFileEdition extends SaveAction // Acción estándar de OpenXava para grabar el contenido de la vista
	implements IChangeModuleAction // Para navegación entre módulos
	
	
	
	{
	public String getNextModule() {
	return PREVIOUS_MODULE; // Vuelve al módulo que llamó, Order en este caso
	}
	public boolean hasReinitNextModule() {
	return false; // No queremos inicializar el módulo Order
	}
	}
