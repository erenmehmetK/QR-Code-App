package nl.delphinity.qr_goats.persistence.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;

import nl.delphinity.qr_goats.domain.Account;
import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.interfaces.IStudentDAO;

public class StudentDAO extends GenericHibernateDAO<Student, Integer> implements IStudentDAO {

	@Override
	public Student findByEmail(Account a) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Student> criteriaQ = builder.createQuery(getPersistentClass());
		Root<Student> root = criteriaQ.from(getPersistentClass());
		criteriaQ.select(root).where(builder.equal(root.get("account"), a.getEmail()));
		Query<Student> q = getSession().createQuery(criteriaQ);

		Student s = q.uniqueResult();
		return s;
	}

}
