package nl.delphinity.qr_goats.domain;

import java.util.ArrayList;
import java.util.Set;



public class Student extends Persoon {
	
	public Student(Integer id, String naam, String email, String tussenvoegsel, String achternaam) {
//		super(id, naam, email, tussenvoegsel, achternaam);
		// TODO Auto-generated constructor stub
	}
	
	private String studentenNR;
	private QRCode qrCode;
	
	public QRCode getQrCode() {
		return qrCode;
	}

	public void setQrCode(QRCode qrCode) {
		this.qrCode = qrCode;
	}


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

