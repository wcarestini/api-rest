package com.crud.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.emailsender.SendMail;
import com.crud.demo.entity.User;
import com.crud.demo.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository dao;
	
	public List<User> findAll(){
		return dao.findAll();
	}
	
	public User findById(Long id) {
		return dao.getOne(id);
	}
	
	public User save(User user) {
		verifyIfUserExistByEmailAndCpf(user.getEmail(), user.getCpf());
		new SendMail().sendTo(user.getEmail());
		return dao.save(user);
	}
	
	public void deleteById(Long id){
		dao.deleteById(id);
	}
	
	public User update(User user) {
		return dao.save(user);
	}
	
	public void verifyIfUserExistByEmailAndCpf(String email, String cpf) {
		if(dao.findByEmail(email) != null || dao.findByCpf(cpf) != null) {
			throw new RuntimeException("A user with this email or cpf already exist");
		}
	}

}
