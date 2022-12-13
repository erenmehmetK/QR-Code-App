package nl.delphinity.qr_goats.persistence.test.dao;

import java.util.ArrayList;
import java.util.Set;

import nl.delphinity.qr_goats.domain.Account;
import nl.delphinity.qr_goats.persistence.interfaces.IAccountDAO;

public class TestDAOAccount implements IAccountDAO {

	private static TestDAOAccount instance;

	private ArrayList<Account> accounts;

	private TestDAOAccount() {
		accounts = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			Account a = new Account();
			a.setEmail("nummer"+i+"@student.scalda.nl");
			a.setWachtwoord("milan"+i);
			accounts.add(a);
		}
	}

	public static TestDAOAccount getInstance() {
		if (instance == null) {
			instance = new TestDAOAccount();
		}
		return instance;
	}

	@Override
	public Account saveOrUpdate(Account entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Account entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Account findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Account> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findbyemail(Account a) {
		for(Account s : accounts) {
			if(s.getEmail().equals(a.getEmail())) {
				return s;
			}
		}
		return null;
	}

}
