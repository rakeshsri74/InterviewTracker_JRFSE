package com.iiht.interviewtracker.boundry;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.iiht.interviewtracker.dto.*;
import com.iiht.utils.MasterData;
import static com.iiht.utils.MasterData.*;
import static com.iiht.utils.TestUtils.boundaryTestFile;
import static com.iiht.utils.TestUtils.currentTest;
import static com.iiht.utils.TestUtils.yakshaAssert;

public class BoundryTests {

	private Validator validator;
	  
	  @BeforeEach 
	  public void setUp() { 
		  ValidatorFactory factory = Validation.buildDefaultValidatorFactory(); 
		  validator = factory.getValidator(); 
	}
	  
	   
	  @Test
	  public void testInterviewerNameLength() throws Exception {
		  
		  InterviewDTO interview = MasterData.getInterviewDto();
		  interview.setInterviewerName("Rakeshkumar");
		  Set<ConstraintViolation<InterviewDTO>> violations = validator.validate(interview);
		  yakshaAssert(currentTest(),violations.isEmpty()? true :
		  false,boundaryTestFile);
	  }
	  
	  @Test
	  public void testInterviewNameLength() throws Exception {
		  
		  InterviewDTO interview = MasterData.getInterviewDto();
		  interview.setInterviewName("DOTNET");
		  Set<ConstraintViolation<InterviewDTO>> violations = validator.validate(interview);
		  yakshaAssert(currentTest(),violations.isEmpty()? true :
		  false,boundaryTestFile);
	  }
	  
	  @Test
	  public void testUserForInterviewLength() throws Exception {
		  
		  InterviewDTO interview = MasterData.getInterviewDto();
		  interview.setUserForInterview("Satyamkumar");
		  Set<ConstraintViolation<InterviewDTO>> violations = validator.validate(interview);
		  yakshaAssert(currentTest(),violations.isEmpty()? true :
		  false,boundaryTestFile);
	  }
	  
	  @Test
	  public void testUsersSkillLength() throws Exception {
		  
		  InterviewDTO interview = MasterData.getInterviewDto();
		  interview.setUsersSkill("DOTNET");
		  Set<ConstraintViolation<InterviewDTO>> violations = validator.validate(interview);
		  yakshaAssert(currentTest(),violations.isEmpty()? true :
		  false,boundaryTestFile);
	  }
	  
	  @Test
	  public void testInterviewStatusLength() throws Exception {
		  
		  InterviewDTO interview = MasterData.getInterviewDto();
		  interview.setInterviewStatus("Approved");
		  Set<ConstraintViolation<InterviewDTO>> violations = validator.validate(interview);
		  yakshaAssert(currentTest(),violations.isEmpty()? true :
		  false,boundaryTestFile);
	  }
	  
	  @Test
	  public void testRemarksLength() throws Exception {
		  
		  InterviewDTO interview = MasterData.getInterviewDto();
		  interview.setRemarks("Candidate is through with interview");
		  Set<ConstraintViolation<InterviewDTO>> violations = validator.validate(interview);
		  yakshaAssert(currentTest(),violations.isEmpty()? true :
		  false,boundaryTestFile);
	  }
	  
	  
	  
}
