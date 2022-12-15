package nl.delphinity.qr_goats.domain;

public class ZiekMelding extends Melding {

	@Override
	public String toString() {

		return getId() + " " + getDatum() + " " + getStudent();
	}

	
}
