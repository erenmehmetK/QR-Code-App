package nl.delphinity.qr_goats.domain;

import java.util.Objects;

public class Account implements Comparable<Account> {

	private Integer id;
	private String wachtwoord;
	private Persoon persoon;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

	//hasht de id zodat het object vergelijkbaar is
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	//returnt een boolean gebaseerd op als het object gelijk is 
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

	// returnt een nummer gebaseerd op als het object gelijk is, gebruikt voor treesets sorteren
	@Override
	public int compareTo(Account other) {
		return id.compareTo(other.id);
	}
}
