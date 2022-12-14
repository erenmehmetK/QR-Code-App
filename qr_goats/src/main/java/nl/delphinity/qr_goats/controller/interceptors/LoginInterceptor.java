package nl.delphinity.qr_goats.controller.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import nl.delphinity.qr_goats.persistence.factories.DAOFactories;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public void init() {
		 
		super.init();
		DAOFactory.setTheFactory(DAOFactories.HIBERNATE.getTheFactory());
		DAOFactory.setTheFactory(DAOFactories.HIBERNATE.getTheFactory());
	}

	@Override
	public void destroy() {
		DAOFactory.setTheFactory(DAOFactories.HIBERNATE.getTheFactory());
		 
		DAOFactory.setTheFactory(DAOFactories.HIBERNATE.getTheFactory());
		super.destroy();
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		
		String result = invocation.invoke();
		return result;
	}

}
