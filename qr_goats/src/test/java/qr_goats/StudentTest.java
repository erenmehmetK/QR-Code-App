package qr_goats;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.opensymphony.xwork2.interceptor.annotations.Before;

import nl.delphinity.qr_goats.domain.Account;
import nl.delphinity.qr_goats.domain.LaatMelding;
import nl.delphinity.qr_goats.domain.Melding;
import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.test.dao.TestStudentDAO;
import nl.delphinity.qr_goats.persistence.factories.DAOFactories;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;

public class StudentTest {

	@Before
	public void createDatabase() {

//		DAOFactory.setTheFactory(DAOFactories.TESTDATA.getTheFactory());

	}

	@Test
	public void findstudentByemailTest() {
		TestStudentDAO studentDAO = TestStudentDAO.getInstance();
		Student student = studentDAO.findById(1);

		Account ac = new Account();
		student.setAccount(ac);

//	    assertNotNull(studentDB.getAccount());
		assertNotNull(studentDAO.findByEmail(ac));
	}

	@Test
	public void laatMeldenTest() {

		TestStudentDAO studentDAO = TestStudentDAO.getInstance();
		Student student = studentDAO.findById(1);

		Melding m1 = student.laatMelden("yeah...");

		// Check if melding is added to student
		assertTrue(student.getMeldingen().contains(m1));

		// Check if opmerking is set
		assertEquals(((LaatMelding) m1).getOpmerking(), "yeah...");

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

		// Check if melding has correct student
		assertEquals(m1.getStudent(), student);

	}

}