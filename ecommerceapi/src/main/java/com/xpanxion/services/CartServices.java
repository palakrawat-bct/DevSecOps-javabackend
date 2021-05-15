package com.xpanxion.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xpanxion.entity.CartEntity;

import com.xpanxion.repository.CartRepository;

@Service
public class CartServices {
	
	@Autowired
	private CartRepository repo;

	public CartEntity addToCart(CartEntity cartdetails) {
		// TODO Auto-generated method stub
		cartdetails.setTotal_amount(cartdetails.getQuantity()*cartdetails.getProduct_price());
		
		return repo.save(cartdetails);
	}

	public List<CartEntity> getCartItems(int id) {
		return repo.getCartItems(id);
	}

	public void updateCart(CartEntity cartdetails) {
		// TODO Auto-generated method stub
		cartdetails.setTotal_amount(cartdetails.getQuantity()*cartdetails.getProduct_price());
		repo.save(cartdetails);
		/*int cart_id = cartdetails.getCart_id();
		int quantity = cartdetails.getQuantity();
		repo.updateCart(quantity, cart_id);*/
	}

	public void deleteCartItem(int cartid) {
		// TODO Auto-generated method stub
		
		repo.deleteById(cartid);
	}

	public void deletewholeCart(int id) {
		// TODO Auto-generated method stub
		repo.deletewholeCart(id);
		
	}

	
	

}
