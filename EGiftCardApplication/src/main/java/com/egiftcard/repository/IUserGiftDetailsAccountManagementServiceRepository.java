package com.egiftcard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.egiftcard.entity.User;
import com.egiftcard.entity.UserGiftDetails;

//JpaRepository is a JPA (Java Persistence API) specific extension of Repository. 
//It contains the full API of CrudRepository and PagingAndSortingRepository. So it contains API for basic CRUD operations and also API for pagination and sorting.
@Repository
public interface IUserGiftDetailsAccountManagementServiceRepository extends JpaRepository<UserGiftDetails, Integer> {
	/*
	@Query("Select giftDet from user_gift_details giftDet where giftDet.user=:user")
	List<UserGiftDetails> getUserGiftOrderHistory(@Param("users") User user);
	*/
}
