package com.xpanxion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xpanxion.entity.UserDetails;
import com.xpanxion.services.UserActionServices;
@CrossOrigin
@RestController
@RequestMapping("/server")
public class UserActionController {
	
	@Autowired
	private UserActionServices service;
	
	@RequestMapping("/getusers")
	public List<UserDetails> getallUsers(){
		return service.getallUsers();
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value = "/registration")
	public void addUser(@RequestBody UserDetails uservalues) {
		service.addUser(uservalues);
	}
	

	@RequestMapping(method=RequestMethod.POST,value="/login")
	public boolean login(@RequestBody UserDetails loginvalues) {
		return service.login(loginvalues);
		
	}

}
