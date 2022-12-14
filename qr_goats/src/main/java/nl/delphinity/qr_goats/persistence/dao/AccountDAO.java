package nl.delphinity.qr_goats.persistence.dao;

import nl.delphinity.qr_goats.domain.Account;
import nl.delphinity.qr_goats.persistence.interfaces.IAccountDAO;

public class AccountDAO extends GenericHibernateDAO<Account, String> implements IAccountDAO{

	@Override
	public Account findbyemail(Account a) {
		Account entity = getSession().find(getPersistentClass(), a.getEmail());
		return entity;
	}

}
