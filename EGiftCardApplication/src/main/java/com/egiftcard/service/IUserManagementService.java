package com.egiftcard.service;
import java.util.List;


import com.egiftcard.entity.User;
import com.egiftcard.exception.InvalidUserIdException;
import com.egiftcard.exception.NoDataException;
import com.egiftcard.exception.NoSuchUserException;

public interface IUserManagementService {
	List<User> getAllUsers()throws NoDataException ;
//	User getUserById(int userId) throws NoSuchUserException;
	//User registerUser(User user) throws InvalidUserIdException;
	String deleteUserByUserName(String userName)throws NoDataException;
	User updateUserByUserName(User user, String userName)throws NoSuchUserException;
	User changePassword(User user,String email) throws NoSuchUserException;
//User searchByFirstName(String firstName);
	User getUserByEmail(String email);
}
