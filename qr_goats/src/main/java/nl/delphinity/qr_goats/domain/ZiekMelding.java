package nl.delphinity.qr_goats.domain;

import javax.persistence.Entity;

@Entity
public class ZiekMelding extends Melding {

	@Override
	public String toString() {

		return getId() + " " + getDatum() + " " + getStudent();
	}

	
}
