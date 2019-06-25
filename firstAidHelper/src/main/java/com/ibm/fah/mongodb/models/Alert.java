package com.ibm.fah.mongodb.models;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "alerts")
public class Alert {

    @Id
    public String id;

    @Field("user_id")
    @NotEmpty(message = "user_id can not be empty.")
    @Size(max = 100, message = "user_id can not be more than 100 characters.")
    private String userId;
 
    @Field("location")
    @NotEmpty(message = "location can not be empty.")
    @Size(max = 1000, message = "location can not be more than 100 characters.")
    private String location;
 
    @Field("alert_date")
    private Long alertDate = (new Date().getTime())/ 1000;

    public Alert() { }

    public Alert(String userId, String location) {
        this.userId = userId;
        this.location = location;
    }

	@Override
    public String toString() {
        return "Alert{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", location='" + location + '\'' +
                ", alertDate='" + alertDate + '\'' +
                '}';
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getAlertDate() {
		return alertDate;
	}

	public void setAlertDate(Long alertDate) {
		this.alertDate = alertDate;
	}

}
