package com.iiht.utils;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iiht.interviewtracker.dto.UserDTO;
import com.iiht.interviewtracker.model.User;

public class MasterData {

	public static UserDTO getUserDto() {
		UserDTO userdto = new UserDTO();
		
		userdto.setUserId("1");
		userdto.setFirstName("Rakesh");
		userdto.setLastName("Srivastava");
		userdto.setReportingTo("Sandeep");
		userdto.setUserStatus("Active");
		userdto.setUserType("Admin");
		userdto.setMobile("7612398345");
		userdto.setEmail("yaksha@iiht.com");
		
		return userdto;
	}
	
	public static User getUser() {
		User user = new User();
		
		user.setUserId("1");
		user.setFirstName("Rakesh");
		user.setLastName("Srivastava");
		user.setReportingTo("Sandeep");
		user.setUserStatus("Active");
		user.setUserType("Admin");
		user.setMobile("7612398345");
		user.setEmail("yaksha@iiht.com");
		
		return user;
	}
	
	
	
	public static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public static byte[] toJson(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }
}
