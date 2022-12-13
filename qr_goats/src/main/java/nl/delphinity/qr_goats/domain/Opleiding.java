package nl.delphinity.qr_goats.domain;

import java.util.TreeSet;

import nl.delphinity.qr_goats.persistence.factories.DAOFactories;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;

public class Opleiding {

	private TreeSet<Student> studenten;

	private int id;
	
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
