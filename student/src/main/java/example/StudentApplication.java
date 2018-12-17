package example;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import example.bean.Student;
import example.service.StudentService;

import java.util.List;
@SpringBootApplication
public class StudentApplication  {
	static ObjectMapper mapper = new ObjectMapper();
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException
	{
		SpringApplication.run(StudentApplication.class, args);
		
	}



@Bean
CommandLineRunner runner(StudentService userService){
    return args -> {
		// read JSON and load json
		
		//mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		TypeReference<List<Student>> typeReference = new TypeReference<List<Student>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/studentlist.json");
		try {
			List<Student> students = mapper.readValue(inputStream,typeReference);
			userService.save(students);
			System.out.println("Users Saved!");
		} catch (IOException e){
			System.out.println("Unable to save users: " + e.getMessage());
		}
		
    };
}
}