package com.egiftcard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.egiftcard.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

}
