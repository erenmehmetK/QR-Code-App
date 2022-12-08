package nl.delphinity.qr_goats.domain;

public class ZiekMelding extends Melding {

	@Override
	public String toString() {

		return "ZiekMelding [id=" + getId() + ", datum=" + getDatum()
				+ ", student=" + getStudent() + "]";
	}

	
}
