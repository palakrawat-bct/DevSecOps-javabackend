package com.xpanxion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpanxion.entity.CategoriesEntity;
import com.xpanxion.services.CategoriesServices;

@RestController
public class CategoriesController {
	
	@Autowired
	private CategoriesServices service;
	
	@RequestMapping("/getAllCategories")
	public List<CategoriesEntity> getAllCategories(){
		return service.getAllCategories();
		
	}

}
