package com.iiht.interviewtracker.exception;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static com.iiht.utils.TestUtils.exceptionTestFile;
import static com.iiht.utils.TestUtils.currentTest;
import static com.iiht.utils.TestUtils.yakshaAssert;
import com.iiht.interviewtracker.controller.UserController;
import com.iiht.interviewtracker.dto.UserDTO;
import com.iiht.interviewtracker.repository.UserRepository;
import com.iiht.interviewtracker.service.UserService;
import com.iiht.interviewtracker.service.UserServiceImpl;
import com.iiht.utils.MasterData;

@WebMvcTest(UserController.class)
public class TestUserException {
	
	@Autowired 
	private MockMvc mockMvc;
	  
	  @MockBean 
	  private UserService userService;
	  
	  @Test 
	  public void testAddUser() throws Exception { 
		  UserDTO userdto = new	UserDTO(); 
		  userdto.setFirstName("Rakesh");
	  when(userService.saveUser(userdto)).thenReturn(userdto); 
	  RequestBuilder
	  requestBuilder = MockMvcRequestBuilders.post("/user/addUser")
	  .content(MasterData.toJson(userdto))
	  .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON);
	  MvcResult result = mockMvc.perform(requestBuilder).andReturn(); 
	  int x = result.getResponse().getStatus(); 
	  yakshaAssert(currentTest(),x==404? true :
		  				false,exceptionTestFile); 
	  }
	  
	  @Test 
	  public void testDeleteUser() throws Exception { 
		  UserDTO userdto = new UserDTO(); 
		  userdto.setUserId("1001");
	  when(userService.saveUser(userdto)).thenReturn(userdto); 
	  RequestBuilder
	  requestBuilder = MockMvcRequestBuilders.get("/user/deleteUser")
	  .content(MasterData.toJson(userdto))
	  .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON);
	  MvcResult result = mockMvc.perform(requestBuilder).andReturn(); 
	  int x = result.getResponse().getStatus(); 
	  
	  yakshaAssert(currentTest(),x==404? true :
		  			false,exceptionTestFile); 
	  }

}
