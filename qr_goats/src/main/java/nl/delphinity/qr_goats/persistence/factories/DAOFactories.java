package nl.delphinity.qr_goats.persistence.factories;

public enum DAOFactories {

	HIBERNATE(HibernateDAOfactory.class), TESTDATA(TestDAOfactory.class);
	

	
	private final Class<? extends DAOFactory> theFactory;
	
	private DAOFactories(Class<? extends DAOFactory> factory) {
		this.theFactory = factory;
	}

	public Class<? extends DAOFactory> getTheFactory() {
		return theFactory;
	}
	
	
	
}
