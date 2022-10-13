package nl.delphinity.qr_goats.persistence.factories;

import org.hibernate.Session;

import nl.delphinity.qr_goats.domain.Persoon;
import nl.delphinity.qr_goats.persistence.dao.GenericHibernateDAO;
import nl.delphinity.qr_goats.persistence.dao.PersoonDAO;
import nl.delphinity.qr_goats.persistence.interfaces.IPersoonDAO;
import nl.delphinity.qr_goats.persistence.utils.HibernateSessionManager;

/**
 * @author huelbr (Bram van Huele)
 * @since 12 nov. 2018
 */
public class HibernateDAOfactory extends DAOFactory {

	protected Session getCurrentSession() {
		return HibernateSessionManager.getSessionFactory().openSession();
	}
	
	@Override
	public IPersoonDAO getPersoonDAO() {
		GenericHibernateDAO<Persoon, String> dao = null;
		try {
			dao = PersoonDAO.class.newInstance();
			dao.setSession(getCurrentSession());
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return (IPersoonDAO) dao;
	}



	
	
}
