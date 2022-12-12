package nl.delphinity.qr_goats.persistence.factories;

import nl.delphinity.qr_goats.persistence.interfaces.IAccountDAO;
import nl.delphinity.qr_goats.persistence.interfaces.IOpleidingDAO;
import nl.delphinity.qr_goats.persistence.interfaces.IQRCodeDAO;
import nl.delphinity.qr_goats.persistence.interfaces.IStudentDAO;
import nl.delphinity.qr_goats.persistence.test.dao.TestDAOAccount;
import nl.delphinity.qr_goats.persistence.test.dao.TestOpleidingDAO;
import nl.delphinity.qr_goats.persistence.test.dao.TestStudentDAO;

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

	@Override
	public IStudentDAO getStudentDAO() {
		// TODO Auto-generated method stub
		return TestStudentDAO.getInstance();
	}

	@Override
	public IOpleidingDAO getOpleidingDAO() {
		// TODO Auto-generated method stub
		return TestOpleidingDAO.getInstance();
	}
	

}
