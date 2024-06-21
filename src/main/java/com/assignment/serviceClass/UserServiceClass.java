package com.assignment.serviceClass;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.entity.User;
import com.assignment.exceptions.NotFound;
import com.assignment.payloads.UserDto;
import com.assignment.repository.UserRepo;
import com.assignment.service.UserService;

@Service
public class UserServiceClass implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public UserDto addUser(UserDto user) {
		
		User saveUser=this.mapper.map(user, User.class);
		return this.mapper.map(this.userRepo.save(saveUser), UserDto.class);
				
	}

	@Override
	public List<UserDto> allUsers() {
		
		List<User> list=this.userRepo.findAll();
		List<UserDto> dtoslist=list.stream().map((obj)->this.mapper.map(obj, UserDto.class)).toList();
		return dtoslist;
	}

	@Override
	public UserDto updateUser(UserDto user,Integer id) {
		User getUser=this.userRepo.findById(id).orElseThrow(()->new NotFound(false));
		
		if(!getUser.isEnabled()) {
			return null;
		}
		
		getUser.setFname(user.getFname());
		getUser.setLastname(user.getLastname());
		getUser.setPhone(user.getPhone());
		getUser.setEnabled(user.isEnabled());
		return this.mapper.map(this.userRepo.save(getUser), UserDto.class);
	}

	@Override
	public UserDto getUser(Integer id) {
		User getUser=this.userRepo.findById(id).orElseThrow(()->new NotFound(false));
		
		return this.mapper.map(this.userRepo.save(getUser), UserDto.class);
	}

}