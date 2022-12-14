package nl.delphinity.qr_goats.persistence.test.dao;

import java.util.Set;
import java.util.TreeSet;

import nl.delphinity.qr_goats.domain.Account;
import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.interfaces.IStudentDAO;
import nl.delphinity.qr_goats.persistence.interfaces.ITestStudentDAO;

public class TestStudentDAO implements IStudentDAO {

	TreeSet<Student> studenten = new TreeSet<>();
	private static TestStudentDAO instance;

	public TestStudentDAO() {

		for (int i = 1; i < 101; i++) {

			Student stud = new Student();
			stud.setNaam("Eren" + i);
			stud.setAchternaam("test" + i);
			stud.setTussenvoegsel("test" + i);
			stud.setId(i);
			studenten.add(stud);

		}

	}

	public Student findById(int id) {
		for (Student s : studenten) {
			if (s.getId() == id) {

				return s;
			}
		}

		return null;
	}

	public static TestStudentDAO getInstance() {

		if (instance == null) {
			instance = new TestStudentDAO();
		}
		return instance;
	}

	@Override
	public Student findByEmail(Account a) {
		if (instance == null) {
			instance = new TestStudentDAO();
		}
		for (Student s : studenten) {
			if (s.getAccount() == a) {
				
				return s;
			}
		}
		return null;
	}

	@Override
	public Student saveOrUpdate(Student entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Student entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Student findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Student> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
