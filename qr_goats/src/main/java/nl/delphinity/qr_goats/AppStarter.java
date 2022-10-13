package nl.delphinity.qr_goats;

import org.hibernate.Session;

import nl.delphinity.qr_goats.domain.Persoon;
import nl.delphinity.qr_goats.persistence.factories.DAOFactories;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;
import nl.delphinity.qr_goats.persistence.utils.HibernateSessionManager;


/**
 * Hello world!
 *
 */
public class AppStarter {
	public static void main(String[] args) {
		
		/**
		 * If all was correct imported, implemented and configurated,
		 * running this app will create an empty databases with the name specified
		 * in your hibernate.properties file.
		 * Check manually in your MySQL DBMS using MySQL Workbench!!
		 * 
		 * After creating some classes and annotating them as @entity
		 * and after adjusting your hibernate.cfg.xml file with the appropriate mappings,
		 * this app shoud create your tables and columns.
		 * 
		 * Don't forget to configure your hibernate.hbm2ddl.auto!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		 */
		
		System.out.println("Hello Hibernate World!");
		
		/**
		 * Setting the DAOFActory for use with HibernateDAOFactory and
		 * it's DAO's.
		 */
		
		DAOFactory.setTheFactory(DAOFactories.HIBERNATE.getTheFactory());

		Session session = HibernateSessionManager.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Persoon per = new Persoon();
		

		per.setNaam("jarno");
		per.setEmail("jdeconick@scalda");
		per.setTussenvoegsel("de");
		per.setAchternaam("conick");


		DAOFactory.getTheFactory().getPersoonDAO().saveOrUpdate(per);
		
		

		HibernateSessionManager.getSessionFactory().getCurrentSession().getTransaction().commit();
		HibernateSessionManager.shutdown();
	}
}
