package com.xpanxion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class AddressEntity {
	
	@Id
	@Column(name = "address_id")
	int address_id;
	
	@Column(name = "user_id")
	int user_id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "address_line_one")
	String address_line_one;
	
	@Column(name = "address_line_two")
	String address_line_two;
	
	@Column(name = "landmark")
	String landMark;
	
	@Column(name = "city")
	String city;
	
	@Column(name = "state")
	String state;
	
	@Column(name = "country")
	String country;
	
	@Column(name = "pincode")
	int pincode;
	
	@Column(name = "default_address")
	int default_address;

	public AddressEntity() {
		
	}

	public AddressEntity(int address_id, int user_id, String name, String address_line_one, String address_line_two,
			String landMark, String city, String state, String country, int pincode, int default_address) {
		
		this.address_id = address_id;
		this.user_id = user_id;
		this.name = name;
		this.address_line_one = address_line_one;
		this.address_line_two = address_line_two;
		this.landMark = landMark;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.default_address = default_address;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress_line_one() {
		return address_line_one;
	}

	public void setAddress_line_one(String address_line_one) {
		this.address_line_one = address_line_one;
	}

	public String getAddress_line_two() {
		return address_line_two;
	}

	public void setAddress_line_two(String address_line_two) {
		this.address_line_two = address_line_two;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public int getDefault_address() {
		return default_address;
	}

	public void setDefault_address(int default_address) {
		this.default_address = default_address;
	}
	
	

}
