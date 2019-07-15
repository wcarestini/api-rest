package com.crud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
	User findByCpf(String cpf);
}
