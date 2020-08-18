package com.iiht.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class InterviewsEurekaServer {

	public static void main(String[] args) {
		SpringApplication.run(InterviewsEurekaServer.class, args);

	}

}
