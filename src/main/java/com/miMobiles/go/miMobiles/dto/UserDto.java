package com.miMobiles.go.miMobiles.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.miMobiles.go.miMobiles.models.User;

import javax.validation.constraints.NotNull;

/**
 * Created by shrey on 2/18/2019.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private long id;

    private String name;

    //@NotNull(message = "Mobile number is mandatory")
    private String mobileNumber;

    private String email;

    private String otp;

    @NotNull(message = "Role is mandatory")
    private String role;

    private String metaDataStr;

    private String android;

    private String jwtToken;

    private String password;

    private String city;

    public UserDto(){}

    public UserDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.mobileNumber = user.getMobileNumber();
        this.otp = user.getOtp();
        this.role = user.getUserRole().getId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMetaDataStr() {
        return metaDataStr;
    }

    public void setMetaDataStr(String metaDataStr) {
        this.metaDataStr = metaDataStr;
    }

    public String getAndroid() {
        return android;
    }

    public void setAndroid(String android) {
        this.android = android;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
