package nl.delphinity.qr_goats.domain;

import nl.delphinity.qr_goats.domain.PasswordHashing.CannotPerformOperationException;
import nl.delphinity.qr_goats.domain.PasswordHashing.InvalidHashException;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;

public class Account implements Comparable<Account> {


	private String wachtwoord;
	private String email;

	public Account(String wachtwoord, String email) {
		super();
		this.wachtwoord = wachtwoord;
		this.email = email;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

	//Login
	public boolean loginCheck() {
		// find account by email en returnt other
		Account other = DAOFactory.getTheFactory().getAccountDAO().findbyemail(this);
		if (other == null) {
		
			return false;
		} else
			try {
				if (PasswordHashing.verifyPassword(this.wachtwoord, other.wachtwoord)) {
					// If password is correct
					System.out.println("goed");
					return true;
				} else {

					return false;
				}
			} catch (CannotPerformOperationException | InvalidHashException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}

	public boolean changePassword(String oudWachtwoord, String nieuwWachtwoord) {
		try {
			if(PasswordHashing.verifyPassword(oudWachtwoord, wachtwoord) && !PasswordHashing.verifyPassword(nieuwWachtwoord, wachtwoord)) {
				wachtwoord = PasswordHashing.createHash(nieuwWachtwoord);
				return true;
			}
		} catch (CannotPerformOperationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvalidHashException e2) {
			e2.printStackTrace();
		}
		return false;
	}
	
	public String getWachtwoord() {
		return wachtwoord;
	}

	public void setWachtwoord(String	 wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

	// returnt waardes van account variabelen als een string
	@Override
	public String toString() {
		return "Account [wachtwoord=" + wachtwoord + "]";
	}

	// returnt een nummer gebaseerd op als het object gelijk is, gebruikt voor
	// treesets sorteren

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int compareTo(Account o) {
		
		return 0;
	}

}
