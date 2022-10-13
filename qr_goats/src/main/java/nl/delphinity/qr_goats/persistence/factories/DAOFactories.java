package nl.delphinity.qr_goats.persistence.factories;

/**
 * @author huelbr (Bram van Huele)
 * @since 12 nov. 2018
 */
public enum DAOFactories {

	HIBERNATE(HibernateDAOfactory.class);
	
	private final Class<? extends DAOFactory> theFactory;
	
	private DAOFactories(Class<? extends DAOFactory> factory) {
		this.theFactory = factory;
	}

	/**
	 * @return the theFactory
	 */
	public Class<? extends DAOFactory> getTheFactory() {
		return theFactory;
	}
	
	
	
}
