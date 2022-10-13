package nl.delphinity.qr_goats.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="persoon")
public class Persoon implements Comparable<Persoon> {
	
	// Variabelen
	
	// unieke identifier voor persoon
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "voornaam", length = 150, nullable =  false)
	private String naam;
	@Column(name = "email", unique = true, nullable = false, length = 100)
	private String email;  
	@Column(name = "tussenvoegsel", length = 150, nullable =  true)
	private String tussenvoegsel;
	@Column(name = "achternaam", length = 150, nullable =  false)
	private String achternaam;
	
	
	public Persoon() {
		
	}
	
	public Persoon(Integer id, String naam, String email, String tussenvoegsel, String achternaam) {
		super();
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
		return email.compareTo(other.email);
	}

	public static void main(String[] args) {
		
	}
}
