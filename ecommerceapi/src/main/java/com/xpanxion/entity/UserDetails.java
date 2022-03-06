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
@Table(name="userdetails")
public class UserDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	int UserId;
	
	@Column(name="first_name")
	String FirstName;
	
	@Column(name="last_name")
	String LastName;
	
	@Column(name="email_id")
	String Email;
	
	@Column(name="mobile_number")
	String MobileNumber;
	
	@Column(name="password")
	String Password;
	
	@Column(name="date_of_birth")
	Date DateOfBirth;
	
	@org.springframework.data.annotation.CreatedBy
	@Column(name="created_by")
	String CreatedBy="system";
	
	@LastModifiedBy
	@Column(name="updated_by")
	String UpdatedBy="system";
	
	@CreatedDate
	@Column(name="created_on")
	Date CreatedOn = new Date();
	
	@LastModifiedDate
	@Column(name="updated_on")
	Date UpdatedOn = new Date();

	public UserDetails() {

	}

	public UserDetails(int userId, String firstName, String lastName, String email, String mobileNumber, String password,
			Date dateOfBirth, String createdBy, String updatedBy, Date createdOn, Date updatedOn) {

		UserId = userId;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		MobileNumber = mobileNumber;
		Password = password;
		DateOfBirth = dateOfBirth;
		CreatedBy = createdBy;
		UpdatedBy = updatedBy;
		CreatedOn = createdOn;
		UpdatedOn = updatedOn;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getMobileNumber() {
		return MobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Date getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
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
