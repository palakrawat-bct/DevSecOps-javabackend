package com.xpanxion.repository;

import java.lang.annotation.Repeatable;
import java.util.List;

import org.hibernate.engine.spi.ExecuteUpdateResultCheckStyle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xpanxion.entity.AddressEntity;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {

	@Transactional(readOnly = false)
	@Modifying
	@Query(value = "UPDATE address s set s.default_address=?1 where s.address_id=?2 and s.user_id=?3",nativeQuery = true)

	List<AddressEntity> updateDefaultAddress( int defaultaddress, int address_id, int user_id);
	
	@Query(value = "Select * from address where user_id=?",nativeQuery = true)
	List<AddressEntity> getUserAllAddress( int user_id);

}
