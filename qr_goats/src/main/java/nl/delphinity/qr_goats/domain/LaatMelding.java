package nl.delphinity.qr_goats.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class LaatMelding extends Melding {
	
	@Column(name = "Opmerking", nullable = true)
	private String opmerking;

	public String getOpmerking() {
		return opmerking;
	}

	public void setOpmerking(String opmerking) {
		this.opmerking = opmerking;
	}
	
	

}
