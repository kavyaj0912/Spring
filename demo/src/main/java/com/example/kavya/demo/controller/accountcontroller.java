package com.example.kavya.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kavya.demo.deo.accountrepository;
import com.example.kavya.demo.model.account;
import com.example.kavya.demo.model.user;

@RestController
public class accountcontroller {
	@Autowired
	private accountrepository repository;

	@PostMapping("/saveaccount")
    public account saveaccount(@RequestBody account accounts) {
       return repository.save(accounts);
    
    }

	@GetMapping("/getAllaccount")
	public List<account> getAll() {
		return repository.findAll();
	}

	@GetMapping("/getaccount/{id}")
	public List<account> getuserById(@PathVariable int id) {
		return repository.findById(id);
	}
	
	@DeleteMapping("/deleteaccount/{id}")
	public String deleteAccountsbyid(@PathVariable int id){
		
		 repository.deleteById(id);
		 return "deleted";  
	}
	
	@PutMapping("/updateaccount/{id}")
    public String updateAccount(@PathVariable(value = "id") 
    		@RequestBody account accountDetails)
    {
        return "updated";

    }

}
