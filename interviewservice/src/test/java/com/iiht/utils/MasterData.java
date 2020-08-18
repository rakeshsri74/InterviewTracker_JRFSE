package com.iiht.utils;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iiht.interviewtracker.dto.InterviewDTO;
import com.iiht.interviewtracker.model.Interview;

public class MasterData {

	
	public static InterviewDTO getInterviewDto() {
		InterviewDTO interviewdto = new InterviewDTO();
		
		interviewdto.setInterviewId("1");
		interviewdto.setInterviewName("Java");
		interviewdto.setInterviewerName("Satyam");
		interviewdto.setDate("12/12/2019");
		interviewdto.setInterviewStatus("Pass");
		interviewdto.setRemarks("Candidate got selected");
		interviewdto.setTechnicalInterviewStatus("Selected");
		interviewdto.setTime("1:12");
		interviewdto.setUserForInterview("Rakesh");
		interviewdto.setUsersSkill("Java");
		
		return interviewdto;
	}
	
	public static Interview getInterview() {
		Interview interview = new Interview();
		
		interview.setInterviewId("1");
		interview.setInterviewName("Java");
		interview.setInterviewerName("Satyam");
		interview.setDate("12/12/2019");
		interview.setInterviewStatus("Pass");
		interview.setRemarks("Candidate got selected");
		interview.setTechnicalInterviewStatus("Selected");
		interview.setTime("1:12");
		interview.setUserForInterview("Rakesh");
		interview.setUsersSkill("Java");
		
		return interview;
		
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
