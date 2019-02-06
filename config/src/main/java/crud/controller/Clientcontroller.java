package crud.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import crud.bean.Client;
import crud.repository.Clientrepository;
import crud.service.Clientservice;

@RestController
public class Clientcontroller {
	int version=0;
	@Autowired
	private Clientservice clientService;
	@Autowired
	private Clientrepository clientRepository;
	Gson gson = new Gson();
	ObjectMapper mapper = new ObjectMapper();
	@ResponseBody
	@GetMapping("/viewClients")
	public List<Client> getAllClients() throws JsonGenerationException, JsonMappingException, IOException {
		List<Client> clients=clientService.getAllClients();
		return clients;

	}
	@RequestMapping(value="/updateClient",produces="application/json")
	//public String updateClients(@RequestBody Client client) throws JsonGenerationException, JsonMappingException, IOException{
	public JSONArray updateClients() throws JsonGenerationException, JsonMappingException, IOException, ParseException{

		// clientService.saveOrUpdate(client);
		List<Client> all = clientRepository.findAll();
		String jsonstr = gson.toJson(all);
		clientService.save(all);
		//	
		JSONObject jsonObject = null;
		JSONParser parser = new JSONParser();
		Object object = parser.parse(jsonstr);
		JSONArray jsonArray = (JSONArray) object;
		for (int i = 0; i < jsonArray.size(); i++) {

			jsonObject = (JSONObject)jsonArray.get(i);	    
			jsonObject.remove("id");
		} 
		ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
		writer.writeValue(new File("E:/sts/config/src/main/resources/json/client_info_final_"+version++ +".json"), jsonArray);


		return jsonArray;
	}
	
	@DeleteMapping("/deleteClient/{id}")
	private void deleteClient(@PathVariable("id") int id) {
		clientService.delete(id);
	}
}




