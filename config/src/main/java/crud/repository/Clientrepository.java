package crud.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crud.bean.Client;

@Repository
public interface Clientrepository extends JpaRepository<Client,Long>{
	

}
