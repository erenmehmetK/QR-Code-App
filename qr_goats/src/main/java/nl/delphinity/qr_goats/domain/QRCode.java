package nl.delphinity.qr_goats.domain;
import java.util.Objects;
public class QRCode {
	private int activeSince;
	public int getActiveSince() {
		return activeSince;
	}
	public void setActiveSince(int activeSince) {
		this.activeSince = activeSince;
	}
	@Override
	public int hashCode() {
		return Objects.hash(activeSince);
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
		return activeSince == other.activeSince;
	}
	@Override
	public String toString() {
		return "QRCode [activeSince=" + activeSince + "]";
	}
}