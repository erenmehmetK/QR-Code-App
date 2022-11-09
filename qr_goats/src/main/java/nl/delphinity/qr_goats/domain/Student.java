package nl.delphinity.qr_goats.domain;


public class Student extends Persoon {
	
	public Student(Integer id, String naam, String email, String tussenvoegsel, String achternaam) {
		super(id, naam, email, tussenvoegsel, achternaam);
	}
	public Student() {
		
	}
	
	private String studentenNR;
	private Account account;

	public String getStudentenNR() {
		return studentenNR;
	}

	public void setStudentenNR(String studentenNR) {
		this.studentenNR = studentenNR;
	}	
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	// returnt een nummer gebaseerd op als het object gelijk is, gebruikt voor treesets sorteren
	public int compareTo(Student other) {
		return studentenNR.compareTo(other.studentenNR);
	}
}

