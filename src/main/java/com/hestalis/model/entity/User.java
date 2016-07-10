package com.hestalis.model.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Daniel on 2015-10-14.
 */
@Entity
@Table(name = "tbluser")
public class User {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "last_login")
    private Date lastLogin;

    @Column(name = "enabled")
    private Boolean enabled;

    public User() {

    }

    public User(Integer id, String username, String password, Date lastLogin, Boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.lastLogin = lastLogin;
        this.enabled = enabled;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}
