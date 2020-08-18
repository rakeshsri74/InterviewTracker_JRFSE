package com.iiht.interviewtracker.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import lombok.Data;

@SuppressWarnings("deprecation")
@Data
public class UserDTO {

	private String userId;
	
	@Length(min = 5, max = 30)
	@NotNull
	private String firstName;
	
	@Length(min = 3, max = 25)
	@NotNull
	private String lastName;
	
	@NotNull
	@Email
	private String email;
	
	@Length(min = 3, max = 25)
	@NotNull
	private String reportingTo;
	
	@Length(min = 3, max = 25)
	@NotNull
	private String userType;
	
	@Length(min = 3, max = 25)
	@NotNull
	private String userStatus;
	
	@NotNull
	@Length(min = 10, max = 10)
	private String mobile;

}
