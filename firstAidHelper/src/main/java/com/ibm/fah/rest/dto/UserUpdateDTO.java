package com.ibm.fah.rest.dto;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Object to interact using rest api.
 */
@SuppressWarnings("deprecation")
public class UserUpdateDTO {

	@NotEmpty(message = "first_name can not be empty")
    @JsonProperty("first_name")
    private String firstName;
 
    @NotEmpty(message = "last_name can not be empty")
    @JsonProperty("last_name")
    private String lastName;
    
    @JsonProperty("phone")
    private String phone;
    
    @JsonProperty("blood_type")
    private String bloodType;
    
    @JsonProperty("disability")
    private String disability;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getDisability() {
		return disability;
	}

	public void setDisability(String disability) {
		this.disability = disability;
	}
 
}