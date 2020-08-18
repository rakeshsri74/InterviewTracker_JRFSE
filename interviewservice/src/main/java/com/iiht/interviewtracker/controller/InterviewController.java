package com.iiht.interviewtracker.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.iiht.interviewtracker.dto.InterviewDTO;
import com.iiht.interviewtracker.dto.UserDTO;
import com.iiht.interviewtracker.service.InterviewService;

@RestController
@RequestMapping("/interview")
public class InterviewController {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
    private InterviewService interviewService;
	
	@PostMapping(value = "/addInterview")
	public ResponseEntity<InterviewDTO> addInterview(@RequestBody InterviewDTO interviewdto) {
		HttpStatus status = HttpStatus.CREATED;
    	InterviewDTO saved = interviewService.saveInterview(interviewdto);
        return new ResponseEntity<>(saved, status);
	}
	
	@GetMapping(value = "/viewAllInterviews")
	public ResponseEntity<List<InterviewDTO>> viewAllInterviews() {
		 HttpStatus httpStatus = HttpStatus.OK; 
		 List<InterviewDTO> dtolist= interviewService.findAll(); 
		 return new ResponseEntity<>(dtolist,httpStatus);
		
	}
	
	@PostMapping(value = "/updateInterview")
	public  ResponseEntity<InterviewDTO> updateInterviews(@RequestBody InterviewDTO interviewdto){
		HttpStatus status = HttpStatus.CREATED;
    	InterviewDTO saved = interviewService.saveInterview(interviewdto);
        return new ResponseEntity<>(saved, status);
	}

	
	@DeleteMapping(value = "/deleteInterview")
	public  ResponseEntity<InterviewDTO> deleteInterview(@RequestBody InterviewDTO interviewdto){
		HttpStatus status = HttpStatus.OK;
		InterviewDTO interviewDto = interviewService.delete(interviewdto);
		return new ResponseEntity<>(interviewDto,status);
	}
	

	@GetMapping("/search/interviewName/{interviewName}")
	public ResponseEntity<InterviewDTO> findByInterviewName(@PathVariable("interviewName") String  interviewName){
		HttpStatus status = HttpStatus.OK;
		InterviewDTO interviewdto=   interviewService.findInterviewByName(interviewName);
		return new ResponseEntity<>(interviewdto,status);
	}
	
	@GetMapping("/search/interviewerName/{interviewerName}")
	public ResponseEntity<InterviewDTO> findByInterviewerName(@PathVariable("interviewerName") String  interviewerName){
		HttpStatus status = HttpStatus.OK;
		InterviewDTO interviewdto=   interviewService.findByInterviewerName(interviewerName);
		return new ResponseEntity<>(interviewdto,status);
	}
	
	@GetMapping("/count")
	public ResponseEntity<Integer> countNoOfInterviews(){
		HttpStatus status = HttpStatus.OK;
		int count =   interviewService.countInterviews();
		return new ResponseEntity<>(count,status);
	}
	
	/*@GetMapping(value = "/viewAny")
	public String viewAny() {
		return restTemplate.getForObject("http://USERSSERVICE/user/viewAny",String.class);
	}*/
	
	@GetMapping("/getAllUserPosts/{toUserForInterview}")
	public ResponseEntity<List<UserDTO>> getAllHelpPosts(@PathVariable("toUserForInterview") String toUserForInterview){
				
		HttpStatus status = HttpStatus.OK;				
		ResponseEntity<UserDTO[]> response =
				restTemplate.getForEntity
				("http://USERSSERVICE/user/viewAllUsers",UserDTO[].class);
				UserDTO[] user = response.getBody();
				List<UserDTO> userList= new ArrayList<>();
				userList = Arrays.asList(user);
				List<UserDTO> usrLists = userList.stream()
							.filter(n->n.getFirstName().equals(toUserForInterview))		
							.collect(Collectors.toList());
					
				return new ResponseEntity(usrLists,status);
		}

}
