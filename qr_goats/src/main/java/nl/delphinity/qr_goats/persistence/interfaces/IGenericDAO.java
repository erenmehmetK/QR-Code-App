package nl.delphinity.qr_goats.persistence.interfaces;

import java.io.Serializable;
import java.util.Set;

/**
 * @author huelbr (Bram van Huele)
 * @since 12 nov. 2018
 */
public interface IGenericDAO<T, ID extends Serializable> {
	
	public T saveOrUpdate(T entity);
	
	public void delete(T entity);
	
	public T findById(ID id);
	
	public Set<T> findAll();
	
}
