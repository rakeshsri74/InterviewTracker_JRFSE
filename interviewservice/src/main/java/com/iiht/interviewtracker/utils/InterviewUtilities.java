package com.iiht.interviewtracker.utils;

import java.util.ArrayList;
import java.util.List;

import com.iiht.interviewtracker.dto.InterviewDTO;
import com.iiht.interviewtracker.model.Interview;

public class InterviewUtilities {
	
public static List<InterviewDTO> convertToInterviewDtoList(List<Interview> list){
		
		List<InterviewDTO> dtolist = new ArrayList<InterviewDTO>();
				
		for(Interview interview : list) 
					
		dtolist.add(convertToInterviewDto(interview));
				
		return dtolist;
			
		}
			
			

		public static Interview convertToInterview(InterviewDTO interviewdto) {
				
			Interview interview = new Interview();
			
			interview.setInterviewId(interviewdto.getInterviewId());
			interview.setInterviewName(interviewdto.getInterviewName());
			interview.setInterviewerName(interviewdto.getInterviewerName());
			interview.setDate(interviewdto.getDate());
			interview.setInterviewStatus(interviewdto.getInterviewStatus());
			interview.setRemarks(interviewdto.getRemarks());
			interview.setTechnicalInterviewStatus(interviewdto.getTechnicalInterviewStatus());
			interview.setTime(interviewdto.getTime());
			interview.setUserForInterview(interviewdto.getUserForInterview());
			interview.setUsersSkill(interviewdto.getUsersSkill());
			
			return interview;
			
		}
			
			

		public static InterviewDTO convertToInterviewDto(Interview interview) {
			
			InterviewDTO interviewdto = new InterviewDTO();
			
			interviewdto.setInterviewId(interview.getInterviewId());
			interviewdto.setInterviewName(interview.getInterviewName());
			interviewdto.setInterviewerName(interview.getInterviewerName());
			interviewdto.setDate(interview.getDate());
			interviewdto.setInterviewStatus(interview.getInterviewStatus());
			interviewdto.setRemarks(interview.getRemarks());
			interviewdto.setTechnicalInterviewStatus(interview.getTechnicalInterviewStatus());
			interviewdto.setTime(interview.getTime());
			interviewdto.setUserForInterview(interview.getUserForInterview());
			interviewdto.setUsersSkill(interview.getUsersSkill());
			
			return interviewdto;
				
		}


}
