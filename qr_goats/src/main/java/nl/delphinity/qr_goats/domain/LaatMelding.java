package nl.delphinity.qr_goats.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class LaatMelding extends Melding {
	
	@Column(name = "Opmerking", nullable = true)
	private String opmerking;
	private String reden;

	public String getOpmerking() {
		return opmerking;
	}

	public void setOpmerking(String opmerking) {
		this.opmerking = opmerking;
	}

	public String getReden() {
		return reden;
	}

	public void setReden(String reden) {
		this.reden = reden;
	}

	@Override
	public String toString() {
		return getId() + " " + getDatum() + " " + getStudent() + " " + opmerking + " " + reden;
	}
	
	
	
	

}
