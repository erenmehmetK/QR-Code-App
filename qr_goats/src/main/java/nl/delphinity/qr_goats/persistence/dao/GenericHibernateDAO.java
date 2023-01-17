package nl.delphinity.qr_goats.persistence.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

import nl.delphinity.qr_goats.persistence.interfaces.IGenericDAO;

public abstract class GenericHibernateDAO<T, ID extends Serializable> implements IGenericDAO<T, ID> {

	private Class<T> persistentClass;
	private Session session;

	@SuppressWarnings("unchecked")
	public GenericHibernateDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void setSession(Session s) {
		this.session = s;
	}

	protected Session getSession() {
		if (session == null) {
			throw new IllegalStateException("Session has not been set on DAO before usage");
		}
		return session;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	@Override
	public T saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
		return entity;
	}

	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}

	@Override
	public T findById(ID id) {;
		T entity = getSession().find(getPersistentClass(), id);
		return entity;

	}

	@Override
	public Set<T> findAll() {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(getPersistentClass());
		Root<T> root = criteria.from(getPersistentClass());
		criteria.select(root);
		
		List<T> list = getSession().createQuery(criteria).getResultList();
		Set<T> set = new TreeSet<>();
		set.addAll(list);

		return set;
	}

	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

}
