package nl.delphinity.qr_goats;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;
import nl.delphinity.qr_goats.domain.*;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;


public class HelloAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;

	private Map<String, Object> sessionMap;
	private Persoon per;
		
	private Account acc;
	private QRCode qrcode = new QRCode();
	private String qrimage;

	@Override
	public String execute() {

		sessionMap.putIfAbsent("Persoon", per);
		
		sessionMap.putIfAbsent("Account", acc);
	
		return "SUCCESS";
	}
	
	public String login() {
        if(acc.loginCheck()) {
//            String studentenNummer = acc.getEmail().substring(0, 6);
            Student stud = DAOFactory.getTheFactory().getStudentDAO().findByEmail(acc);
            String studentenNummer = stud.getStudentenNR();

            qrimage = qrcode.generateQR(studentenNummer);
            return "SUCCESS";
        } else {
            return "ERROR";
        }
    }
	
	public String getQrimage() {
		return qrimage;
	}

	public void setQrimage(String qrimage) {
		this.qrimage = qrimage;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.sessionMap = session;
	}
	
	public Map<String, Object> getSessionMap() {
		return sessionMap;
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

	
	


}