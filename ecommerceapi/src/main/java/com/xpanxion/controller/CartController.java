package com.xpanxion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xpanxion.entity.CartEntity;
import com.xpanxion.services.CartServices;

@RestController
public class CartController {
	
	@Autowired
	private CartServices services;
	
	@RequestMapping(method = RequestMethod.POST , value = "/addtocart")
	public void addToCart(@RequestBody CartEntity cartdetails){
		 services.addToCart(cartdetails);
	}
	
	@RequestMapping(method = RequestMethod.PUT , value = "/updatecart")
	public void updateCart(@RequestBody CartEntity cartdetails){
		 services.updateCart(cartdetails);
	}
	
	@RequestMapping("/getcartitems/{id}")
	public List<CartEntity> getCartItems(@PathVariable int id){
		return services.getCartItems(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE , value = "/deletecartitem")
	public void delteCartItem(@RequestBody CartEntity cartid) {
		services.deleteCartItem(cartid);
	}

}
