package nl.delphinity.qr_goats.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Persoon", uniqueConstraints = {@UniqueConstraint(columnNames = "id")}, indexes = {@Index (columnList = "id")})
public class Persoon implements Comparable<Persoon> {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name = "naam", nullable = false, length = 60)
	private String naam;
	@Column(name = "tussenvoegsel", nullable = true, length = 20)
	private String tussenvoegsel;
	@Column(name = "achternaam", nullable = false, length = 60)
	private String achternaam;

	public Persoon() {

	}

	public Persoon(Integer id, String naam, String tussenvoegsel, String achternaam) {
		this.id = id;
		this.naam = naam;
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

	// hashed de id zodat het object vergelijkbaar is
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	// returned een boolean gebaseerd op als het object gelijk is
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
		return "Persoon [id=" + id + ", naam=" + naam + ", tussenvoegsel=" + tussenvoegsel + ", achternaam="
				+ achternaam + "]";
	}

	public int compareTo(Persoon other) {

		int temp = naam.compareTo(other.naam);
		if (temp == 0) {
			int temp2 = achternaam.compareTo(other.achternaam);
			if (temp2 == 0) {
				int temp3 = tussenvoegsel.compareTo(other.tussenvoegsel);
				return temp3;
			}
			return temp2;
		}
		return temp;
	}
}