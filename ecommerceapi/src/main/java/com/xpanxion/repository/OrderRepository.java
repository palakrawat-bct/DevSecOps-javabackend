package com.xpanxion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xpanxion.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
	
	@Query(value = "SELECT * from orders where user_id=? ",nativeQuery = true)
	List<OrderEntity> getOrderById(int id);

}
