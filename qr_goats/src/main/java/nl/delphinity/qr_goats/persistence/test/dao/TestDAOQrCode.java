package nl.delphinity.qr_goats.persistence.test.dao;
import java.util.Set;
import nl.delphinity.qr_goats.domain.QRCode;
import nl.delphinity.qr_goats.persistence.interfaces.IQRCodeDAO;
public class TestDAOQrCode implements IQRCodeDAO {
	
	private static TestDAOQrCode instance;
	
	public static TestDAOQrCode getInstance() {
		if (instance == null) {
			instance = new TestDAOQrCode();
		}
		return instance;
	}
	
	@Override
	public QRCode saveOrUpdate(QRCode entity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(QRCode entity) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public QRCode findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Set<QRCode> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}