package com.iiht.interviewtracker.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@SuppressWarnings("deprecation")
@Data
public class InterviewDTO {

	private String interviewId;
	
	@Length(min = 5, max = 30)
	@NotNull
	private String interviewerName;
	
	@Length(min = 3, max = 30)
	@NotNull
	private String interviewName;
	
	@Length(min = 5, max = 30)
	@NotNull
	private String userForInterview;
	
	@Length(min = 5, max = 30)
	@NotNull
	private String usersSkill;
	
	private String time;
	
	private String date;
	
	@Length(min = 5, max = 100)
	@NotNull
	private String interviewStatus;
	
	@Length(min = 5, max = 100)
	@NotNull
	private String technicalInterviewStatus;
	
	@Length(min = 5, max = 100)
	@NotNull
	private String remarks;

}
