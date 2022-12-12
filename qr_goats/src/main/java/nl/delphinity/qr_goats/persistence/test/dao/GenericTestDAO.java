package nl.delphinity.qr_goats.persistence.test.dao;

import java.io.Serializable;
import java.util.Set;

import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.interfaces.IGenericDAO;

public abstract class GenericTestDAO<T, ID extends Serializable> implements IGenericDAO<T, ID> {

	@Override
	public Object saveOrUpdate(Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Object entity) {
	}

	@Override
	public Object findById(Serializable id) {
		return null;
	}

	@Override
	public abstract Set findAll();
	

}
