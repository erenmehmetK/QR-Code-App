package nl.delphinity.qr_goats.persistence.test.dao;

import java.util.Set;
import java.util.TreeSet;

import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.interfaces.IOpleidingDAO;

public class TestOpleidingDAO implements IOpleidingDAO {
	TreeSet<Student> studenten = new TreeSet<>();
	private static TestOpleidingDAO instance;

	public static TestOpleidingDAO getInstance() {

		if (instance == null) {
			instance = new TestOpleidingDAO();
		}
		return instance;
	}

	public TreeSet<Student> generateStudents() {

		for (int i = 1; i < 101; i++) {

			Student stud = new Student();
			stud.setNaam("Eren" + i);
			stud.setAchternaam("test" + i);
			stud.setTussenvoegsel("test" + i);
			stud.setId(i);
			studenten.add(stud);
			return studenten;

		}
		return studenten;

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
