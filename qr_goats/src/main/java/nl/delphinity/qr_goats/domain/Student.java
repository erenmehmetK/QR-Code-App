package nl.delphinity.qr_goats.domain;

import java.util.SortedSet;
import java.util.TreeSet;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import nl.delphinity.qr_goats.persistence.factories.DAOFactory;

@Entity
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "FK_student_personID"))
@Table(name = "student")
public class Student extends Persoon {
	// dit is primary key, hierbij kan geen @Id ivm dit is een subclass	
	@Column(name = "studentenNR", nullable = false, length = 6, unique = true)
	private String studentenNR;
	
	@OneToOne
	@JoinColumn(name = "account_email")
	private Account account;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
	@Cascade(CascadeType.SAVE_UPDATE)
	private SortedSet<Melding> meldingen;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "opleidingID", nullable = false)
	private Opleiding opleiding;

	@Transient
	private QRCode qrCode;
	@Transient
	private boolean isIngecheckt;
	
	

	public Student() {

	}

	public Student(Integer id, String naam, String tussenvoegsel, String achternaam) {
		super(id, naam, tussenvoegsel, achternaam);
	}

	// returnt een nummer gebaseerd op als het object gelijk is, gebruikt voor
	// treesets sorteren
	public int compareTo(Student other) {
		return studentenNR.compareTo(other.studentenNR);

	}

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
        m1.save();

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
		m1.save();
		
		return m1;

	}
	
	
	public void save() {
	DAOFactory.getTheFactory().getStudentDAO().saveOrUpdate(this);
			
		}

	
	
	public QRCode getQrCode() {
		return qrCode;
	}

	public void setQrCode(QRCode qrCode) {
		this.qrCode = qrCode;
	}
	
	public boolean isIngecheckt() {
		return isIngecheckt;
	}

	public void setIngecheckt(boolean isIngecheckt) {
		this.isIngecheckt = isIngecheckt;
	}

	public SortedSet<Melding> getMeldingen() {

		return meldingen;
	}

	public void setMeldingen(SortedSet<Melding> meldingen) {
		this.meldingen = meldingen;
	}

	public String getStudentenNR() {
		return studentenNR;

	}

	public void setStudentenNR(String studentenNR) {
		this.studentenNR = studentenNR;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Opleiding getOpleiding() {
        return opleiding;
    }

    public void setOpleiding(Opleiding opleiding) {
        this.opleiding = opleiding;
    }

}