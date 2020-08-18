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
import com.iiht.interviewtracker.controller.InterviewController;
import com.iiht.interviewtracker.dto.InterviewDTO;
import com.iiht.interviewtracker.repository.InterviewRepository;
import com.iiht.interviewtracker.service.InterviewService;
import com.iiht.interviewtracker.service.InterviewServiceImpl;
import com.iiht.utils.MasterData;

@WebMvcTest(InterviewController.class)
public class TestInterviewException {

	@Autowired 
	private MockMvc mockMvc;
	  
	  @MockBean 
	  private InterviewService interviewService;
	  
	  @Test 
	  public void testAddInterview() throws Exception { 
		  InterviewDTO interviewdto = new InterviewDTO(); 
		  interviewdto.setInterviewName("Java");
	  when(interviewService.saveInterview(interviewdto)).thenReturn(interviewdto); 
	  RequestBuilder
	  requestBuilder = MockMvcRequestBuilders.post("/interview/addInterview")
	  .content(MasterData.toJson(interviewdto))
	  .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON);
	  MvcResult result = mockMvc.perform(requestBuilder).andReturn(); 
	  int x = result.getResponse().getStatus(); 
	  yakshaAssert(currentTest(),x==404? true :
		  				false,exceptionTestFile); 
	  }
	  
	  @Test 
	  public void testDeleteInterview() throws Exception { 
		  InterviewDTO interviewdto = new InterviewDTO(); 
		  interviewdto.setInterviewId("1001");
	  when(interviewService.saveInterview(interviewdto)).thenReturn(interviewdto); 
	  RequestBuilder
	  requestBuilder = MockMvcRequestBuilders.get("/interview/deleteInterview")
	  .content(MasterData.toJson(interviewdto))
	  .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON);
	  MvcResult result = mockMvc.perform(requestBuilder).andReturn(); 
	  int x = result.getResponse().getStatus(); 
	  
	  yakshaAssert(currentTest(),x==404? true :
		  			false,exceptionTestFile); 
	  }

}
