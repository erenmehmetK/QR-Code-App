package nl.delphinity.qr_goats.persistence.factories;

import nl.delphinity.qr_goats.persistence.interfaces.IAccountDAO;
import nl.delphinity.qr_goats.persistence.test.dao.TestDAOAccount;

public class TestDAOfactory extends DAOFactory {

	@Override
	public IAccountDAO getAccountDAO() {
		return TestDAOAccount.getInstance();
	}
	

}
