package nl.delphinity.qr_goats.persistence.dao;

import nl.delphinity.qr_goats.domain.Account;
import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.interfaces.IStudentDAO;

public class StudentDAO extends GenericHibernateDAO<Student, String> implements IStudentDAO{
	
	@Override
	public Student findByEmail(Account a) {
		getSession().beginTransaction();
		Student entity = getSession().find(getPersistentClass(), a.getEmail());
		getSession().getTransaction().commit();
		return entity;
	}

}
