	package nl.delphinity.qr_goats;

import org.hibernate.Session;

import nl.delphinity.qr_goats.domain.Account;
import nl.delphinity.qr_goats.domain.Opleiding;
import nl.delphinity.qr_goats.domain.OpleidingFacade;
import nl.delphinity.qr_goats.domain.PasswordHashing;
import nl.delphinity.qr_goats.domain.PasswordHashing.CannotPerformOperationException;
import nl.delphinity.qr_goats.domain.PasswordHashing.InvalidHashException;
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


		/**
		 * Setting the DAOFActory for use with HibernateDAOFactory and it's DAO's.
		 */

		DAOFactory.setTheFactory(DAOFactories.HIBERNATE.getTheFactory());

		Session session = HibernateSessionManager.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		
		db.createAccount();
//		db.getStudentByAccount();
		
		HibernateSessionManager.shutdown();
	}

	public void getStudentByAccount() {
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
		s.setAchternaam("heulle");
		s.setStudentenNR("234393");
		HibernateSessionManager.getSessionFactory().getCurrentSession().getTransaction().commit();
        


	}

	public void createAccount() {
		
		Account c4 = new Account();
		c4.setEmail("237582@scalda.nl");
		try {c4.setWachtwoord(PasswordHashing.createHash("feyenoord"));}
		catch (CannotPerformOperationException c3) {c3.printStackTrace();}

		Student s4 = new Student();
		s4.setAccount(c4);
		s4.setNaam("boris");
		s4.setAchternaam("sanderse");
		s4.setStudentenNR("237582");
		
		
		Account a = new Account();
		a.setEmail("mbrugge@student.scalda.nl");
		try {
			a.setWachtwoord(PasswordHashing.createHash("jaja"));
		} catch (CannotPerformOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Student s = new Student();
		s.setAccount(a);
		s.setNaam("miguel");
		s.setTussenvoegsel("van");
		s.setAchternaam("heule");
		s.setStudentenNR("234393");
		
		Account j = new Account();

		j.setEmail("jarno@student.scalda.nl");
		try {
			j.setWachtwoord(PasswordHashing.createHash("jarno"));
		} catch (CannotPerformOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DAOFactory.getTheFactory().getAccountDAO().saveOrUpdate(c4);
		DAOFactory.getTheFactory().getStudentDAO().saveOrUpdate(s4);
		DAOFactory.getTheFactory().getAccountDAO().saveOrUpdate(a);
		DAOFactory.getTheFactory().getStudentDAO().saveOrUpdate(s);
		DAOFactory.getTheFactory().getAccountDAO().saveOrUpdate(j);
//		HibernateSessionManager.getSessionFactory().getCurrentSession().getTransaction().commit();
		
		a.changePassword("jaja", "ABC");
		Account aWWTest = DAOFactory.getTheFactory().getAccountDAO().findbyemail(a);
		try {
			PasswordHashing.verifyPassword("ABC", aWWTest.getWachtwoord());
		} catch (CannotPerformOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidHashException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getfromDB(a);
		
		Student s2 = new Student();
		s2.setNaam("Ok");
		s2.setAchternaam("yeah");
		s2.setTussenvoegsel("ok");
		s2.setStudentenNR("236714");

        Opleiding opleiding = OpleidingFacade.getInstance().getOpleiding();
        opleiding.setNaam("Software Developer");
        opleiding.addStudent(s);
        opleiding.addStudent(s2);    
        
        
        DAOFactory.getTheFactory().getAccountDAO().saveOrUpdate(a);
        DAOFactory.getTheFactory().getStudentDAO().saveOrUpdate(s);
        DAOFactory.getTheFactory().getStudentDAO().saveOrUpdate(s2);

        DAOFactory.getTheFactory().getOpleidingDAO().saveOrUpdate(opleiding);
        HibernateSessionManager.getSessionFactory().getCurrentSession().getTransaction().commit();
        
    }
	
	
	public void getfromDB(Account a) {
		Student fromdb = DAOFactory.getTheFactory().getStudentDAO().findByEmail(a);
	}

}
