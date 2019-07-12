package com.crud.demo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.emailsender.SendMail;
import com.crud.demo.entity.User;
import com.crud.demo.repository.UserRepository;

@RestController
@RequestMapping("v1")
public class UserEndpoint {
	@Autowired
	private UserRepository dao;
	
	@GetMapping(path = "/users")
	public ResponseEntity<?> listAll() {
		return new ResponseEntity<>(dao.findAll(), HttpStatus.OK);
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<User> save(@RequestBody User user){
		new SendMail().sendTo(user.getEmail());
		return new ResponseEntity<>(dao.save(user), HttpStatus.CREATED);
	}
	
	
}
