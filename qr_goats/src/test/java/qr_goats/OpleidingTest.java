package qr_goats;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import nl.delphinity.qr_goats.domain.Opleiding;
import nl.delphinity.qr_goats.domain.OpleidingFacade;
import nl.delphinity.qr_goats.domain.Student;


public class OpleidingTest {
	
	
	private Opleiding opleiding;

	@Before
	public void setUp() {
		opleiding = OpleidingFacade.getInstance().getOpleiding();
		opleiding.loadTestData();
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
		
		opleiding.studentLaatMelden(1, "Mijn kat moest naar de ziekenhuis", "Overige");
        opleiding.studentZiekMelden(2);
		
        
        //for each loop om te checken of de student meldt laat.
		for(Student s: opleiding.getStudenten()) {
			if(s.getId() == 1) {
				
				assertTrue(s.getMeldingen().size() == 1);
			}
		}
		
		//for each loop om te checken of de student meldt ziek.
		for(Student s: opleiding.getStudenten()) {
			if(s.getId() == 2) {
				
				assertTrue(s.getMeldingen().size() == 1);
			}
		}
		
	}
	
}
