package nl.delphinity.qr_goats.domain;

import nl.delphinity.qr_goats.persistence.factories.DAOFactories;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;

public class OpleidingFacade {

	private static OpleidingFacade instance;
	private Opleiding opleiding;
	
	private OpleidingFacade() {
		DAOFactory.setTheFactory(DAOFactories.HIBERNATE.getTheFactory());
		opleiding = new Opleiding();
	}
	
	public static OpleidingFacade getInstance() {
		if(instance == null) {
			instance = new OpleidingFacade();
		}
		return instance;
	
	}
	
	public Opleiding getOpleiding() {
		return opleiding;
	}
	
	
	
	
}
