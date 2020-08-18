package com.iiht.interviewtracker.utils;

import java.util.ArrayList;
import java.util.List;

import com.iiht.interviewtracker.dto.UserDTO;
import com.iiht.interviewtracker.model.User;

public class UserUtilities {

	public static List<UserDTO> convertToUserDtoList(List<User> list){
		
		List<UserDTO> dtolist = new ArrayList<UserDTO>();
				
		for(User user : list) 
					
		dtolist.add(convertToUserDto(user));
				
		return dtolist;
			
		}
			
			

		public static User convertToUser(UserDTO userdto) {
				
			User user = new User();
			
			user.setUserId(userdto.getUserId());
			user.setFirstName(userdto.getFirstName());
			user.setLastName(userdto.getLastName());
			user.setReportingTo(userdto.getReportingTo());
			user.setUserStatus(userdto.getUserStatus());
			user.setUserType(userdto.getUserType());
			user.setMobile(userdto.getMobile());
			user.setEmail(userdto.getEmail());
			
			return user;
			
		}
			
			

		public static UserDTO convertToUserDto(User user) {
				
		UserDTO userdto = new UserDTO();
		
		userdto.setUserId(user.getUserId());
		userdto.setFirstName(user.getFirstName());
		userdto.setLastName(user.getLastName());
		userdto.setReportingTo(user.getReportingTo());
		userdto.setUserStatus(user.getUserStatus());
		userdto.setUserType(user.getUserType());
		userdto.setMobile(user.getMobile());
		userdto.setEmail(user.getEmail());
		
		return userdto;
				
		}
			
			


}
