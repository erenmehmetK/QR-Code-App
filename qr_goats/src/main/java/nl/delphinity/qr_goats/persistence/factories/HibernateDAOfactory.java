package nl.delphinity.qr_goats.persistence.factories;

import org.hibernate.Session;

import nl.delphinity.qr_goats.domain.*;
import nl.delphinity.qr_goats.persistence.dao.*;
import nl.delphinity.qr_goats.persistence.interfaces.*;
import nl.delphinity.qr_goats.persistence.utils.HibernateSessionManager;


public class HibernateDAOfactory extends DAOFactory {

	protected Session getCurrentSession() {
		return HibernateSessionManager.getSessionFactory().openSession();
	}

	@Override
	public IAccountDAO getAccountDAO() {
		GenericHibernateDAO<Account, String> dao = null;
		try {
			dao = AccountDAO.class.newInstance();
			dao.setSession(getCurrentSession());
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return (IAccountDAO) dao;
	}


	
	
}
