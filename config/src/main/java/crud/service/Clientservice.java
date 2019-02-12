package crud.service;

import java.io.InputStream;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


import crud.bean.Client;
import crud.repository.Clientrepository;

@Service
public class Clientservice {
	@Autowired
	Clientrepository clientRepository;

    public Iterable<Client> list() {
        return clientRepository.findAll();
        
    }
    public Iterable<Client> save(List<Client> clients) {
    	
        return clientRepository.saveAll(clients);
    }
	public Clientservice() {
		super();
		// TODO Auto-generated constructor stub
	}
	 public List<Client> getAllClients() {
	        List<Client> clients = new ArrayList<Client>();
	        clientRepository.findAll().forEach(client -> clients.add(client));
	        return clients;
	    }
	 

	    public Client getClientById(int id) {
	        return clientRepository.findById((long) id).get();
	    }

	    public void saveOrUpdate(Client client) {
	        clientRepository.save(client);
	    }

	    public void delete(int id) {
	        clientRepository.deleteById((long) id);
	    }

}
