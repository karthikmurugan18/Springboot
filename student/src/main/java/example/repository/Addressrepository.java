package example.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import example.bean.Address;
@Repository
public interface Addressrepository extends JpaRepository<Address, Serializable> {

}
