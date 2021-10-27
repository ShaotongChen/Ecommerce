package com.cogent.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.ecommerce.dto.User;
import com.cogent.ecommerce.repository.UserRepository;
import com.cogent.ecommerce.repository.UserRepositoryImpl;

@Service
public class UserServiceImpl implements UserService {

//	private static UserService userService;
//	private UserServiceImpl() {}
//	
//	public static UserService getInstance() {
//		if(userService==null) {
//			userService= new UserServiceImpl();
//			return userService;
//		}
//		return userService;
//	}
	@Autowired
	UserRepository userRepository;
	@Override
	public String addUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.addUser(user);
	}

	@Override
	public Optional<String> deleteUserById(String id) {
		// TODO Auto-generated method stub
		return userRepository.deleteUserById(id);
	}
	

	@Override
	public void deleteAllUser() {
		// TODO Auto-generated method stub
		userRepository.deleteAllUser();
	}

	@Override
	public Optional<User> getUserByID(String id) {
		// TODO Auto-generated method stub
		return userRepository.getUserByID(id);
	}

	@Override
	public Optional<List<User>> getUser() {
		// TODO Auto-generated method stub
		return userRepository.getUser();
	}

	@Override
	public Optional<String> upddateUser(String id, User user) {
		// TODO Auto-generated method stub
		return userRepository.upddateUser(id, user);
	}

	@Override
	public boolean isUserExist(String Id) {
		// TODO Auto-generated method stub
		return userRepository.isUserExist(Id);
	}

}
