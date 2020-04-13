package com.example.kavya.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kavya.demo.deo.userrepository;
import com.example.kavya.demo.model.user;

@RestController
public class usercontroller {
	@Autowired
	private userrepository repository;

	@PostMapping("/saveuser")
    public user saveuser(@RequestBody user users) {
       return repository.save(users);
    
    }

	@GetMapping("/getAlluser")
	public List<user> getAll() {
		return repository.findAll();
	}

	@GetMapping("/getuser/{id}")
	public List<user> getuserById(@PathVariable int id) {
		return repository.findById(id);
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public String deleteUserbyid(@PathVariable int id){
		
		 repository.deleteById(id);
		 return "deleted";  
	}
	
	@PutMapping("/updateuser/{id}")
    public String updateUser(@PathVariable(value = "id") 
    		@RequestBody user userDetails)
    {
        return "updated";

    }
    }

