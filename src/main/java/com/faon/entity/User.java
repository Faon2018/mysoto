package com.faon.entity;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//@Data
public class User {
    private int id;
    private Date adate;
    private String username;
    private String password;
    private Date udate;
    private String locked;
    private List<Role> roles =new ArrayList<Role>();


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

    public Date getAdate() {
        return adate;
    }

    public void setAdate(Date adate) {
        this.adate = adate;
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

    public Date getUdate() {
        return udate;
    }

    public void setUdate(Date udate) {
        this.udate = udate;
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