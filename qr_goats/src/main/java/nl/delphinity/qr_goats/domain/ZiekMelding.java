package nl.delphinity.qr_goats.domain;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "FK_ziekmelding_meldingID"))
public class ZiekMelding extends Melding {

	@Override
	public String toString() {

		return getId() + " " + getDatum() + " " + getStudent();
	}

	
}
