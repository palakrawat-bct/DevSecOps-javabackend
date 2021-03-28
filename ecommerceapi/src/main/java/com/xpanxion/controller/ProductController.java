package com.xpanxion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpanxion.entity.ProductEntity;
import com.xpanxion.services.ProductServices;

@RestController
public class ProductController {
	
	@Autowired
	private ProductServices service;
	
	@RequestMapping("/getallproducts")
	public List<ProductEntity> getAllProducts(){
		return service.getAllProducts();
	}
	
	@RequestMapping("/getproduct/{productname}")
	public List<ProductEntity> getProductByName(@PathVariable String productname){
		return service.getProductByName(productname);
	}
	
	@RequestMapping("/getproduct/category/{id}")
	public List<ProductEntity> getProductsByCategory(@PathVariable int id){
		return service.getProductsByCategory(id);
	}

}
