package nl.delphinity.qr_goats.persistence.dao;

import nl.delphinity.qr_goats.domain.Account;
import nl.delphinity.qr_goats.persistence.interfaces.IAccountDAO;

public class AccountDAO extends GenericHibernateDAO<Account, String> implements IAccountDAO{

	@Override
	public Account findbyemail(Account a) {
		// TODO Auto-generated method stub
		return null;
	}

}
