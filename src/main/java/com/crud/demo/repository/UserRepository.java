package com.crud.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.crud.demo.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
