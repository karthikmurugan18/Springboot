package crud.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import crud.bean.Client;

@Repository
@Transactional
public interface Clientrepository extends JpaRepository<Client,Long>{
	
	
	
	//void deleteByName(String client_name);

	}


