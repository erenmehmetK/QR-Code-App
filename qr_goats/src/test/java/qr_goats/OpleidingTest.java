package qr_goats;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import nl.delphinity.qr_goats.domain.Opleiding;
import nl.delphinity.qr_goats.domain.OpleidingFacade;
import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.factories.DAOFactories;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;
import nl.delphinity.qr_goats.persistence.test.dao.TestStudentDAO;


public class OpleidingTest {
	
	
	private Opleiding opleiding;

	@Before
	public void setUp() {
		DAOFactory.setTheFactory(DAOFactories.TESTDATA.getTheFactory());
		  
		opleiding = OpleidingFacade.getInstance().getOpleiding();
		
        for(Student s : TestStudentDAO.getInstance().getStudenten()) {
	    	 
	    	 opleiding.addStudent(s);
	    	 
	     }  
	}
	
	@Test
	public void OpleidingNullTest() {
		//Checkt of de opleiding niet null is
		assertNotNull(opleiding);
	}
	
	@Test
	public void OpleidingStudentTest() {
		
        //Checkt of de treeset studenten heeft studenten
		
		assertTrue(opleiding.getStudenten().size() == 100);
		
	}
	
	
	@Test
	public void OpleidingStudentMeldingTest() {
		
		opleiding.studentLaatMelden("111111", "Mijn kat moest naar de ziekenhuis", "Overige");
        opleiding.studentZiekMelden("222222");
		
        
        //for each loop om te checken of de student meldt laat.
		for(Student s: opleiding.getStudenten()) {
			if(s.getStudentenNR().equals("111111")) {
				
				assertTrue(s.getMeldingen().size() == 1);
			}
		}
		
		//for each loop om te checken of de student meldt ziek.
		for(Student s: opleiding.getStudenten()) {
			if(s.getStudentenNR().equals("222222")) {
				
				assertTrue(s.getMeldingen().size() == 1);
			}
		}
		
	}
	
}
