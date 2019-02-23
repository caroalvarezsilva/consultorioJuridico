//package org.consultorioJur.model;
//
//import java.util.*;
//import javax.persistence.*;
//
//import org.openxava.annotations.*;
//
//@Entity
//@View(members="Búsqueda por documento [documentId,documentType;"
//		+"name, lastName;"
//		+ "phone,mobile]"
//		)
//public class Student2 extends Person {
//	
//	@OneToMany(mappedBy = "student")
//	@ElementCollection
//	private Set<CaseFileStudent> caseFileStudents = new HashSet<CaseFileStudent>();
//
//	public Set<CaseFileStudent> getCaseFileStudents() {
//		return caseFileStudents;
//	}
//
//	public void setCaseFileStudents(Set<CaseFileStudent> caseFileStudents) {
//		this.caseFileStudents = caseFileStudents;
//	}
//	
//}
