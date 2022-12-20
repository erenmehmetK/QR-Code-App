package nl.delphinity.qr_goats;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import nl.delphinity.qr_goats.domain.*;

public class MeldenAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;

	private Map<String, Object> sessionMap;
	private Student stud;
	private Melding meld;
	private String opmerking;
	private String reden;

	@Override
	public String execute() {
 
        
		return "SUCCESS";
	}

	
	public String studentMeldZiek() {
	 OpleidingFacade.getInstance().getOpleiding().studentZiekMelden("100001");
		return "SUCCESS";
		
	}

	public String studentMeldLaat() {
		 OpleidingFacade.getInstance().getOpleiding().studentLaatMelden("100001", opmerking, reden);
		return "SUCCESS";
		
	}

	public Student getStud() {
		return stud;
	}

	public void setStud(Student stud) {
		this.stud = stud;
	}

	public Melding getMeld() {
		return meld;
	}

	public void setMeld(Melding meld) {
		this.meld = meld;
	}

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.sessionMap = session;
	}

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}


	public String getOpmerking() {
		return opmerking;
	}


	public void setOpmerking(String opmerking) {
		this.opmerking = opmerking;
	}


	public String getReden() {
		return reden;
	}


	public void setReden(String reden) {
		this.reden = reden;
	}

}