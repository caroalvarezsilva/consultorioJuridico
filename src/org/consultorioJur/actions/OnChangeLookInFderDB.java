package org.consultorioJur.actions;


import javax.persistence.*;

import org.consultorioJur.model.*;
import org.openxava.actions.*;
import org.openxava.jpa.*;

public class OnChangeLookInFderDB extends OnChangePropertyBaseAction {

	@Override
	public void execute() {    
        int identificador = getView().getValueInt("id");
        if (identificador > 0) {
        	// Buscamos la entidad en la BD2
            XPersistence.setPersistenceUnit("fder");
            Query query = XPersistence.getManager().createQuery("from Student e where e.id=:identificador");
            query.setParameter("identificador", identificador);
            Student entidad = (Student) query.getSingleResult();

            // LLenamos la vista con los valores obtenidos
            getView().setValue("nombre", entidad.getNombre());
           
            XPersistence.commit();
            XPersistence.setPersistenceUnit("default");
        } 
        
    }

}
