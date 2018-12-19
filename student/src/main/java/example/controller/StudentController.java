package example.controller;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;

import example.bean.Student;

import example.repository.Studentrepository;
import example.service.StudentService;

@RestController
public class StudentController {

		@Autowired
	    private StudentService studentService;
//	 
//	    public StudentController(StudentService studentService) {
//	        this.studentService = studentService;
//	    }
	    @Autowired
	    private Studentrepository studentrepository;
	    ObjectMapper mapper = new ObjectMapper();
	    Gson gson = new Gson();
	    @ResponseBody
	    @RequestMapping("/")
	    public String index() throws JsonGenerationException, JsonMappingException, IOException {
	        List<Student> all = studentrepository.findAll();
	        
	        String json = gson.toJson(all);
	        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
			writer.writeValue(new File("E:/testing/student/src/main/resources/json/studentlist.json"), all);
	        return json;
	    }
	    @RequestMapping("/update")
	    
	    public String updateStudent() throws JsonGenerationException, JsonMappingException, IOException{
	    	Student s=new Student();
	    	s.setId(1);
	    	s.setName("Lakshmi");
	    	studentrepository.save(s);
	    	List<Student> all = studentrepository.findAll();
	    	String json = gson.toJson(all);
	    	studentService.save(all);
	        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
			writer.writeValue(new File("E:/testing/student/src/main/resources/json/studentlist.json"), all);
	        return json;
		   	
	    }
	    @RequestMapping("/delete")
	    public String deleteStudent()throws JsonGenerationException, JsonMappingException, IOException{
	    	studentrepository.deleteByName("Karthik");
	    	List<Student> all = studentrepository.findAll();
	    	String json = gson.toJson(all);
	    	studentService.save(all);
	        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
			writer.writeValue(new File("E:/testing/student/src/main/resources/json/studentlist.json"), all);
	        return json;
	    }
	    
	}

