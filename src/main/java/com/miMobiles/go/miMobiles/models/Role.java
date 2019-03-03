package com.miMobiles.go.miMobiles.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

/**
 * Created by shrey on 2/18/2019.
 */
@Entity
@Table(name = "roles")
public class Role {
    private static final long serialVersionUID = -807421812393096109L;

    @Id
    @Column(name = "id")
    private String id;

    @JsonBackReference("user_role")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userRole")
    private List<User> userList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return id;
    }

    public enum Types {
        admin,customer
    }
}
