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

import com.iiht.interviewtracker.controller.InterviewController;
import com.iiht.interviewtracker.dto.InterviewDTO;
import com.iiht.interviewtracker.service.InterviewService;
import com.iiht.utils.MasterData;

@WebMvcTest(InterviewController.class)
//@RunWith(SpringRunner.class)
public class InterviewControllerTest {
	
	@Autowired 
	private MockMvc mockMvc;
	  
	@MockBean 
	private InterviewService interviewService;
	
	@Test 
	void testViewAllInterviews() throws Exception {
		  
		  List<InterviewDTO> list = new ArrayList<InterviewDTO>();
		  list.add(MasterData.getInterviewDto());
		  Mockito.when(interviewService.findAll()).thenReturn(list);
		  
		  RequestBuilder requestBuilder =
		  MockMvcRequestBuilders.get("/interview/viewAllInterviews")
		  .content(MasterData.asJsonString(MasterData.getInterviewDto()))
		  .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON);
		  
		  MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		  yakshaAssert(currentTest(), (result.getResponse().getStatus() ==
		  HttpStatus.OK.value() ? "true" : "false"), businessTestFile);
		  
		  
		  }
	  
	@Test 
	void testAddInterview() throws Exception { 
		InterviewDTO interviewdto =
			  MasterData.getInterviewDto();
			  Mockito.when(interviewService.saveInterview(interviewdto)).thenReturn(interviewdto);
			  
			  RequestBuilder requestBuilder =
			  MockMvcRequestBuilders.post("/interview/addInterview")
			  .content(MasterData.asJsonString(interviewdto))
			  .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON);
			  
			  MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			  
			  yakshaAssert(currentTest(),result.getResponse().getStatus()==200? true :
			  false,businessTestFile);
			  
			  }
	
	@Test 
	void testDeleteInterview() throws Exception { 
		InterviewDTO interviewdto =
			  MasterData.getInterviewDto();
			  Mockito.when(interviewService.delete(interviewdto)).thenReturn(interviewdto);
			  
			  RequestBuilder requestBuilder =
			  MockMvcRequestBuilders.post("/interview/deleteInterview")
			  .content(MasterData.asJsonString(interviewdto))
			  .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON);
			  
			  MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			  yakshaAssert(currentTest(),result.getResponse().getStatus()==200? true :
			  false,businessTestFile);
			  
			  }


}
