package nl.delphinity.qr_goats.domain;


import java.util.TreeSet;

import nl.delphinity.qr_goats.persistence.test.dao.TestOpleidingDAO;

public class Opleiding {
    private static Opleiding instance;
    
	TreeSet<Student> studenten;

	


    private Opleiding() { 
    	System.out.println("Creating opleiding...");
    	load();
    }
    
    public static Opleiding getInstance() {
    	if(instance == null) {
    		instance = new Opleiding();
    	}
		return instance;
    }
	
    public Student findStudent(int id) {
    	
    	for(Student s : studenten) {
    		if(s.getId() == id) {
    			return s;
    		}
    	}
		return null;
    }

	public void studentZiekMelden(int id) {
		for(Student s : studenten) {
			if(s.getId() == id) {
				System.out.println(s);
				s.ziekMelden();
				System.out.println(s.getMeldingen());

			}
		}
		

    }
	
	public void studentLaatMelden(int id, String opmerking, String reden) {
//	    DAOFactory.getTheFactory().get
	    
		for(Student s : studenten) {
			if(s.getId() == id) {
				System.out.println(s);
				s.laatMelden(opmerking, reden);
				System.out.println(s.getMeldingen());
			}
		}

    }
	
	
	private void load() {
//		students = new TreeSet<Student>();
		//Call naar DAO van Opleiding en die returned een hoof studenten voor je treeset
	     studenten = TestOpleidingDAO.getInstance().generateStudents();
		// pas test aan na datalayer
		
	}
    
    


}
