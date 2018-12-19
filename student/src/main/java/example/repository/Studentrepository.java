package example.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import example.bean.Student;
@Repository
	public interface Studentrepository extends JpaRepository<Student, Serializable> {
	@Modifying
    @Transactional
	void deleteByName(String name);

	}

