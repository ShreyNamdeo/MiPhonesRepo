package com.miMobiles.go.miMobiles.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.miMobiles.go.miMobiles.dto.UserDto;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.Valid;

/**
 * Created by shrey on 2/18/2019.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "otp")
    private String otp;

    @Column(name = "activated", nullable = false)
    private Boolean activated;

    /*@Type(type = "CustomJsonObject")
    @Column(name = "user_meta_data", length = 1000)
    private String metaData;*/

    @Column(name = "android_notification_id")
    private String androidNotificationId;

    @Column(name = "password")
    private String password;

    @JsonManagedReference("user_role")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role userRole;

    @Column(name = "image")
    private String image;

    public User(){}

    public User(@Valid UserDto userDto,Role role) {
        this.id = userDto.getId();
        this.name = userDto.getName();
        this.mobileNumber = userDto.getMobileNumber();
        this.email = userDto.getEmail();
        this.otp = userDto.getOtp();
        this.activated = false;
        this.password = userDto.getPassword();
        this.userRole = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public String getAndroidNotificationId() {
        return androidNotificationId;
    }

    public void setAndroidNotificationId(String androidNotificationId) {
        this.androidNotificationId = androidNotificationId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
