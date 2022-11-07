package nl.delphinity.qr_goats.domain;

import java.util.Objects;

public class Persoon implements Comparable<Persoon> {
	private Integer id;
	private String naam;
	private String email;  
	private String tussenvoegsel;
	private String achternaam;
	
	
	
	public Persoon(Integer id, String naam, String email, String tussenvoegsel, String achternaam) {
		this.id = id;
		this.naam = naam;
		this.email = email;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
	}
	// Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTussenvoegsel() {
		return tussenvoegsel;
	}
	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}
	public String getAchternaam() {
		return achternaam;
	}
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}
	
	
	
	
	//hashed de id zodat het object vergelijkbaar is
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	//returned een boolean gebaseerd op als het object gelijk is 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persoon other = (Persoon) obj;
		return Objects.equals(id, other.id);
	}
	
	// returned waardes van persoon variabelen als een string
	@Override
	public String toString() {
		return "Persoon [id=" + id + ", naam=" + naam + ", email=" + email + ", tussenvoegsel=" + tussenvoegsel
				+ ", achternaam=" + achternaam + "]";
	} 
	
	
	public int compareTo(Persoon other) {
		
		int temp = naam.compareTo(other.naam);
		if(temp == 0) {
			int temp2 = achternaam.compareTo(other.achternaam);
			if(temp2 == 0) {
					int temp3 = tussenvoegsel.compareTo(other.tussenvoegsel);
					return temp3;
			}
			return temp2;
		}	
		return temp;		 
	}
}