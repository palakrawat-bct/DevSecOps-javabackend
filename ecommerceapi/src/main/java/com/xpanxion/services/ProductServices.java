package com.xpanxion.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.xpanxion.entity.ProductEntity;
import com.xpanxion.repository.ProductRepository;

@Service
public class ProductServices {
	
	@Autowired
	private ProductRepository repo;

	public List<ProductEntity> getAllProducts() {
		List<ProductEntity> products = new ArrayList<>();
		for(ProductEntity prod: repo.findAll()) {
			products.add(prod);
		}
		return products;
	}

	public List<ProductEntity> getProductByName(String productname) {
		// TODO Auto-generated method stub
		return repo.getProductByName(productname);
	}

	public List<ProductEntity> getProductsByCategory(int id) {
		// TODO Auto-generated method stub
		return repo.getProductsByCategory(id);
	}

}
