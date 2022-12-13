package nl.delphinity.qr_goats.domain;

public class LaatMelding extends Melding {
	
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
