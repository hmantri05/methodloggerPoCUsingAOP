package com.himanshumantri.methodlogger;

import org.springframework.stereotype.Service;

import com.jcabi.aspects.Loggable;

@Service
public class DemoService {

	@Loggable(value = Loggable.DEBUG, prepend = true)
	public String logMessage(String message1, String message2) {
		return "message logged";
	}
}
