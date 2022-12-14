package nl.delphinity.qr_goats.controller.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import nl.delphinity.qr_goats.persistence.factories.DAOFactories;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;
import nl.delphinity.qr_goats.persistence.utils.HibernateSessionManager;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public void init() {
		 
		super.init();
		DAOFactory.setTheFactory(DAOFactories.HIBERNATE.getTheFactory());
<<<<<<< HEAD

=======
		DAOFactory.setTheFactory(DAOFactories.HIBERNATE.getTheFactory());
>>>>>>> develop
	}

	@Override
	public void destroy() {
<<<<<<< HEAD
		DAOFactory.setTheFactory(null);
=======
		DAOFactory.setTheFactory(DAOFactories.HIBERNATE.getTheFactory());
		 
		DAOFactory.setTheFactory(DAOFactories.HIBERNATE.getTheFactory());
>>>>>>> develop
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
}
