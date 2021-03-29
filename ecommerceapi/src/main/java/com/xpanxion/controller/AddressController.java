package com.xpanxion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xpanxion.entity.AddressEntity;
import com.xpanxion.services.AddressService;

@RestController
public class AddressController {

	@Autowired
	private AddressService service;
	
	@RequestMapping(method = RequestMethod.POST,value = "/addaddress")
	public void addAddress(@RequestBody AddressEntity addressdetails) {
		service.addAddress(addressdetails);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/removeaddress")
	public void removeAddress(@RequestBody AddressEntity addressid) {
		service.removeAddress(addressid);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/updatedefaultaddress")
	public void updateDefaultAddress(@RequestBody AddressEntity defaultaddressid) {
		service.updateDefaultAddress(defaultaddressid);
	}
	
	@RequestMapping("/getaddress/{id}")
	public List<AddressEntity> getUserAllAddress(@PathVariable int id){
		return service.getUserAllAddress(id);
	}

}
