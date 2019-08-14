package com.faon.entity;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//@Data
public class User {
    private int id;
    private Date   insertDate;
    private String username;
    private String password;
    private Date   updateDate;
    private String locked;
    private List<Role> roles;


    public  User(){
        super();
    }
    public User(String username,String password){
        this.username=username;
        this.password=password;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}