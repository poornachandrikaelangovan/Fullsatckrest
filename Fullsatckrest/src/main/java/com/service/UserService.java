package com.service;

import java.util.List;

import com.model.User;

public interface UserService {

	public abstract User createUser(User user);
	 public abstract List<User> readUser();
	 public abstract User readUserById(int userId);
	 public abstract User readUserByName(String username);
	 public abstract User updateUser(User user);
	 public abstract int deleteUserById(int userId);
}
