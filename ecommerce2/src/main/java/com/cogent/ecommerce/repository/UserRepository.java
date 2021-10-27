package com.cogent.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import com.cogent.ecommerce.dto.User;


public interface UserRepository {
	public String addUser(User user);
	public Optional<String> deleteUserById(String id) ;
	public void deleteAllUser();
	public Optional<User> getUserByID(String id) ;
	public Optional<List<User>> getUser();
	public Optional<String> upddateUser(String id, User user) ;
	public boolean isUserExist(String Id);
}
