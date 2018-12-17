package example.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import example.bean.Student;
import example.repository.Studentrepository;
@Service
public class StudentService {
		@Autowired 
	    Studentrepository studentRepository;
	 
	    public StudentService(Studentrepository studentRepository) {
	        this.studentRepository = studentRepository;
	    }
	 
	    public Iterable<Student> list() {
	        return studentRepository.findAll();
	    }
	 
//	    public Student save(Student student) {
//	        return studentRepository.save(student);
//	    }
	    

	    public Iterable<Student> save(List<Student> students) {
	    	
	        return studentRepository.save(students);
	    }

		public StudentService() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
			@Modifying
			@Query(value = "update Students s set s.name = ? where s.id = ?", 
			  nativeQuery = true)
			public boolean updateStudent(String name,int id)
			{
				return true;
			}
	    }
	 
	

