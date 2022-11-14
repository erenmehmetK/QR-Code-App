package nl.delphinity.qr_goats.domain;

import java.util.Objects;

public class Account implements Comparable<Account> {

	private Integer id;
	private String wachtwoord;
	private String email; 		 
	
	public static boolean loginCheck(Account other, Account a) {
		// find account by email en returnt other

		if(other == null) {
			System.out.println("geen account gevonden jammer zeg");
			return false;
		} else if(a.wachtwoord.equals(other.wachtwoord) == true) {
			System.out.println("is goed");
			return true;
		}else {
			System.out.println("is fout");
			return false;
		}
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
		
		int temp = id.compareTo(other.id);
		if(temp == 0) {
			
			int temp2 = wachtwoord.compareTo(wachtwoord);
				if(temp2 == 0) {
					
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
