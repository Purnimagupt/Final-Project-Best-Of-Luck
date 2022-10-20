package com.egiftcard.service;

import java.util.List;

import com.egiftcard.entity.UserGiftDetails;
import com.egiftcard.exception.DuplicateUserGiftDetailsIdException;
import com.egiftcard.exception.UserGiftDetailsNotFoundException;

public interface IUserGiftDetailsAccountManagementService {
	List<UserGiftDetails> getAllUserGiftDetails();
	UserGiftDetails getUserGiftDetails(int userGiftId) throws UserGiftDetailsNotFoundException;
	UserGiftDetails addUserGiftDetails(UserGiftDetails userGiftDetails) throws DuplicateUserGiftDetailsIdException;
	UserGiftDetails updateUserGiftDetailsById(UserGiftDetails userGiftDetails,int userGiftId) throws UserGiftDetailsNotFoundException;
	String deleteUserGiftDetailsById(int userGiftId) throws UserGiftDetailsNotFoundException;
	//List<UserGiftDetails> getUserGiftOrderHistory(int id)throws UserGiftDetailsNotFoundException;
}
