package com.himanshumantri.methodlogger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {

	@Autowired
	private DemoService service;

	@GetMapping("/logMessage")
	public String logMessage(@RequestParam String message1, @RequestParam String message2) {
		return service.logMessage(message1, message2);
	}

}
