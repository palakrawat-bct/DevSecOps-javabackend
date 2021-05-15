package com.xpanxion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xpanxion.entity.OrderEntity;
import com.xpanxion.repository.OrderRepository;

@Service
public class OrderServices {
	
	@Autowired
	private OrderRepository repo;

	public OrderEntity addOrder(OrderEntity orderdetails) {
		
		return repo.save(orderdetails);
		
	}

	public List<OrderEntity> getOrderById(int id) {
		return repo.getOrderById(id);
	}

}
