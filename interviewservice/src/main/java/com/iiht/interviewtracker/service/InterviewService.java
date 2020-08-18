package com.iiht.interviewtracker.service;

import java.util.List;

import com.iiht.interviewtracker.dto.InterviewDTO;

public interface InterviewService {

	public InterviewDTO saveInterview(InterviewDTO interviewDTO);
	List<InterviewDTO> findAll();
	public InterviewDTO updateInterview(InterviewDTO interviewDTO);
	public InterviewDTO delete(InterviewDTO interviewdto);
	public InterviewDTO findInterviewByName(String interviewName);
	public InterviewDTO findByInterviewerName(String interviewerName);
	public int countInterviews();
}
