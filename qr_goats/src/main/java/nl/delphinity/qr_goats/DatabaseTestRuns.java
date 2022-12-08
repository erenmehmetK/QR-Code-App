package nl.delphinity.qr_goats;

import org.hibernate.Session;

import nl.delphinity.qr_goats.domain.Account;
import nl.delphinity.qr_goats.domain.Persoon;
import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.factories.DAOFactories;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;
import nl.delphinity.qr_goats.persistence.utils.HibernateSessionManager;

public class DatabaseTestRuns {
	public static void main(String[] args) {
		DatabaseTestRuns dtr = new DatabaseTestRuns();
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

		dtr.createAccount();
		dtr.createPerson2();
		HibernateSessionManager.getSessionFactory().getCurrentSession().getTransaction().commit();
		HibernateSessionManager.shutdown();
	}


	public void createAccount() {
		Account a = new Account();
		a.setEmail("bvanhuele@scalda.nl");
		a.setWachtwoord("abc");

		Student s = new Student();
		s.setNaam("Bram");
		s.setTussenvoegsel("van");
		s.setAchternaam("heule");
		s.setStudentenNR("235227");
		s.setAccount(a);
		DAOFactory.getTheFactory().getAccountDAO().saveOrUpdate(a);
		DAOFactory.getTheFactory().getStudentDAO().saveOrUpdate(s);

	}

	public void createPerson2() {
		Account a2 = new Account();
		a2.setEmail("mbrugge@student.scalda.nl");
		a2.setWachtwoord("ja ja");
		
		Student s2 = new Student();
		s2.setAccount(a2);
		s2.setNaam("miguel");
//		s2.setTussenvoegsel("");
		s2.setAchternaam("heule");
		s2.setStudentenNR("234393");
		DAOFactory.getTheFactory().getAccountDAO().saveOrUpdate(a2);
		DAOFactory.getTheFactory().getStudentDAO().saveOrUpdate(s2);
	}

	public void assignStudentToAccount(String studentNR, String account) {
		Student st = DAOFactory.getTheFactory().getStudentDAO().findById(studentNR);
		Account ac = DAOFactory.getTheFactory().getAccountDAO().findById(studentNR);
		if (st == null || ac == null) {
			return;
		}
//		ac.setStudent(st);

		DAOFactory.getTheFactory().getAccountDAO().saveOrUpdate(ac);
	}
}
