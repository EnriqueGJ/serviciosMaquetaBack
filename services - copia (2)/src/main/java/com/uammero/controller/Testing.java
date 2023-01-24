package com.uammero.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Testing {
	
	@GetMapping({"/forUser"})
	public String forUser(){
        return "This URL is only accessible to the user";
    }
}
