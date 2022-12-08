package nl.delphinity.qr_goats.persistence.test.dao;

import java.util.Set;
import java.util.TreeSet;

import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.interfaces.ITestStudentDAO;

public class TestStudentDAO implements ITestStudentDAO{
	
	private static TestStudentDAO instance;

	public TestStudentDAO() {
	
	}
		
	 public static TestStudentDAO getInstance() {
		 
	        if (instance == null) {
	            instance = new TestStudentDAO();
	        }
	        return instance;
	    }
	

	
    @Override
	public Student saveOrUpdate(Student entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Student entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Student> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
	
