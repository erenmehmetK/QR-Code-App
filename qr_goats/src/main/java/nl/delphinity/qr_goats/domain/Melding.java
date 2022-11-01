package nl.delphinity.qr_goats.domain;

import java.util.Objects;

public class Melding implements Comparable<Melding>{

		private int id;
		private String datum;
		private TYPE type;
		private String opmerking;
		private Student student;
		
		//to declare in constructor 
		enum TYPE{
			LAAT, ZIEK
	    }
	
	

		public Melding(int id, String datum, TYPE type, String opmerking, Student student) {
			this.id = id;
			this.datum = datum;
			this.type = type;
			this.opmerking = opmerking;
			this.student = student;
			
		}
		
		@Override
		public int compareTo(Melding other) {
			return id - other.id;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(id);
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Melding other = (Melding) obj;
			return Objects.equals(id, other.id);
		}
		
		

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getDatum() {
			return datum;
		}

		public void setDatum(String datum) {
			this.datum = datum;
		}

		public TYPE getType() {
			return type;
		}

		public void setType(TYPE type) {
			this.type = type;
		}

		public String getOpmerking() {
			return opmerking;
		}

		public void setOpmerking(String opmerking) {
			this.opmerking = opmerking;
		}

		public Student getStudent() {
			return student;
		}

		public void setStudent(Student student) {
			this.student = student;
		}

}