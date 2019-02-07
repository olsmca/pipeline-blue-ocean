package com.smith.jenkins.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JenkinsController {

    @GetMapping("/")
	public String estadoServicio() {
		System.out.println("Server is running ...");
		return "Server is running ...";
	}
}