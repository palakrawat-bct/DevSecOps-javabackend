package com.xpanxion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xpanxion.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
	
	@Query(value = "SELECT * from products where product_name=?",nativeQuery = true)
	List<ProductEntity> getProductByName(String ProductName);
	
	@Query(value = "SELECT * from products where category_id=?",nativeQuery = true)
	List<ProductEntity> getProductsByCategory(int id);

}
