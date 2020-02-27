package org.consultorioJur.actions;

import org.openxava.actions.*;

public class SaveAgendaRequest extends SaveAction implements IChainAction, IChainActionWithArgv{

	String folderNumber;
	String visitDate;
	Integer agendaRequestId;

	@Override
	public void execute() throws Exception {
		folderNumber = getView().getValueString("folderNumber");
		visitDate = getView().getValueString("visitDate");
		agendaRequestId = getView().getValueInt("agendaRequestId");

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
			return "folderNumberFromAction=" + folderNumber + ",visitDateFromAction=" + visitDate + ",agendaRequestIdFromAction=" + agendaRequestId;
	}

}
