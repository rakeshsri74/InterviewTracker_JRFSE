package com.iiht.interviewtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages="com.iiht.interviewtracker")
@EnableMongoRepositories(basePackages ="com.iiht.interviewtracker.repository")
@EntityScan("com.iiht.interviewtracker.model")
@EnableEurekaClient
public class InterviewserviceApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		
		SpringApplication.run(InterviewserviceApplication.class, args);
		
	}
}
