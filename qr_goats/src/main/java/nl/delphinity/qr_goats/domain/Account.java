package nl.delphinity.qr_goats.domain;

import java.util.Objects;

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
		System.out.println("test");
		
		if (other == null) {
			System.out.println("no password found");
			return false;
		} else if (this.wachtwoord.equals(other.wachtwoord)) {
			System.out.println("logged in");
			return true;
		} else {
			System.out.println("password wrong");
			return false;
		}
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

}
