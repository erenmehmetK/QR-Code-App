package nl.delphinity.qr_goats.persistence.factories;

import org.hibernate.Session;

import nl.delphinity.qr_goats.domain.*;
import nl.delphinity.qr_goats.persistence.dao.*;
import nl.delphinity.qr_goats.persistence.interfaces.*;
import nl.delphinity.qr_goats.persistence.utils.HibernateSessionManager;


public class HibernateDAOfactory extends DAOFactory {

	protected Session getCurrentSession() {
		return HibernateSessionManager.getSessionFactory().getCurrentSession();
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

	@Override
	public IAccountDAO getAccountDAO() {
		GenericHibernateDAO<Account, String> dao = null;
		try {
			dao = AccountDAO.class.newInstance();
			dao.setSession(getCurrentSession());
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return (IAccountDAO) dao;
	}

	@Override
	public IStudentDAO getStudentDAO() {
		GenericHibernateDAO<Student, String> dao = null;
		try {
			dao = StudentDAO.class.newInstance();
			dao.setSession(getCurrentSession());
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return (IStudentDAO) dao;
	}
// toegevoegd ivm "add unimplemented methods"
	@Override
	public IQRCodeDAO getQRCodeDAO() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
    public IOpleidingDAO getOpleidingDAO() {
		GenericHibernateDAO<Opleiding, Integer> dao = null;
		try {
			dao = OpleidingDAO.class.newInstance();
			dao.setSession(getCurrentSession());
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return (IOpleidingDAO) dao;
    }

	@Override
	public IMeldingDAO getMeldingDAO() {
		GenericHibernateDAO<Melding, Integer> dao = null;
		try {
			dao = MeldingDAO.class.newInstance();
			dao.setSession(getCurrentSession());
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return (IMeldingDAO) dao;
	}

	@Override
	public ILaatMeldingDAO getLaatMeldingDAO() {
		GenericHibernateDAO<LaatMelding, Integer> dao = null;
		try {
			dao = LaatMeldingDAO.class.newInstance();
			dao.setSession(getCurrentSession());
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return (ILaatMeldingDAO) dao;
	}

	@Override
	public IZiekMeldingDAO getZiekMeldingDAO() {
		GenericHibernateDAO<ZiekMelding, Integer> dao = null;
		try {
			dao = ZiekMeldingDAO.class.newInstance();
			dao.setSession(getCurrentSession());
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return (IZiekMeldingDAO) dao;
	}

}
