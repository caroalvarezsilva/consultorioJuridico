package org.consultorioJur.actions;

import org.openxava.actions.*;

public class SaveAgendaRequest extends SaveAction implements IChainAction, IChainActionWithArgv{
	
	String folderNumber;
	
	@Override
	public void execute() throws Exception {
		folderNumber= getView().getValueString("folderNumber");
		super.execute();		
	}

	@Override
	public String getNextAction() throws Exception {
		// TODO Auto-generated method stub
		return "AgendaRequest.printPdf";
	}

	@Override
	public String getNextActionArgv() throws Exception {
		// TODO Auto-generated method stub
			return "folderNumberFromAction=" + folderNumber;
	}

}
