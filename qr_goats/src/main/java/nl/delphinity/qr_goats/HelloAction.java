package nl.delphinity.qr_goats;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import nl.delphinity.qr_goats.domain.*;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class HelloAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;

	private Map<String, Object> sessionMap;
	private Persoon per;
		
	private Account acc;
	private String email;
	private String wachtwoord;
	
	
	@Override
	public String execute() {

		sessionMap.putIfAbsent("Persoon", per);
		
		sessionMap.putIfAbsent("Account", acc);
	
		return "SUCCESS";
	}
	
	public String login() {
		acc = new Account();
		
		acc.setEmail(email);
		acc.setWachtwoord(wachtwoord);

		if(acc.loginCheck()) {
			return "SUCCESS";
		}else {
			return null;
		}
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

	
	
}