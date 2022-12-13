package nl.delphinity.qr_goats.persistence.test.dao;

import java.util.TreeSet;

import nl.delphinity.qr_goats.domain.Opleiding;
import nl.delphinity.qr_goats.domain.OpleidingFacade;
import nl.delphinity.qr_goats.domain.Student;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;
import nl.delphinity.qr_goats.persistence.interfaces.IStudentDAO;

public class TestStudentDAO extends GenericTestDAO<Student, Integer> implements IStudentDAO{
	
	private static TestStudentDAO instance;
	private TreeSet<Student> studenten;
	

	private TestStudentDAO() {
			studenten = new TreeSet<Student>();

			for (int i = 1; i < 101; i++) {
				Student stud = new Student();
				stud.setNaam("Eren" + i);
				stud.setAchternaam("test" + i);
				stud.setTussenvoegsel("test" + i);
				stud.setId(i);
				stud.setOpleiding(OpleidingFacade.getInstance().getOpleiding());
				studenten.add(stud);
			}	
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
   	public Student findById(Integer id) {
   		for(Student s : getStudenten()) {
   			if(s.getId() == id) {
   				return s;
   			}
   		}
   		return null;
   	}

   	@Override
   	public TreeSet<Student> findAll() {
   		

   		return getStudenten();
   	}
   	
	public TreeSet<Student> getStudenten() {
		return studenten;

	}
   	
}
	
