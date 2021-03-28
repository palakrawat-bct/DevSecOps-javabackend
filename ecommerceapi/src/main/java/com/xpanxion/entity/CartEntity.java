package com.xpanxion.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class CartEntity {
	
	@Id
	@Column(name="cart_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int cart_id;
	
	@Column(name = "user_id")
	int user_id;
	
	@Column(name = "product_id")
	int product_id;
	
	@Column(name = "product_name")
	String product_name;
	
	@Column(name = "quantity")
	int quantity;
	
	@Column(name = "product_price")
	int product_price;
	
	@Column(name = "total_amount")
	int total_amount ;
	
	@Column(name = "added_on")
	Date added_on = new Date();
	
	@Column(name = "active_status")
	int active_status = 1;
	
	public CartEntity() {
		
	}
	
	public CartEntity(int cart_id, int user_id, int product_id, String product_name, int quantity, int product_price,
			int total_amount, Date added_onDate, int active_status) {
		
		this.cart_id = cart_id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.product_name = product_name;
		this.quantity = quantity;
		this.product_price = product_price;
		this.total_amount = total_amount;
		this.added_on = added_onDate;
		this.active_status = active_status;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public int getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}

	public Date getAdded_onDate() {
		return added_on;
	}

	public void setAdded_onDate(Date added_onDate) {
		this.added_on = added_onDate;
	}

	public int getActive_status() {
		return active_status;
	}

	public void setActive_status(int active_status) {
		this.active_status = active_status;
	}
	
	
	
	
	

}
