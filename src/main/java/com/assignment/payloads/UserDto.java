package com.assignment.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private Integer id;
	private String fname;
	private String lastname;
	private String phone;
	private  boolean enabled;
	

}
