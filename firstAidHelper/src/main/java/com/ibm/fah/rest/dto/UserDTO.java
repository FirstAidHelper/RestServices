package com.ibm.fah.rest.dto;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.fah.mongodb.models.User;

/**
 * Object to interact using rest api.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@SuppressWarnings("deprecation")
public class UserDTO {

    /* used to send database id */
    private String id;

	@NotEmpty(message = "first_name can not be empty")
    @JsonProperty("first_name")
    private String firstName;

    @NotEmpty(message = "last_name can not be empty")
    @JsonProperty("last_name")
    private String lastName;

    @Email
    @JsonProperty("email")
    private String email;

    @NotEmpty(message = "password can not be empty")
    @Size(min = 6, message = "password must be at least 6 character")
    @JsonProperty("password")
    private String password;
    
    @JsonProperty("phone")
    private String phone;
    
    @JsonProperty("blood_type")
    private String bloodType;
    
    @JsonProperty("disability")
    private String disability;

    // getter - setter

    /**
     * We are manually creating {@link UserDTO} object however there is
     * mapper available to convert to-from {@link User}.
     *
     * @param user
     * @return
     */
    public UserDTO build(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.bloodType = user.getBloodType();
        this.disability = user.getDisability();
        return this;
    }
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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