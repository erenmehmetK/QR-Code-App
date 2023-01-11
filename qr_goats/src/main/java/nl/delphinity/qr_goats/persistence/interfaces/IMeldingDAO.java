package nl.delphinity.qr_goats.persistence.interfaces;

import nl.delphinity.qr_goats.domain.Melding;
import nl.delphinity.qr_goats.domain.Student;

public interface IMeldingDAO extends IGenericDAO<Melding, Integer>{
	
	public abstract Melding findByStudent(Student s);

}
