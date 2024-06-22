package com.assignment.service;

import java.util.List;

import com.assignment.payloads.UserDto;

public interface UserService {
	
	
	UserDto addUser(UserDto user);
	List<UserDto> allUsers();
	UserDto updateUser(UserDto user,Integer id);
	
	UserDto getUser(Integer id);
	
	void statusUpdate(boolean status,Integer id);
	

}
