package com.iiht.interviewtracker.functional;

import static com.iiht.utils.MasterData.toJson;
import static com.iiht.utils.TestUtils.businessTestFile;
import static com.iiht.utils.TestUtils.currentTest;
import static com.iiht.utils.TestUtils.yakshaAssert;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.iiht.interviewtracker.controller.UserController;
import com.iiht.interviewtracker.dto.UserDTO;
import com.iiht.interviewtracker.service.UserService;
import com.iiht.utils.MasterData;

@WebMvcTest(UserController.class)
//@RunWith(SpringRunner.class)
public class UserControllerTest {

	@Autowired 
	private MockMvc mockMvc;
	  
	@MockBean 
	private UserService userService;
	
	@Test 
	void testViewAllUsers() throws Exception {
		  
		  List<UserDTO> list = new ArrayList<UserDTO>();
		  list.add(MasterData.getUserDto());
		  Mockito.when(userService.findAll()).thenReturn(list);
		  
		  RequestBuilder requestBuilder =
		  MockMvcRequestBuilders.get("/user/viewAllUsers")
		  .content(MasterData.asJsonString(MasterData.getUserDto()))
		  .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON);
		  
		  MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		  yakshaAssert(currentTest(), (result.getResponse().getStatus() ==
		  HttpStatus.OK.value() ? "true" : "false"), businessTestFile);
		  
		  
		  }
	  
	@Test 
	void testAddUser() throws Exception { 
		UserDTO userdto =
			  MasterData.getUserDto();
			  Mockito.when(userService.saveUser(userdto)).thenReturn(userdto);
			  
			  RequestBuilder requestBuilder =
			  MockMvcRequestBuilders.post("/user/addUser")
			  .content(MasterData.asJsonString(userdto))
			  .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON);
			  
			  MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			  
			  yakshaAssert(currentTest(),result.getResponse().getStatus()==200? true :
			  false,businessTestFile);
			  
			  }
	
	@Test 
	void testDeleteUser() throws Exception { 
		UserDTO userdto =
			  MasterData.getUserDto();
			  Mockito.when(userService.delete(userdto)).thenReturn(userdto);
			  
			  RequestBuilder requestBuilder =
			  MockMvcRequestBuilders.post("/user/deleteUser")
			  .content(MasterData.asJsonString(userdto))
			  .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON);
			  
			  MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			  yakshaAssert(currentTest(),result.getResponse().getStatus()==200? true :
			  false,businessTestFile);
			  
			  }
}
