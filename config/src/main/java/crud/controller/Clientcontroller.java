package crud.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;

import crud.bean.Client;
import crud.repository.Clientrepository;
import crud.service.Clientservice;

@RestController
public class Clientcontroller {
	@Autowired
	private Clientservice clientService;
	@Autowired
	private Clientrepository clientRepository;
	Gson gson = new Gson();
	@ResponseBody
	@GetMapping("/viewClients")
	public List<Client> getAllClients() throws JsonGenerationException, JsonMappingException, IOException {
		List<Client> clients=clientService.getAllClients();
		return clients;

	}
	 @PostMapping("/updateClient")
	 public void updateClients(@RequestBody Client client) throws JsonGenerationException, JsonMappingException, IOException{
		 clientService.saveOrUpdate(client);
	 }
	 @DeleteMapping("/deleteClient/{id}")
	    private void deleteClient(@PathVariable("id") int id) {
	        clientService.delete(id);
	    }
	}




