package com.xpanxion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xpanxion.entity.CartEntity;


@Repository
public interface CartRepository extends JpaRepository<CartEntity, Integer> {
	
	@Query(value = "SELECT * from cart where user_id=? ",nativeQuery = true)
	List<CartEntity> getCartItems(int id);
	
	@Modifying
	@Query(value = "UPDATE cart set quantity=? where cart_id=? ",nativeQuery = true)
	List<CartEntity> updateCart(int quantity,int cart_id);
	
	@Transactional
	@Modifying      // to mark delete or update query
    @Query(value = "DELETE FROM cart  WHERE user_id = ?",nativeQuery = true)       // it will delete all the record with specific name
    int deletewholeCart(int id);

}
