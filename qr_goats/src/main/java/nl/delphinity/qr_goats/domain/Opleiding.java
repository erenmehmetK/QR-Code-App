package nl.delphinity.qr_goats.domain;

import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import nl.delphinity.qr_goats.persistence.factories.DAOFactory;

@Entity
@Table(name = "opleiding")
public class Opleiding {

	

	@Id
	@Column(name = "opleidingID", nullable = false, length = 5, unique = true)
	private int id;
	
	@OneToMany(mappedBy = "opleiding", cascade = CascadeType.ALL)
	private TreeSet<Student> studenten = new TreeSet<Student>();
	
	public Opleiding() {

	}

	public Student findStudent(int id) {

		for (Student s : studenten) {
			if (s.getId() == id) {
				return s;
			}
		}
		return null;
	}

	public void studentZiekMelden(int id) {
		for (Student s : studenten) {
			if (s.getId() == id) {
				s.ziekMelden();
				
			}
		}

	}

	public void studentLaatMelden(int id, String opmerking, String reden) {
		
//	    DAOFactory.getTheFactory().get
		for (Student s : studenten) {
			if (s.getId() == id) {
				s.laatMelden(opmerking, reden);
				
			}
		}
	}

	// TODO remove after testing
	public void loadTestData() {
		// Call naar DAO van Opleiding en die returned een hoof studenten voor je
		// treeset
		studenten = (TreeSet<Student>) DAOFactory.getTheFactory().getStudentDAO().findAll();

	}

	public TreeSet<Student> getStudenten() {
		return studenten;
	}
	
	public String toString() {
		return id + " " + studenten;
	}

	public void setStudenten(TreeSet<Student> studenten) {
		this.studenten = studenten;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
