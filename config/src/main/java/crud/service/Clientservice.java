package crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
