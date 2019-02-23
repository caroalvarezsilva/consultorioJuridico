package org.consultorioJur.actions;


import javax.persistence.*;

import org.consultorioJur.model.*;
import org.openxava.actions.*;
import org.openxava.jpa.*;

public class OnChangeLookInFderDB extends OnChangePropertyBaseAction {

//	@Override
//	public void execute() throws Exception {
//		// TODO Auto-generated method stub
//		 int id = getView().getValueInt("id");
//
//	        // Buscas la entidad en la BD2
//	        XPersistence.setPersistenceUnit("fder");
//	        Query query = XPersistence.getManager().createQuery("from Student s where s.id=:id");
//	        query.setParameter("id", id);
//	        Student entidad = (Student) query.getSingleResult();
//
//	        // LLenas la vista con los valores obtenidos
//	        getView().setValue("nombre", entidad.getNombre());
//	        //...
//	        /*CaseFile caseFile = XPersistence.getManager().find(CaseFile.class, getView().getParent().getValueInt("caseFileId"));
//	        caseFile.setStudent(new Student(entidad.getId()));*/
//
//	        // Al terminar cambias la unidad de persistencia
//	        XPersistence.commit();
//	        XPersistence.setPersistenceUnit("default");
//	}
//	@Override
//	public void execute() throws Exception {
//		super.execute();
//		if (!getErrors().isEmpty()) {
//			getErrors().removeAll();
//			//showDialog();
//			//getView().setModelName("Student");
//			//addActions("AgendaRequestModalPerson.cancel", "AgendaRequestModalPerson.add");
//
//		}
//
//	}
	@Override
	public void execute() {    
        //String identificador = getView().getValueString("id");
        int identificador = getView().getValueInt("id");

        // Buscas la entidad en la BD2
        XPersistence.setPersistenceUnit("fder");
        Query query = XPersistence.getManager().createQuery("from Student e where e.id=:identificador");
        query.setParameter("identificador", identificador);
        Student entidad = (Student) query.getSingleResult();

        // LLenas la vista con los valores obtenidos
        getView().setValue("nombre", entidad.getNombre());
        //...

        // Al terminar cambias la unidad de persistencia
        XPersistence.commit();
        XPersistence.setPersistenceUnit("default");
    }

}
