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
	  public void testFirstNameLength() throws Exception { 
		  UserDTO user = MasterData.getUserDto(); 
		  user.setFirstName("Rakeshkumar");
			  Set<ConstraintViolation<UserDTO>> violations = validator.validate(user);
			  yakshaAssert(currentTest(),violations.isEmpty()? true :
			  false,boundaryTestFile); 
		}
			  
			  
	  @Test 
	  public void testLastNameLength() throws Exception { 
		  UserDTO user = MasterData.getUserDto(); 
		  user.setLastName("Srivastava");
			  Set<ConstraintViolation<UserDTO>> violations = validator.validate(user);
			  yakshaAssert(currentTest(),violations.isEmpty()? true :
			  false,boundaryTestFile);  
	 }
			  
			  
	  @Test 
	  public void testReportingToLength() throws Exception { 
		  UserDTO user = MasterData.getUserDto(); 
		  user.setReportingTo("Satyamkumar");
			  Set<ConstraintViolation<UserDTO>> violations = validator.validate(user);
			  yakshaAssert(currentTest(),violations.isEmpty()? true :
			  false,boundaryTestFile);  
	 }
	  
	 	  
	  
}
