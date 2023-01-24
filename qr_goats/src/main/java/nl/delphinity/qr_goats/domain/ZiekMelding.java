package nl.delphinity.qr_goats.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "FK_ziekmelding_meldingID"))
@OnDelete(action = OnDeleteAction.CASCADE)
public class ZiekMelding extends Melding {
	
	@Override
	public String toString() {

		return getId() + " " + getDatum() + " " + getStudent();
	}
	
	public ZiekMelding() {
		
	}
	
	public ZiekMelding(int id, LocalDateTime datum, Student student) {
		super(id, datum, student);
		
	}

	
}
