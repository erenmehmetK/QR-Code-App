package nl.delphinity.qr_goats.persistence.test.dao;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

import nl.delphinity.qr_goats.domain.Opleiding;
import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.interfaces.IOpleidingDAO;

public class TestOpleidingDAO extends GenericTestDAO<Opleiding, Integer> implements IOpleidingDAO {

	private static TestOpleidingDAO instance;

	public static TestOpleidingDAO getInstance() {
		if (instance == null) {
			instance = new TestOpleidingDAO();
		}
		return instance;
	}

	private TestOpleidingDAO() {


	}



	@Override
	public Opleiding saveOrUpdate(Opleiding entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Opleiding entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Opleiding findById(Integer id) {
		return null;
	}

	@Override
	public Set findAll() {
		return null;
	}

}
