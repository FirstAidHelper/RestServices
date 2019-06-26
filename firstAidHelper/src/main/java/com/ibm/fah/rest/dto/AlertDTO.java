package com.ibm.fah.rest.dto;

import java.text.FieldPosition;
import java.text.SimpleDateFormat;

import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.fah.mongodb.models.Alert;
import com.ibm.fah.mongodb.models.User;

/**
 * Object to interact using rest api.
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@SuppressWarnings("deprecation")
public class AlertDTO {

    /* used to send database id */
    private String id;

	@NotEmpty(message = "user_id can not be empty")
    @JsonProperty("user_id")
    private String userId;

    @NotEmpty(message = "location can not be empty")
    @JsonProperty("location")
    private String location;
    
    @JsonProperty("alert_date")
    private String alertDate;

    // getter - setter

    /**
     * We are manually creating {@link AlertDTO} object however there is
     * mapper available to convert to-from {@link User}.
     *
     * @param user
     * @return
     */
    public AlertDTO build(Alert alert) {
        this.id = alert.getId();
        this.userId = alert.getUserId();
        this.location = alert.getLocation();
        StringBuffer stringBuffer = new StringBuffer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
        this.alertDate = simpleDateFormat.format(alert.getAlertDate(), stringBuffer, new FieldPosition(0)).toString();
        return this;
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

	public String getAlertDate() {
		return alertDate;
	}

	public void setAlertDate(String alertDate) {
		this.alertDate = alertDate;
	}
	
}