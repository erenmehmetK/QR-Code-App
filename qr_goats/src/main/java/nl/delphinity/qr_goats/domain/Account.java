package nl.delphinity.qr_goats.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import nl.delphinity.qr_goats.domain.PasswordHashing.CannotPerformOperationException;
import nl.delphinity.qr_goats.domain.PasswordHashing.InvalidHashException;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;

@Entity
@Table(name = "account", indexes = { @Index(columnList = "email") })
public class Account implements Comparable<Account> {

	@Column(name = "wachtwoord", nullable = false, length = 255)
	private String wachtwoord;
	@Id
	@Column(name = "email", nullable = false, length = 255)
	private String email;

	public Account(String wachtwoord, String email) {
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
		} else if (this.wachtwoord.equals(other.wachtwoord)) {

			return true;
		} else {

			return false;
		}
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

	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

	// hasht de id zodat het object vergelijkbaar is
	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	// returnt een boolean gebaseerd op als het object gelijk is
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return email.equals(other.email);
	}

	// returnt waardes van account variabelen als een string
	@Override
	public String toString() {
		return email + " " + wachtwoord;
	}

	// returnt een nummer gebaseerd op als het object gelijk is, gebruikt voor
	// treesets sorteren
	@Override

	public int compareTo(Account other) {
		int temp = email.compareTo(other.email);
		if (temp == 0) {
			int temp2 = wachtwoord.compareTo(other.wachtwoord);
			return temp2;
		}
		return temp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
