package com.xpanxion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xpanxion.entity.AdminEntity;
import com.xpanxion.repository.AdminRepository;

@Service
public class AdminServices {
	
	@Autowired
	private AdminRepository repo;
	
	public List<AdminEntity> getLoginDetails(int id){
		return repo.getLoginDetails(id);
		
	}

}
