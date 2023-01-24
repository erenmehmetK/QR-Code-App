package nl.delphinity.qr_goats.controller.interceptors;

 

import java.lang.reflect.Method;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import nl.delphinity.qr_goats.HelloAction;
import nl.delphinity.qr_goats.domain.Account;
import nl.delphinity.qr_goats.domain.Opleiding;
import nl.delphinity.qr_goats.domain.OpleidingFacade;
import nl.delphinity.qr_goats.domain.Student;
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
			System.out.println("Voor invoke");
			
			  Method method = HelloAction.class.getDeclaredMethod("getSessionMap");
		        Map<String, Object> sessionMap = invocation.getInvocationContext().getSession();
		        Opleiding op = (Opleiding) sessionMap.get("Opleiding");
		        if(op != null) {
		        op.save();
		        }

			String result = invocation.invoke();
			System.out.println("Na invoke");
			
		      
//	           
//	        
//	        Student st = (Student) hl.getSessionMap().get("Student");
//	        st.save();
//	        
//	        Account acc = (Account) hl.getSessionMap().get("Account");
//	        acc.save();
			
					
	        HibernateSessionManager.getSessionFactory().getCurrentSession().getTransaction().commit();
			System.out.println("na commit");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			HibernateSessionManager.getSessionFactory().getCurrentSession().getTransaction().rollback();
			return "error";
		}
    }

  

	public Session getSession() {
		return session;
	}



	public void setSession(Session session) {
		this.session = session;
	}

 

}