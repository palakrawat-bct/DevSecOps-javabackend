package com.xpanxion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class ProductEntity {
	
	@Id
	@Column(name="product_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int ProductId;
	
	@Column(name="product_name")
	String ProductName;
	
	@Column(name="product_description")
	String ProductDescription;
	
	@Column(name = "price")
	int Price;
	
	@Column(name = "stock")
	String Stock;
	
	@Column(name = "product_image")
	String Image;
	
	@Column(name = "category_id")
	int CategoryId;
	
	public ProductEntity() {
		
	}
	public ProductEntity(int productId, String productName, String productDescription, int price, String stock,
			String image, int categoryId) {
		
		ProductId = productId;
		ProductName = productName;
		ProductDescription = productDescription;
		Price = price;
		Stock = stock;
		Image = image;
		CategoryId = categoryId;
	}
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getProductDescription() {
		return ProductDescription;
	}
	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public String getStock() {
		return Stock;
	}
	public void setStock(String stock) {
		Stock = stock;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public int getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}
	

}
