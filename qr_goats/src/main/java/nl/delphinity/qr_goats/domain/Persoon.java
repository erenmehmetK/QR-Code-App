package nl.delphinity.qr_goats.domain;

import java.util.Objects;

public class Persoon implements Comparable<Persoon> {

	private Integer id;

	private String naam;
	private String email;  
	private String tussenvoegsel;
	private String achternaam;
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
	
	// pas aan, niet genereren!
	
	@Override
	public int hashCode() {
		return Objects.hash(achternaam, email, id, naam, tussenvoegsel);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persoon other = (Persoon) obj;
		return Objects.equals(achternaam, other.achternaam) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(naam, other.naam)
				&& Objects.equals(tussenvoegsel, other.tussenvoegsel);
	}
	@Override
	public String toString() {
		return "Persoon [id=" + id + ", naam=" + naam + ", email=" + email + ", tussenvoegsel=" + tussenvoegsel
				+ ", achternaam=" + achternaam + "]";
	} 
	
	@Override
	public int compareTo(Persoon other) {
		
		return id.compareTo(other.id);
	}
	
	
	

}
