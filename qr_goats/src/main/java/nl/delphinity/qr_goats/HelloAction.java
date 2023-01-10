package nl.delphinity.qr_goats;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;
import nl.delphinity.qr_goats.domain.*;
import nl.delphinity.qr_goats.domain.PasswordHashing.CannotPerformOperationException;
import nl.delphinity.qr_goats.persistence.factories.DAOFactories;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;
import nl.delphinity.qr_goats.persistence.utils.HibernateSessionManager;

public class HelloAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;

	private Map<String, Object> sessionMap;
	private Persoon per;
	private Student stud;
	private Account acc;
	private String oudww;
	private String nieuwww1;
	private String nieuwww2verify;

	@Override
	public String execute() {
		return "SUCCESS";
	}

	public String login() {
		if (acc.loginCheck()) {

			stud = DAOFactory.getTheFactory().getStudentDAO().findByEmail(acc);
			sessionMap.putIfAbsent("Student", stud);

			acc = DAOFactory.getTheFactory().getAccountDAO().findbyemail(acc);
			sessionMap.putIfAbsent("Account", acc);
						
			return "SUCCESS";
		} else {
			return "ERROR";
		}
	}

	public String profiel() {

		acc = (Account) sessionMap.get("Account");

		return "SUCCESS";
	}

	public String wijzigWachtwoord() {
		if (nieuwww1.equals(nieuwww2verify)) {
			acc = (Account) sessionMap.get("Account");
			sessionMap.put("Account", acc);
			if(acc.changePassword(oudww, nieuwww1)) {
				sessionMap.put("Account", acc);
			return "SUCCESS";
			} else {
				
				return "ERROR";
			}
		}
		
		return "ERROR";
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.sessionMap = session;
	}

	public Persoon getPer() {
		return per;
	}

	public void setPer(Persoon per) {
		this.per = per;
	}

	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}

	public Student getStud() {
		return stud;
	}

	public void setStud(Student stud) {
		this.stud = stud;
	}

	public String getOudww() {
		return oudww;
	}

	public void setOudww(String oudww) {
		this.oudww = oudww;
	}

	public String getNieuwww1() {
		return nieuwww1;
	}

	public void setNieuwww1(String nieuwww1) {
		this.nieuwww1 = nieuwww1;
	}

	public String getNieuwww2verify() {
		return nieuwww2verify;
	}

	public void setNieuwww2verify(String nieuwww2verify) {
		this.nieuwww2verify = nieuwww2verify;
	}

}