package nl.delphinity.qr_goats;

import org.hibernate.Session;

import nl.delphinity.qr_goats.domain.Account;
import nl.delphinity.qr_goats.domain.PasswordHashing;
import nl.delphinity.qr_goats.domain.PasswordHashing.CannotPerformOperationException;
import nl.delphinity.qr_goats.domain.PasswordHashing.InvalidHashException;
import nl.delphinity.qr_goats.domain.Persoon;
import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.factories.DAOFactories;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;
import nl.delphinity.qr_goats.persistence.utils.HibernateSessionManager;

public class DBTest {

	public static void main(String[] args) {
		DBTest db = new DBTest();
		/**
		 * If all was correct imported, implemented and configurated, running this app
		 * will create an empty databases with the name specified in your
		 * hibernate.properties file. Check manually in your MySQL DBMS using MySQL
		 * Workbench!!
		 * 
		 * After creating some classes and annotating them as @entity and after
		 * adjusting your hibernate.cfg.xml file with the appropriate mappings, this app
		 * shoud create your tables and columns.
		 * 
		 * Don't forget to configure your
		 * hibernate.hbm2ddl.auto!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		 */

		System.out.println("Hello Hibernate World!");

		/**
		 * Setting the DAOFActory for use with HibernateDAOFactory and it's DAO's.
		 */

		DAOFactory.setTheFactory(DAOFactories.HIBERNATE.getTheFactory());

		Session session = HibernateSessionManager.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		
//		db.createAccount();
		db.getaccountByAccount();
		
		HibernateSessionManager.shutdown();
	}

	public void getaccountByAccount() {
		Account a = new Account();
		a.setEmail("mbrugge@student.scalda.nl");
		try {
			a.setWachtwoord(PasswordHashing.createHash("ja ja"));
		} catch (CannotPerformOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Student s = new Student();
		s.setAccount(a);
		s.setNaam("miguel");
		s.setAchternaam("heule");
		s.setStudentenNR("234393");
		HibernateSessionManager.getSessionFactory().getCurrentSession().getTransaction().commit();
		Student fromdb = DAOFactory.getTheFactory().getStudentDAO().findByEmail(a);
		System.out.println(fromdb.getNaam());
	}

	public void createAccount() {
		Account a = new Account();
		a.setEmail("mbrugge@student.scalda.nl");
		try {
			a.setWachtwoord(PasswordHashing.createHash("ja ja"));
		} catch (CannotPerformOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Student s = new Student();
		s.setAccount(a);
		s.setNaam("miguel");
		s.setAchternaam("heule");
		s.setStudentenNR("234393");
		DAOFactory.getTheFactory().getAccountDAO().saveOrUpdate(a);
		DAOFactory.getTheFactory().getStudentDAO().saveOrUpdate(s);
		HibernateSessionManager.getSessionFactory().getCurrentSession().getTransaction().commit();

		a.changePassword("ja ja", "ABC");
		Account aWWTest = DAOFactory.getTheFactory().getAccountDAO().findbyemail(a);
//		System.out.println(aWWTest.getWachtwoord());
		try {
			System.out.println(PasswordHashing.verifyPassword("ABC", aWWTest.getWachtwoord()));
		} catch (CannotPerformOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidHashException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
