package nl.delphinity.qr_goats;


import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import nl.delphinity.qr_goats.domain.*;
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
 	 private Melding meld;
 	 private String opmerking;
 	 private String reden;
 	 private Opleiding opl;
     private QRCode qrcode = new QRCode();
 	 private String qrimage;

 

     @Override
     public String execute() {
    	   	 
         return "SUCCESS";
     }

 

     public String login() {
         if (acc.loginCheck()) {
        	 
        
         	 //TODO haal student weg, gebruik account om toegang aan student te krijgen
             stud = DAOFactory.getTheFactory().getStudentDAO().findByEmail(acc);
             sessionMap.putIfAbsent("Student", stud);

             acc = DAOFactory.getTheFactory().getAccountDAO().findbyemail(acc);
             sessionMap.putIfAbsent("Account", acc);
             
             opl = OpleidingFacade.getInstance().getOpleiding();
             sessionMap.putIfAbsent("Opleiding", opl);
             
             String studentenNummer = stud.getStudentenNR();
             qrimage = qrcode.generateQR(studentenNummer);
             

 

             return "SUCCESS";
         } else {
             return "ERROR";
         }
     }

     public String logOut() {
    	 
         sessionMap.clear();
         HibernateSessionManager.getSessionFactory().getCurrentSession().close();
         

		return "SUCCESS"; 

     }
 

     public String profiel() {

 

         acc = (Account) sessionMap.get("Account");

 

         return "SUCCESS";
     }

 

     public String wijzigWachtwoord() {
         if (nieuwww1.equals(nieuwww2verify)) {
             acc = (Account) sessionMap.get("Account");
            if(acc.changePassword(oudww, nieuwww1)) {
                sessionMap.put("Account", acc);
                return SUCCESS;
            } 
         } 
         return ERROR;
     }
     
     
     
     
     public String studentMeldZiek() {
    	 
    	Student st = (Student) sessionMap.get("Student");
  		
  		String stnr = st.getStudentenNR();
  				
  	    OpleidingFacade.getInstance().getOpleiding().studentZiekMelden(stnr);
  		
 		return "SUCCESS";
 		
 	}

 	public String studentMeldLaat() {
 		
        Student st = (Student) sessionMap.get("Student");
 		
 		String stnr = st.getStudentenNR();
 				
 	    OpleidingFacade.getInstance().getOpleiding().studentLaatMelden(stnr, opmerking, reden);
 		
		return "SUCCESS";
 		
 	}

 

     public QRCode getQrcode() {
		return qrcode;
	}



	public void setQrcode(QRCode qrcode) {
		this.qrcode = qrcode;
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
	
     public Melding getMeld() {
		return meld;
	}



	public void setMeld(Melding meld) {
		this.meld = meld;
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