package com.xpanxion.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "categories")
public class CategoriesEntity {
	
	@Id
	@Column(name="category_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int CategoryId;
	
	@Column(name="category_name")
	String CategoryName;
	
	@Column(name="category_image")
	String CategoryImage;
	
	@Column(name="category_description")
	String CategoryDescription;
	
	@org.springframework.data.annotation.CreatedBy
	@Column(name="created_by")
	String CreatedBy;
	
	@LastModifiedBy
	@Column(name="updated_by")
	String UpdatedBy;
	
	@CreatedDate
	@Column(name="created_on")
	Date CreatedOn = new Date();
	
	@LastModifiedDate
	@Column(name="updated_on")
	Date UpdatedOn = new Date();

	public CategoriesEntity() {
		
	}

	public CategoriesEntity(int categoryId, String categoryName, String categoryImage, String categoryDescription,
			String createdBy, String updatedBy, Date createdOn, Date updatedOn) {
		
		CategoryId = categoryId;
		CategoryName = categoryName;
		CategoryImage = categoryImage;
		CategoryDescription = categoryDescription;
		CreatedBy = createdBy;
		UpdatedBy = updatedBy;
		CreatedOn = createdOn;
		UpdatedOn = updatedOn;
	}

	public int getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public String getCategoryImage() {
		return CategoryImage;
	}

	public void setCategoryImage(String categoryImage) {
		CategoryImage = categoryImage;
	}

	public String getCategoryDescription() {
		return CategoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		CategoryDescription = categoryDescription;
	}

	public String getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}

	public String getUpdatedBy() {
		return UpdatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		UpdatedBy = updatedBy;
	}

	public Date getCreatedOn() {
		return CreatedOn;
	}

	public void setCreatedOn(Date createdOn) {
		CreatedOn = createdOn;
	}

	public Date getUpdatedOn() {
		return UpdatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		UpdatedOn = updatedOn;
	}
	
	

}
