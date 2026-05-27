package com.userservice.user_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class UserController {
	
	
	@Autowired
	RestTemplate restTemplate;
	
	int retryCount=1;
	
	@GetMapping("/user")
	//@CircuitBreaker(name = "USER_RATING_SERVICE", fallbackMethod = "ratingFallback")
	@Retry(name="USERRATINGRETRY", fallbackMethod ="ratingFallback")
	public String getUser()
	{
		System.out.println("Retry Count : "+retryCount);
		retryCount++;
		ResponseEntity<String> response=restTemplate.exchange("http://localhost:8087/user", HttpMethod.GET,null,String.class);
		
		return response.getBody().toString();
		
		//return "Hello User";
	}
	

	
	public String ratingFallback(Exception e)
	{
		return "Rating service is down, please try after"+e.getMessage();
	}
}
