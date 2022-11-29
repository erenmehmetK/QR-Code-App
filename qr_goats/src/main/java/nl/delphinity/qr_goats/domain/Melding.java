package nl.delphinity.qr_goats.domain;

import java.util.Objects;
import java.time.LocalDateTime;  


public class Melding implements Comparable<Melding>{
	
		private int id;
		private LocalDateTime datum;
		private Student student;
		
		
		public Melding() {
			
		}
		
        //Constructor  
		public Melding(int id, String opmerking, Student student) {
			this.id = id;
			this.datum = java.time.LocalDateTime.now();
			this.student = student;
			
		}
		
		
		//Returnt een nummer gebaseerd op als het object gelijk is, gebruikt voor treesets sorteren
		@Override
		public int compareTo(Melding other) {
			return datum.compareTo(other.datum);		}
		
		//Hasht de id zodat het object vergelijkbaar is	
		@Override
		public int hashCode() {
			return Objects.hash(id);
		}
		
		//Returnt een boolean gebaseerd op als het object gelijk is 
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
		
		
		
		@Override
		public String toString() {
			return "Melding [id=" + id + ", datum=" + datum
					+ ", student=" + student + "]";
		}
		
	
       
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
        
		public LocalDateTime getDatum() {
			return datum;
		}
        
		public void setDatum(LocalDateTime datum) {
			this.datum = datum;
		}

		
		
		public Student getStudent() {
			return student;
		}
		public void setStudent(Student student) {
			this.student = student;
		}
}