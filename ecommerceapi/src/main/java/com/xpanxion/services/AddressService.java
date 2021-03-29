package com.xpanxion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xpanxion.entity.AddressEntity;
import com.xpanxion.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repo;

	public void addAddress(AddressEntity addressdetails) {
		repo.save(addressdetails);
		
	}

	public void removeAddress(AddressEntity addressid) {
		int addressId = addressid.getAddress_id();
		repo.deleteById(addressId);
		
	}

	public void updateDefaultAddress(AddressEntity defaultaddressid) {
		int addressId = defaultaddressid.getAddress_id();
		int userId = defaultaddressid.getUser_id();
		int defaultaddress=1;
		repo.updateDefaultAddress(defaultaddress,addressId,userId);
		//repo.save(defaultaddressid);
		
	}

	public List<AddressEntity> getUserAllAddress(int id) {
		
		return repo.getUserAllAddress(id);
	}

}
