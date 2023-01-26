package qr_goats;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import org.junit.Before;

import nl.delphinity.qr_goats.domain.Account;
import nl.delphinity.qr_goats.domain.LaatMelding;
import nl.delphinity.qr_goats.domain.Melding;
import nl.delphinity.qr_goats.domain.Opleiding;
import nl.delphinity.qr_goats.domain.OpleidingFacade;
import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.test.dao.TestStudentDAO;
import nl.delphinity.qr_goats.persistence.factories.DAOFactories;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;
import nl.delphinity.qr_goats.persistence.interfaces.IStudentDAO;

public class StudentTest {
	
	private Opleiding opleiding;
	
	@Before
	public void setup() {

		DAOFactory.setTheFactory(DAOFactories.TESTDATA.getTheFactory());
		
		opleiding = OpleidingFacade.getInstance().getOpleiding();
		
		for(Student s : TestStudentDAO.getInstance().getStudenten()) {
	    	 
	    	 opleiding.addStudent(s);
	    	 
	     }  

	}

	@Test
	public void findstudentByemailTest() {
		TestStudentDAO studentDAO = TestStudentDAO.getInstance();
		Student student = studentDAO.findById("100001");

		Account ac = new Account();
		student.setAccount(ac);

//	    assertNotNull(studentDB.getAccount());
		assertNotNull(studentDAO.findByEmail(ac));
	}

	@Test
	public void laatMeldenTest() {

	    
		Student student = opleiding.findStudent("100001");
		

		Melding m1 = student.laatMelden("yeah...", "Overige");

		// Check if melding is added to student
		assertTrue(student.getMeldingen().contains(m1));

		// Check if opmerking is set
		assertEquals(((LaatMelding) m1).getOpmerking(), "yeah...");
		// Check if reden is set
		assertEquals(((LaatMelding) m1).getReden(), "Overige");

		// Check if melding has correct student
		assertEquals(m1.getStudent(), student);

	}

	@Test
	public void ziekMeldenTest() {

	
		Student student = opleiding.findStudent("100001");

		Melding m1 = student.ziekMelden();

		// Check if melding is added to student
		assertTrue(student.getMeldingen().contains(m1));

		// Check if melding has correct student
		assertEquals(m1.getStudent(), student);

	}
	
	

}