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
	public ResponseEntity<?> save(@RequestBody User user){
		verifyIfUserExistByEmailAndCpf(user.getEmail(), user.getCpf());
		new SendMail().sendTo(user.getEmail());
		return new ResponseEntity<>(dao.save(user), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/users/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		dao.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(path = "/users")
	public ResponseEntity<?> update(@RequestBody User user){
		dao.save(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
 	
	public void verifyIfUserExistByEmailAndCpf(String email, String cpf) {
		if(dao.findByEmail(email) != null || dao.findByCpf(cpf) != null) {
			throw new RuntimeException("A user with this email or cpf already exist");
		}
	}
	
}
