package nl.delphinity.qr_goats.domain;

import nl.delphinity.qr_goats.persistence.factories.DAOFactory;


public class OpleidingFacade {

	private static OpleidingFacade instance;
	private Opleiding opleiding;

	
	private OpleidingFacade() {
//		DAOFactory.setTheFactory(DAOFactories.HIBERNATE.getTheFactory());
		opleiding = DAOFactory.getTheFactory().getOpleidingDAO().findById(1);
		
	}
	
	public static OpleidingFacade getInstance() {
		
//		Session session = HibernateSessionManager.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
		if(instance == null) {
			instance = new OpleidingFacade();
		}
		return instance;
	
	}
	
	public Opleiding getOpleiding() {
		return opleiding;
	}
	
	
	
	
}
