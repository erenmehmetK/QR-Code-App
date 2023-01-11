package nl.delphinity.qr_goats.persistence.dao;

import nl.delphinity.qr_goats.domain.Melding;
import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.interfaces.IMeldingDAO;


public class MeldingDAO extends GenericHibernateDAO<Melding, Integer> implements IMeldingDAO{

	  
		@Override
		public Melding findByStudent(Student s) {
			Melding entity = getSession().find(getPersistentClass(), s.getId());
			return entity;
		}
	
	
}
