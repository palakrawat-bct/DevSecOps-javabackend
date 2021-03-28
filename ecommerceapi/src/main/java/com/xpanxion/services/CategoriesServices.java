package com.xpanxion.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xpanxion.entity.CategoriesEntity;

import com.xpanxion.repository.CategoriesRepository;

@Service
public class CategoriesServices {
	
	@Autowired
	private CategoriesRepository repo;

	public List<CategoriesEntity> getAllCategories() {
		// TODO Auto-generated method stub
		List<CategoriesEntity> categories = new ArrayList<>();
		for(CategoriesEntity cat: repo.findAll()) {
			categories.add(cat);
		}
		return categories;
	}

}
