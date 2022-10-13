<<<<<<< HEAD
package nl.delphinity.qr_goats.domain;


public class Student extends Persoon {
	
	public Student(Integer id, String naam, String email, String tussenvoegsel, String achternaam) {
		super(id, naam, email, tussenvoegsel, achternaam);
		// TODO Auto-generated constructor stub
	}
	


	private String studentenNR;


	public String getStudentenNR() {
		return studentenNR;
	}

	public void setStudentenNR(String studentenNR) {
		this.studentenNR = studentenNR;
	}	
	
	
	// returnt een nummer gebaseerd op als het object gelijk is, gebruikt voor treesets sorteren

	public int compareTo(Student other) {
		
		return studentenNR.compareTo(other.studentenNR);
	}
	
	

	
	
	
}

=======
package nl.delphinity.qr_goats.domain;


public class Student extends Persoon {
	
	public Student(Integer id, String naam, String email, String tussenvoegsel, String achternaam) {
		super(id, naam, email, tussenvoegsel, achternaam);
		// TODO Auto-generated constructor stub
	}


	private String studentenNR;


	public String getStudentenNR() {
		return studentenNR;
	}

	public void setStudentenNR(String studentenNR) {
		this.studentenNR = studentenNR;
	}	
	
	
	// returnt een nummer gebaseerd op als het object gelijk is, gebruikt voor treesets sorteren

	public int compareTo(Student other) {
		
		return studentenNR.compareTo(other.studentenNR);
	}
}

>>>>>>> 8fdf653ae8574f492688d408700e2dae700092e4
