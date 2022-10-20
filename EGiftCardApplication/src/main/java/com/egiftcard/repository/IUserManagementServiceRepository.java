package com.egiftcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egiftcard.entity.User;
@Repository
public interface IUserManagementServiceRepository extends JpaRepository<User, String>{
	public User findByEmail(String email);
	public User findByUserName(String userName);
}
