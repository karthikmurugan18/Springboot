package crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import crud.service.Clientservice;
import java.util.List;
import crud.bean.Client;

@SpringBootApplication
public class ConfigApplication {

	static ObjectMapper mapper = new ObjectMapper();
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException{
		SpringApplication.run(ConfigApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(Clientservice clientService){
		return args -> {
			// read JSON and load json

		//	mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
			mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
			TypeReference<List<Client>> typeReference = new TypeReference<List<Client>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/client_info_final.json");
			try {
				List<Client> clients = mapper.readValue(inputStream,typeReference);
				clientService.save(clients);
				System.out.println("Users Saved!");
			} catch (IOException e){
				System.out.println("Unable to save users: " + e.getMessage());
			}
		//	inputStream.close();

		};
	}
}