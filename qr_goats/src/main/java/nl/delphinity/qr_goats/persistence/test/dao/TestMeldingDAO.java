package nl.delphinity.qr_goats.persistence.test.dao;


import java.util.Set;
import nl.delphinity.qr_goats.domain.Melding;
import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.interfaces.IMeldingDAO;


public class TestMeldingDAO extends GenericTestDAO<Melding, Integer> implements IMeldingDAO{
	
	private static TestMeldingDAO instance;
	

	public static TestMeldingDAO getInstance() {
		if (instance == null) {
			instance = new TestMeldingDAO();
		}
		return instance;
	} 

	

	@Override
	public Melding findByStudent(Student s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Melding> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
