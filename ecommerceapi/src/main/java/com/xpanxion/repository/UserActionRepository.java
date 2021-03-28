package com.xpanxion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.xpanxion.entity.UserDetails;

public interface UserActionRepository extends JpaRepository<UserDetails, Integer> {

	@Query(value = "SELECT * from UserDetails where mobile_number=? and user_password=?",nativeQuery = true)
	List<UserDetails> findyBymobile(String MobileNumber,String password);
}
