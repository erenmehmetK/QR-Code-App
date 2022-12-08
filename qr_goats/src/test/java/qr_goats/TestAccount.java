package qr_goats;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import nl.delphinity.qr_goats.domain.Account;
import nl.delphinity.qr_goats.persistence.factories.DAOFactories;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;
import nl.delphinity.qr_goats.persistence.test.dao.TestDAOAccount;

public class TestAccount {
	
	private Account a;
	private Account a2;
	private Account a3;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("test setup");
		DAOFactory.setTheFactory(DAOFactories.TESTDATA.getTheFactory());
		a = new Account();
		a.setEmail("nummer1@student.scalda.nl");
		a.setWachtwoord("milan1");
		
		a2 = new Account();
		a2.setEmail("nummer1@student.scalda.nl");
		a2.setWachtwoord("kaaskat");
		
		a3 = new Account();
		a3.setEmail(null);
		a3.setWachtwoord(null);
		
	}

	@After
	public void tearDown() throws Exception {
	}
	

	@Test
	public void testLoginCheck() {
		assertTrue(a.loginCheck());
		assertFalse(a2.loginCheck());
		assertFalse(a3.loginCheck());
	}

}
