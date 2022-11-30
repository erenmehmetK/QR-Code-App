package nl.delphinity.qr_goats.persistence.factories;

import nl.delphinity.qr_goats.persistence.interfaces.IAccountDAO;
import nl.delphinity.qr_goats.persistence.interfaces.IQRCodeDAO;
import nl.delphinity.qr_goats.persistence.test.dao.TestDAOAccount;

public class TestDAOfactory extends DAOFactory {

	@Override
	public IAccountDAO getAccountDAO() {
		return TestDAOAccount.getInstance();
	}

	@Override
	public IQRCodeDAO getQRCodeDAO() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
