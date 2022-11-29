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
	
	
	
	private Account a4;
	
	@Before
	public void setUp() throws Exception {
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
		
		
		a4 = new Account();
        a4.setWachtwoord(a4.hashPassword("P1zzaMetAnnanas")); 
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

	@Test
    public void hashPassword() {
        String string1 = "Brood";
        String string2 = "Kaas";
        string1 = a4.hashPassword(string1);
        string2 = a4.hashPassword(string2);
        
        assertEquals(string1, string1);
        assertNotEquals(string1, string2);
    }
    
    @Test
    public void changePassword() {
        String oudWachtwoord = "P1zzaMetAnnanas"; // Je WW dat je opnieuw moest typen voor je het kunt veranderen
        String nieuwWachtwoord = "N3wWachtWo0rd";
        String foutOudWachtwoord = "D1tIsFout";
        
        assertTrue(a4.changePassword(oudWachtwoord, nieuwWachtwoord)); // Is goed
        assertFalse(a4.changePassword(oudWachtwoord, oudWachtwoord)); // Is gelijk, dus fout
        assertFalse(a4.changePassword(foutOudWachtwoord, nieuwWachtwoord)); // Is fout, want vult fout oud wachtwoord in
    }
}
