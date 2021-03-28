package com.xpanxion.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xpanxion.entity.UserDetails;
import com.xpanxion.repository.UserActionRepository;

@Service
public class UserActionServices {
	
	@Autowired
	private UserActionRepository repo;

	public void addUser(UserDetails uservalues) {
		// TODO Auto-generated method stub
		repo.save(uservalues);
	}

	public List<UserDetails> getallUsers() {
		List<UserDetails> detailslist = new ArrayList<>();
		for(UserDetails details: repo.findAll()) {
			detailslist.add(details);
		}
		
		return detailslist;
	}

	

	public boolean login(UserDetails loginvalues) {
		if(repo.findyBymobile(loginvalues.getMobileNumber(), loginvalues.getPassword()) !=null && repo.findyBymobile(loginvalues.getMobileNumber(), loginvalues.getPassword()).size() == 1) {
			return true;
		}else {
			return false;
		}
	}

}
