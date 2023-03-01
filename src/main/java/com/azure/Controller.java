package com.azure;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	
	@GetMapping("/hello")
	public ResponseEntity<String> getReqeust() {
		
		return new ResponseEntity<String>("Hello World", HttpStatus.OK);
		
	}
	
}
