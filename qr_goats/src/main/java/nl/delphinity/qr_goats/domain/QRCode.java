package nl.delphinity.qr_goats.domain;
import java.util.Objects;
public class QRCode implements Comparable<QRCode>{
	private String uniekeqrcode;
	private Student studentenNR;

	
	public String getUniekeqrcode() {
		return uniekeqrcode;
	}


	public void setUniekeqrcode(String uniekeqrcode) {
		this.uniekeqrcode = uniekeqrcode;
	}


	public Student getStudentenNR() {
		return studentenNR;
	}


	public void setStudentenNR(Student studentenNR) {
		this.studentenNR = studentenNR;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(studentenNR, uniekeqrcode);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QRCode other = (QRCode) obj;
		return Objects.equals(studentenNR, other.studentenNR) && Objects.equals(uniekeqrcode, other.uniekeqrcode);
	}
	


	@Override
	public String toString() {
		return uniekeqrcode + studentenNR;
	}


	@Override
	public int compareTo(QRCode other) {
		return studentenNR.compareTo(studentenNR);
	}
	
	
	
}
