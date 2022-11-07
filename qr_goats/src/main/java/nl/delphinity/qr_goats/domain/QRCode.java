package nl.delphinity.qr_goats.domain;
import java.util.Objects;
public class QRCode implements Comparable<QRCode>{
	private String qrcode;
	private Student studentenNR;
	public String getQrcode() {
		return qrcode;
	}
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	@Override
	public int hashCode() {
		return Objects.hash(qrcode);
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
		return Objects.equals(qrcode, other.qrcode);
	}
	@Override
	public String toString() {
		return qrcode;
	}
	
	@Override
	public int compareTo(QRCode other) {
		return studentenNR.compareTo(studentenNR);
	}
	
	
	
}
