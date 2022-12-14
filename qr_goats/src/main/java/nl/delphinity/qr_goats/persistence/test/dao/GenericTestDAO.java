package nl.delphinity.qr_goats.persistence.test.dao;

import java.io.Serializable;
import java.util.Set;


import nl.delphinity.qr_goats.persistence.interfaces.IGenericDAO;

public abstract class GenericTestDAO<T, ID extends Serializable> implements IGenericDAO<T, ID> {

	@Override
	public T saveOrUpdate(T entity) {
		return null;
	}

	@Override
	public void delete(T entity) {
	}

	@Override
	public T findById(ID id) {
		return null;
	}

	@Override
	public abstract Set<T> findAll();
	

}
