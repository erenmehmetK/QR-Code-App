package nl.delphinity.qr_goats;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import nl.delphinity.qr_goats.domain.*;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class HelloAction extends ActionSupport implements SessionAware{
<<<<<<< Updated upstream

//	zorgt at alles zelfde niveau. verkleint de kans op errors	
	private static final long serialVersionUID = 1L;

	//	BELANGRIJK! AFBLIJVEN HIER VAN MET JE FIKKEN
	 private Map<String, Object> session;
	
	private Persoon per = new Persoon();
	

	@Override
   public String execute() {
		System.out.println("ea");
		session.clear();
		per.setNaam("Hanz");
		per.setTussenvoegsel(null);
		per.setAchternaam("PANZERKAMPFWAGEN");
		per.setEmail("Hanz@mail.com");
		session.putIfAbsent("persoon", per.toString());

		
		return SUCCESS;
   }
	
	public String test() {
		System.out.println("test");
		return SUCCESS;
	}
	
	
	
	
   
   public Persoon getPer() {
	   return per;
   }

	public void setPer(Persoon per) {
		this.per = per;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		
	}
	
	public Map<String, Object> getSession() {
        return session;
    }
   
=======
	
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> sessionMap;
	private Persoon per;
	
	@Override
	public String execute() {
		
		per = new Persoon();
		per.setNaam("Hans");
		per.setTussenvoegsel("De");
		per.setAchternaam("Gans");
		per.setEmail("Hans@Scalda.com");
		
		sessionMap.put("Persoon", per);
		
		System.out.println("Executed");
		return "SUCCESS";
   }
	
	public String getData() {
		per = (Persoon)sessionMap.get("Persoon");
		System.out.println("persoonNaam: " + per.getNaam());
		System.out.println("Pakt data");
		return "SUCCESS";
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

>>>>>>> Stashed changes
}