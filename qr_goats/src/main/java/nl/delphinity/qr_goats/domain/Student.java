package nl.delphinity.qr_goats.domain;

import java.util.Objects;

import javax.print.attribute.standard.MediaSize.Other;

public class Student extends Persoon {
	
	private String studentenNR;


	public String getStudentenNR() {
		return studentenNR;
	}

	public void setStudentenNR(String studentenNR) {
		this.studentenNR = studentenNR;
	}	
	
	
	@Override
	public int compareTo(Student other) {
		
		return studentenNR.compareTo(other.studentenNR);
	}
}

