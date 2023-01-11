package nl.delphinity.qr_goats.controller.interceptors;

 

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

 

import nl.delphinity.qr_goats.domain.Account;
import nl.delphinity.qr_goats.domain.Melding;
import nl.delphinity.qr_goats.domain.OpleidingFacade;
import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.factories.DAOFactories;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;

 

public class StudentInterceptor extends AbstractInterceptor {

 


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Override
    public void init() {
        super.init();
        DAOFactory.setTheFactory(DAOFactories.HIBERNATE.getTheFactory());
        OpleidingFacade.getInstance().getOpleiding().loadTestData();        

    }

 

    @Override
    public void destroy() {
        DAOFactory.setTheFactory(DAOFactories.HIBERNATE.getTheFactory());
        super.destroy();

    }

 

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {


        String result = invocation.invoke();
        return result;
    }

 

}