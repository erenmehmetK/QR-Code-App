package nl.delphinity.qr_goats.domain;

import javax.persistence.*;

import nl.delphinity.qr_goats.persistence.factories.DAOFactory;

import java.util.Set;

@Entity
@Table(name = "opleiding")
public class Opleiding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "naam")
    private String naam;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "opleiding_id")
    private Set<Student> studenten;

    public Opleiding() {}

    public Opleiding(String naam) {
        this.naam = naam;
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

    public Set<Student> getStudenten() {
        return studenten;
    }

    public void setStudenten(Set<Student> studenten) {
        this.studenten = studenten;
    }

    @Override
    public String toString() {
        return "Opleiding{" +
                "id=" + id +
                ", naam='" + naam + '\'' +
                '}';
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
		// Set
		studenten = (Set<Student>) DAOFactory.getTheFactory().getStudentDAO().findAll();

	}

}
