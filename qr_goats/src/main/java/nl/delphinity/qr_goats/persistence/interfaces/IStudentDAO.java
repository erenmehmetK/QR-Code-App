package nl.delphinity.qr_goats.persistence.interfaces;

import nl.delphinity.qr_goats.domain.Account;
import nl.delphinity.qr_goats.domain.Student;

public interface IStudentDAO extends IGenericDAO<Student, String> {

	public abstract Student findByEmail(Account a);
}
