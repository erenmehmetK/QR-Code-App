package nl.delphinity.qr_goats.domain;

import java.util.TreeSet;

public class Student extends Persoon {

	public Student() {

	}

	public Student(Integer id, String naam, String tussenvoegsel, String achternaam) {
		super(id, naam, tussenvoegsel, achternaam);
		// TODO Auto-generated constructor stub
	}

	// returnt een nummer gebaseerd op als het object gelijk is, gebruikt voor
	// treesets sorteren
	public int compareTo(Student other) {
		return studentenNR.compareTo(other.studentenNR);

	}

	private String studentenNR;
	private QRCode qrCode;
	
	public QRCode getQrCode() {
		return qrCode;
	}

	public void setQrCode(QRCode qrCode) {
		this.qrCode = qrCode;
	}
	

	public TreeSet<Melding> meldingen;

	public void addMelding(Melding m) {
		meldingen.add(m);
		m.setStudent(this);
	}

	public void removeMelding(Melding m) {
		meldingen.remove(m);
		m.setStudent(null);
	}

	// Student meldt zichzelf laat
	public Melding laatMelden(String opmerking, String reden) {

		if (meldingen == null) {

			meldingen = new TreeSet<Melding>();

		}
		
		Melding m1 = new LaatMelding();
		m1.setDatum(java.time.LocalDateTime.now());
		((LaatMelding) m1).setOpmerking(opmerking);
		((LaatMelding) m1).setReden(reden);


		addMelding(m1);

		return m1;
	}

	// Student meldt zichzelf ziek
	public Melding ziekMelden() {
		
		if (meldingen == null) {

			meldingen = new TreeSet<Melding>();

		}

		Melding m1 = new ZiekMelding();

		m1.setDatum(java.time.LocalDateTime.now());
		addMelding(m1);

		return m1;

	}

	public TreeSet<Melding> getMeldingen() {

		return meldingen;
	}

	public void setMeldingen(TreeSet<Melding> meldingen) {
		this.meldingen = meldingen;
	}

	public String getStudentenNR() {
		return studentenNR;

	}

	public void setStudentenNR(String studentenNR) {
		this.studentenNR = studentenNR;
	}
}