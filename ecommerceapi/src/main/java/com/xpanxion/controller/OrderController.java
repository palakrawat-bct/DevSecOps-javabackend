package com.xpanxion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xpanxion.entity.OrderEntity;
import com.xpanxion.services.OrderServices;

@RestController
public class OrderController {
	
	@Autowired
	private OrderServices services;
	
	 @RequestMapping(method = RequestMethod.POST,value = "/placeorder")
	 public void addOrder(@RequestBody OrderEntity orderdetails) {
		 services.addOrder(orderdetails);
	 }
	 
	 @RequestMapping("/getorder/{id}")
	 public List<OrderEntity> getOrderById(@PathVariable int id){
		 return services.getOrderById(id);
	 }

}
