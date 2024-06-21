package com.assignment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.assignment.payloads.UserDto;
import com.assignment.serviceClass.UserServiceClass;


@Controller
public class UserController {
	
	@Autowired
	private UserServiceClass serviceClass;
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<UserDto> list=this.serviceClass.allUsers();
		model.addAttribute("users", list);
		return "list";
	}
	
	@GetMapping("/showform")
	public String showForm(Model model)
	{
		UserDto userDto=new UserDto();
		model.addAttribute("user",userDto);
		return "adduser";
		
	}
	
   @PostMapping("/adduser")
	public String addUser(@ModelAttribute("user") UserDto user) {
	   this.serviceClass.addUser(user);
		return "redirect:/list";
	}
   
   @GetMapping("/getuser/{id}")
   public String getUser(@PathVariable int id,Model model) {
	   UserDto userDto=this.serviceClass.getUser(id);
	   model.addAttribute("user",userDto);
		UserDto updateUser=new UserDto();
	   model.addAttribute("update",updateUser);
	   return "userinformation";
   }
   
   @PostMapping("/updateuser/{id}")
   public String ipdateUser(@PathVariable int id,@ModelAttribute("update") UserDto userDto) {
	   this.serviceClass.updateUser(userDto, id);
	   
	   return "redirect:/list";
   }
   
   
   
	
	
}
