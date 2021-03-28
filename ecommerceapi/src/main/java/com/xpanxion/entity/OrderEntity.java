package com.xpanxion.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity {
	
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int order_id;
	
	@Column(name = "user_id")
	int user_id;
	
	@Column(name = "address_id")
	int address_id;
	
	@Column(name = "order_placed_on")
	Date order_placed_on;
	
	@Column(name = "shipped_on")
	Date shipped_onDate;
	
	@Column(name = "order_stage")
	String order_stage;
	
	@Column(name = "total_amount")
	int total_amount;
	
	@Column(name = "is_delivered")
	String is_delivered;
	
	@Column(name = "product_name")
	String product_name;
	
	@Column(name = "quantity")
	int quantity;
	
	@Column(name = "payment_mode")
	String payment_mode;
	
	@Column(name = "payment_status")
	int payment_status;
	
	@Column(name = "discount_id")
	int discount_id;
	
	@Column(name = "product_price")
	int product_price;

	public OrderEntity() {
		
	}

	public OrderEntity(int order_id, int user_id, int address_id, Date order_placed_on, Date shipped_onDate,
			String order_stage, int total_amount, String is_delivered, String product_name, int quantity,
			String payment_mode, int payment_status, int discount_id,int product_price) {
		
		this.order_id = order_id;
		this.user_id = user_id;
		this.address_id = address_id;
		this.order_placed_on = order_placed_on;
		this.shipped_onDate = shipped_onDate;
		this.order_stage = order_stage;
		this.total_amount = total_amount;
		this.is_delivered = is_delivered;
		this.product_name = product_name;
		this.quantity = quantity;
		this.payment_mode = payment_mode;
		this.payment_status = payment_status;
		this.discount_id = discount_id;
		this.product_price = product_price;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public Date getOrder_placed_on() {
		return order_placed_on;
	}

	public void setOrder_placed_on(Date order_placed_on) {
		this.order_placed_on = order_placed_on;
	}

	public Date getShipped_onDate() {
		return shipped_onDate;
	}

	public void setShipped_onDate(Date shipped_onDate) {
		this.shipped_onDate = shipped_onDate;
	}

	public String getOrder_stage() {
		return order_stage;
	}

	public void setOrder_stage(String order_stage) {
		this.order_stage = order_stage;
	}

	public int getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}

	public String getIs_delivered() {
		return is_delivered;
	}

	public void setIs_delivered(String is_delivered) {
		this.is_delivered = is_delivered;
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

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public int getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(int payment_status) {
		this.payment_status = payment_status;
	}

	public int getDiscount_id() {
		return discount_id;
	}

	public void setDiscount_id(int discount_id) {
		this.discount_id = discount_id;
	}
	
	

}
