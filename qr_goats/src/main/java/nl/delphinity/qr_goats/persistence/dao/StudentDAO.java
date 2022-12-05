package nl.delphinity.qr_goats.persistence.dao;

import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.interfaces.IStudentDAO;

public class StudentDAO extends GenericHibernateDAO<Student, String> implements IStudentDAO{

}
