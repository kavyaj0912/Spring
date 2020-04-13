package com.example.kavya.demo.deo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.kavya.demo.model.user;

import java.util.List;

public interface userrepository extends JpaRepository<user, Integer>{
	List<user> findById(int id);

}
