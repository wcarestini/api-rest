package com.crud.demo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.entity.User;
import com.crud.demo.service.UserService;

@RestController
@RequestMapping("v1")
public class UserEndpoint {
	
	@Autowired
	private UserService service;
	
	@GetMapping(path = "/users")
	public ResponseEntity<?> listAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<?> save(@RequestBody User user){
		return new ResponseEntity<>(service.save(user), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/users/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(path = "/users")
	public ResponseEntity<?> update(@RequestBody User user){
		service.update(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
 	
}
