package com.example.kavya.demo.deo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.example.kavya.demo.model.account;

public interface accountrepository extends JpaRepository<account, Integer>{
	List<account> findById(int id);
	

}
