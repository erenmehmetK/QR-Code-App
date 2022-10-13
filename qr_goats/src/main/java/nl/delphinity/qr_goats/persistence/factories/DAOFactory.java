package nl.delphinity.qr_goats.persistence.factories;

import nl.delphinity.qr_goats.persistence.interfaces.IPersoonDAO;

/**
 * @author huelbr (Bram van Huele)
 * @since 12 nov. 2018
 */
public abstract class DAOFactory {
	
	private static DAOFactory theFactory;

	/**
	 * @return the theFactory
	 */
	public static DAOFactory getTheFactory() {
		return theFactory;
	}
	

	/**
	 * @param factory the theFactory to set
	 */
	public static void setTheFactory(Class<? extends DAOFactory> factory) {
		try {
			theFactory = factory.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to create DAOFactory: " + factory);
		}
	}

	public abstract IPersoonDAO getPersoonDAO();

}
