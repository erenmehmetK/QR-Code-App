package nl.delphinity.qr_goats.domain;

import java.util.Objects;

public class Account implements Comparable<Account> {

	private Integer id;
	private String wachtwoord;
	
	
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

	@Override
	public int hashCode() {
		return Objects.hash(id, wachtwoord);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return id == other.id && Objects.equals(wachtwoord, other.wachtwoord);
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", wachtwoord=" + wachtwoord + "]";
	}

	@Override
	public int compareTo(Account other) {
		return id.compareTo(other.id);

	}
}
