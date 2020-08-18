package com.iiht.interviewtracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "interviewmaster")
@Data
public class Interview {

	@Id
	private String interviewId;
	
	private String interviewerName;
	
	private String interviewName;
	
	private String userForInterview;
	
	private String usersSkill;
	
	private String time;
	
	private String date;
	
	private String interviewStatus;
	
	private String technicalInterviewStatus;
	
	private String remarks;
	
}
