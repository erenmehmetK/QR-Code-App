package nl.delphinity.qr_goats.domain;


import java.util.ArrayList;
import nl.delphinity.qr_goats.domain.Melding.TYPE;


public class Student extends Persoon {
	
	
	public Student() {
		
	}
	public Student(Integer id, String naam, String email, String tussenvoegsel, String achternaam) {
		super(id, naam, email, tussenvoegsel, achternaam);
		// TODO Auto-generated constructor stub
	}
	
	private String studentenNR;
	
	public ArrayList<Melding> meldingen = new ArrayList<Melding>();
	
	          public void addMelding(Melding m) {
	        	  meldingen.add(m);
	        	  m.setStudent(this);
	          }
	
	          public void removeMelding(Melding m) {
	        	  meldingen.remove(m);
	        	  m.setStudent(null);
	          }
	
	        //Student meldt zichzelf laat
			public Melding laatMelden(String opmerking) {
				
				Melding m1 = new Melding();
				m1.setDatum(java.time.LocalDateTime.now());
				m1.setType(TYPE.LAAT);
				m1.setOpmerking(opmerking);
				
				addMelding(m1);
	
				return m1;
			}
			
			//Duplicate voor optionele opmerking parameter
			public Melding laatMelden() {
				
				Melding m1 = new Melding();
				m1.setDatum(java.time.LocalDateTime.now());
				m1.setType(TYPE.LAAT);
				
				addMelding(m1);
	
				return m1;
			}
			
			//Student meldt zichzelf ziek
	        public Melding ziekMelden() {
	        	
	        	Melding m1 = new Melding();
				m1.setDatum(java.time.LocalDateTime.now());
				m1.setType(TYPE.ZIEK);
				
				addMelding(m1);
				
				return m1;
				
			}
	        
	        
	        public ArrayList<Melding> getMeldingen() {
				return meldingen;
			}
			public void setMeldingen(ArrayList<Melding> meldingen) {
				this.meldingen = meldingen;
			}
	public String getStudentenNR() {
		return studentenNR;
		
	}
}
