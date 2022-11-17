package nl.delphinity.qr_goats.persistence.factories;

import nl.delphinity.qr_goats.persistence.interfaces.IAccountDAO;

public abstract class DAOFactory {
	
	private static DAOFactory theFactory;
	
	public static DAOFactory getTheFactory() {
		return theFactory;
	}
	

	
	public static void setTheFactory(Class<? extends DAOFactory> factory) {
		try {
			theFactory = factory.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to create DAOFactory: " + factory);
		}
		
	
		
			
		
			
	}	public abstract IAccountDAO getAccountDAO();
	
}
