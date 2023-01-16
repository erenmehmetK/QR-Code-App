package nl.delphinity.qr_goats.controller.interceptors;

 

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import nl.delphinity.qr_goats.persistence.factories.DAOFactories;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;
import nl.delphinity.qr_goats.persistence.utils.HibernateSessionManager;

 

public class HibernateInterceptor extends AbstractInterceptor {

	private Session session;


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Override
    public void init() {
        super.init();
        DAOFactory.setTheFactory(DAOFactories.HIBERNATE.getTheFactory());
//        OpleidingFacade.getInstance().getOpleiding().loadTestData();        

    }

 

    @Override
    public void destroy() {
        DAOFactory.setTheFactory(null);
        super.destroy();

    }

 

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
    	
    	HibernateSessionManager.getSessionFactory().getCurrentSession().beginTransaction();
		try {
			String result = invocation.invoke();
			
			HibernateSessionManager.getSessionFactory().getCurrentSession().getTransaction().commit();
			return result;
		} catch (Exception e) {
			HibernateSessionManager.getSessionFactory().getCurrentSession().getTransaction().rollback();
		}
		return null;
    }



	public Session getSession() {
		return session;
	}



	public void setSession(Session session) {
		this.session = session;
	}

 

}