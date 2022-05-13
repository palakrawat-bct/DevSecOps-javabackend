package com.xpanxion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xpanxion.entity.CartEntity;
import com.xpanxion.services.CartServices;
@CrossOrigin
@RestController
@RequestMapping("/server")
public class CartController {
	
	@Autowired
	private CartServices services;
	
	@RequestMapping(method = RequestMethod.POST , value = "/addtocart")
	public CartEntity addToCart(@RequestBody CartEntity cartdetails){
		 
		 return services.addToCart(cartdetails);
	}
	
	@RequestMapping(method = RequestMethod.PUT , value = "/updatecart")
	public void updateCart(@RequestBody CartEntity cartdetails){
		 services.updateCart(cartdetails);
	}
	
	@RequestMapping("/getcartitems/{id}")
	public List<CartEntity> getCartItems(@PathVariable int id){
		return services.getCartItems(id);
	}
	
	@CrossOrigin
	@RequestMapping( method = RequestMethod.DELETE , value ="/deletecartitem/{id}")
	public void delteCartItem(@PathVariable int id) {
		services.deleteCartItem(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/clearcart/{id}")
	public void deletewholeCart(@PathVariable int id) {
		services.deletewholeCart(id);
	}

}
