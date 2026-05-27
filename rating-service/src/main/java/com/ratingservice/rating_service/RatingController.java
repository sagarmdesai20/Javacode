package com.ratingservice.rating_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController {
	
	@GetMapping("user")
	public String getUser()
	{
		return "Thank you for using Rating Service";
	}

}
