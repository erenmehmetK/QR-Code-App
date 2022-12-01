package nl.delphinity.qr_goats.domain;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import nl.delphinity.qr_goats.domain.PasswordHashing.CannotPerformOperationException;
import nl.delphinity.qr_goats.domain.PasswordHashing.InvalidHashException;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;

public class Account implements Comparable<Account> {

	private Integer id;
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

	public boolean loginCheck() {
		// find account by email en returnt other

		Account other = DAOFactory.getTheFactory().getAccountDAO().findbyemail(this);

		if (other == null) {
			System.out.println("geen account gevonden jammer zeg");
			return false;
		} else if (this.wachtwoord.equals(other.wachtwoord)) {
			System.out.println("wachtwoord is goed");
			return true;
		} else {
			System.out.println("wachtwoord is fout");
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	public void setWachtwoord(String	 wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

	// hasht de id zodat het object vergelijkbaar is
	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return id == other.id;
	}

	// returnt waardes van account variabelen als een string
	@Override
	public String toString() {
		return "Account [id=" + id + ", wachtwoord=" + wachtwoord + "]";
	}

	// returnt een nummer gebaseerd op als het object gelijk is, gebruikt voor
	// treesets sorteren
	@Override

	public int compareTo(Account other) {

		int temp = id.compareTo(other.id);
		if (temp == 0) {

			int temp2 = wachtwoord.compareTo(wachtwoord);
			if (temp2 == 0) {

				return temp2;
			}
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
