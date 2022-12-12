package nl.delphinity.qr_goats.domain;

import java.util.TreeSet;

import nl.delphinity.qr_goats.persistence.factories.DAOFactories;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;

public class Opleiding {
	private static Opleiding instance;

	static TreeSet<Student> studenten;

	private int id;

	public TreeSet<Student> getStudenten() {
		return studenten;
	}

	public void setStudenten(TreeSet<Student> studenten) {
		this.studenten = studenten;
	}

	private Opleiding() {
	}
	

	public static Opleiding getInstance() {
		if (instance == null) {
			instance = new Opleiding();
			load();
		}
		return instance;
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
				System.out.println(s);
				s.ziekMelden();
				System.out.println(s.getMeldingen());
			}
		}

	}

	public void studentLaatMelden(int id, String opmerking, String reden) {
//	    DAOFactory.getTheFactory().get
		for (Student s : studenten) {
			if (s.getId() == id) {
				System.out.println(s); 	
				s.laatMelden(opmerking, reden);
				System.out.println(s.getMeldingen());
			}
		}
	}

	private static void load() {
		// Call naar DAO van Opleiding en die returned een hoof studenten voor je
		// treeset
		   DAOFactory.setTheFactory(DAOFactories.TESTDATA.getTheFactory());
		studenten = (TreeSet<Student>) DAOFactory.getTheFactory().getStudentDAO().findAll();
		return;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
