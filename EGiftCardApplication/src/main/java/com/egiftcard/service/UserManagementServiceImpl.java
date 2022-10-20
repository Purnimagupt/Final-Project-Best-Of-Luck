package com.egiftcard.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.egiftcard.repository.IUserManagementServiceRepository;
import com.egiftcard.entity.User;
import com.egiftcard.exception.InvalidUserIdException;
import com.egiftcard.exception.NoDataException;
import com.egiftcard.exception.NoSuchUserException;

@Service
public class UserManagementServiceImpl implements IUserManagementService {
	@Autowired
	private IUserManagementServiceRepository userManage;

	@Override
	public List<User> getAllUsers() throws NoDataException {

		if (userManage.findAll().isEmpty()) {
			throw new NoDataException("DATA NOT AVAILABLE!");
		}
		return userManage.findAll();
	}


	@Override
	public User updateUserByUserName(User user, String userName) throws NoSuchUserException {
		User preUser = userManage.findById(userName).orElse(null);

		if (preUser == null) {
			throw new NoSuchUserException("Cannot update user as User does not exist with id " + userName);
		} else {
			
			preUser.setUserName(user.getUserName());
			preUser.setEmail(user.getEmail());
			preUser.setMobile(user.getMobile());
			preUser.setPassword(user.getPassword());
			preUser.setName(user.getName());
			return userManage.save(preUser);
		}
	}

	@Override
	public String deleteUserByUserName(String userName) throws NoDataException {
		Optional<User> user = userManage.findById(userName);
		User u1=user.get();
		if (user.isPresent()) {
			u1.setRole(null);
			userManage.deleteById(userName);
			return "Data deleted";
		} else
			throw new NoDataException("DATA NOT AVAILABLE!! Please, Insert correct id to delete data");

	}

	@Override
	public User changePassword(User user, String email) throws NoSuchUserException {
		User preUser = userManage.findByEmail(email);
		if (preUser == null) {
			throw new NoSuchUserException("user with mail id: " + email + " doesn't exists");
		}
		preUser.setPassword(user.getPassword());
		return userManage.save(preUser);
	}



	@Override
	public User getUserByEmail(String email) {
		return userManage.findByEmail(email);
	}

}
