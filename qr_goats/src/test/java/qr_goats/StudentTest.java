package qr_goats;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.opensymphony.xwork2.interceptor.annotations.Before;

import nl.delphinity.qr_goats.domain.Melding;
import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.test.dao.TestStudentDAO;
import nl.delphinity.qr_goats.persistence.factories.DAOFactories;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;

public class StudentTest {
	
	@Before
	public void createDatabase() {
		
	   DAOFactory.setTheFactory(DAOFactories.TESTDATA.getTheFactory());
	   
	   
	}
	
	@Test
	public void laatMeldenTest() {
		
	    
	    TestStudentDAO studentDAO = TestStudentDAO.getInstance();
	    Student student = studentDAO.findById(1);
	      
	    Melding m1 = student.laatMelden("yeah...");
	    
	    // Check if melding is added to student
	    assertTrue(student.getMeldingen().contains(m1));
	    
	    // Check if opmerking is set
	    assertEquals(m1.getOpmerking(), "yeah...");
	    
	    // Check if melding is right type
	    assertEquals(m1.getType(), Melding.TYPE.LAAT);
	    
	    // Check if melding has correct student
	    assertEquals(m1.getStudent(), student);

		  
	}
	


	
	@Test
	public void laatMeldenZonderOpmerking() {
		
	    
	    TestStudentDAO studentDAO = TestStudentDAO.getInstance();
	    Student student = studentDAO.findById(1);
		
	    Melding m1 = student.laatMelden();
	    
	    // Check if melding is added to student
	    assertTrue(student.getMeldingen().contains(m1));
	    
	    // Check if opmerking is set
	    assertNull(m1.getOpmerking());
	    
	    // Check if melding is right type
	    assertEquals(m1.getType(), Melding.TYPE.LAAT);
	    
	    // Check if melding has correct student
	    assertEquals(m1.getStudent(), student);
	}
	
	
	

	     @Test
	     public void ziekMeldenTest() {
		 
	 	    
	 	 TestStudentDAO studentDAO = TestStudentDAO.getInstance();
	 	 Student student = studentDAO.findById(1);
	 	 
	 	 
	     Melding m1 = student.ziekMelden();
	     
	     // Check if melding is added to student
	     assertTrue(student.getMeldingen().contains(m1));
	     
	     // Check if melding is right type
	     assertEquals(m1.getType(), Melding.TYPE.ZIEK);
	     
	     // Check if melding has correct student
	     assertEquals(m1.getStudent(), student);
	 }
	
	
}