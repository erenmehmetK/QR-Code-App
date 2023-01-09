package nl.delphinity.qr_goats.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "FK_laatmelding_meldingID"))
public class LaatMelding extends Melding {
	
	@Column(name = "opmerking", nullable = true, length = 255)
	private String opmerking;
	
	@Column(name = "reden", nullable = false, length = 15)
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
