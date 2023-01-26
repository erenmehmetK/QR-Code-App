package nl.delphinity.qr_goats.persistence.test.dao;


import java.util.ArrayList;
import java.util.Set;


import nl.delphinity.qr_goats.domain.Opleiding;
import nl.delphinity.qr_goats.domain.OpleidingFacade;
import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.interfaces.IOpleidingDAO;

public class TestOpleidingDAO extends GenericTestDAO<Opleiding, Integer> implements IOpleidingDAO {

	private static TestOpleidingDAO instance;
	
	ArrayList<Opleiding> opl;

	public static TestOpleidingDAO getInstance() {
		if (instance == null) {
			instance = new TestOpleidingDAO();
		}
		return instance;
	} 

	private TestOpleidingDAO() {	
		
     opl = new ArrayList<>();
     
     Opleiding o = new Opleiding();
     
     o.setId(1);
    
     opl.add(o);
     
     
	}



	@Override
	public Opleiding saveOrUpdate(Opleiding entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Opleiding entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Opleiding findById(Integer id) {
		
		for(Opleiding o : opl) {
			
			if(o.getId() == id) {
				
				return o;
			}
		}
		
		return null;
	}

	@Override
	public Set findAll() {
		return null;
	}

}
