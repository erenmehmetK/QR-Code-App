package nl.delphinity.qr_goats.domain;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import nl.delphinity.qr_goats.persistence.factories.DAOFactory;

@Entity
@Table(name = "opleiding")
public class Opleiding {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "opleidingID", nullable = false, unique = true)
	private int id;
	
	@Column(name = "opleiding_naam", length = 20, nullable = false, unique = false)
	private String naam;
	
	@OneToMany(mappedBy = "opleiding", cascade = CascadeType.ALL)
	private SortedSet<Student> studenten;
	
	public Opleiding() {

	}

	public Student findStudent(String studentenNR) {
		
		if (studenten == null) {

			studenten = new TreeSet<Student>();

		}

		for (Student s : studenten) {
			if (s.getStudentenNR().equals(studentenNR)) {
				return s;
			}
		}
		return null;
	}

	public Melding studentZiekMelden(String studentenNR) {
		
		if (studenten == null) {

			studenten = new TreeSet<Student>();

		}
		
		Melding m1 = null;
		
		for (Student s : studenten) {
			if (s.getStudentenNR().equals(studentenNR)) {
				m1 = s.ziekMelden();
				
				System.out.println(s.getMeldingen());

				
			}
		}
		 
       return m1;
	}

	public Melding studentLaatMelden(String studentenNR, String opmerking, String reden) {
		
		
		
		if (studenten == null) {

			studenten = new TreeSet<Student>();

		}
		
		Melding m1 = null;
		
		for (Student s : studenten) {
			if (s.getStudentenNR().equals(studentenNR)) {
				m1 = s.laatMelden(opmerking, reden);
				System.out.println(s.getMeldingen());
				
			}
			
		}
	
		return m1;
	}

	// TODO remove after testing
	public void loadTestData() {
		// Call naar DAO van Opleiding en die returned een hoof studenten voor je
		// treeset
		studenten = (SortedSet<Student>) DAOFactory.getTheFactory().getStudentDAO().findAll();

	}
	
	public void addStudent(Student s) {
		
		if (studenten == null) {

			studenten = new TreeSet<Student>();

		}
		
		studenten.add(s);
		s.setOpleiding(this);
	}
	
	public void removeStudent(Student s) {
		studenten.remove(s);
		s.setOpleiding(null);
	}

	public SortedSet<Student> getStudenten() {
		return studenten;
	}
	
	public String toString() {
		return id + " " + studenten;
	}

	public void setStudenten(SortedSet<Student> studenten) {
		this.studenten = studenten;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

}
